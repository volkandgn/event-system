package com.event.system;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.event.system.security.UserSecurity;
import com.event.system.user.model.User;
import com.event.system.user.model.UserDao;

@Controller
public class CommonController {
	
	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	EventService eventService;
	
	@Autowired
	UserDao userdao;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String eventForm(Model model) {
		
		return "login";
	}
	
	@RequestMapping(value = "/register/{id}", method = RequestMethod.GET)
	public String getEvent(Map<String, Object> model, @PathVariable("id") Long id) {

		Event evnt;
		Set<User> registered = new HashSet<User>();	
		User u1 = new User();
//		u1.setUsername("abc3");
//		u1.setEmail("abc3@abc.com");
//		u1.setName("isim3");
//		u1.setPassword("123456");
//		u1.setRole("user");		
		//User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		String username;
		
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
		 username = ((UserDetails)principal).getUsername();
		} else {
		 username = principal.toString();
		}	
		u1=userdao.findByUsername(username);
		
		evnt = eventService.findByEventId(id);	
		registered=evnt.getRegisteredUser();	
		
		registered.add(u1);
		
		
		evnt.setRegisteredUser(registered);
		
		eventRepository.save(evnt);
		
		//model.put("name", evnt);
		return "redirect:/eventlist";
	}

}

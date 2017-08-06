package com.event.system;

import java.util.HashSet;
import java.util.Iterator;
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
import com.event.system.user.model.UserService;

@Controller
public class CommonController {
	
	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	EventService eventService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserDao userdao;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(Model model) {
		
		return "login";
	}
	
	
	@RequestMapping(value = "/register/{id}", method = RequestMethod.GET)
	public String registerEvent(Map<String, Object> model, @PathVariable("id") Long id) {

		Event evnt;
		Set<User> registered = new HashSet<User>();	
		Set<Event> test = new HashSet<Event>();	
		User u1 = new User();
//		u1.setUsername("abc3");
//		u1.setEmail("abc3@abc.com");
//		u1.setName("isim3");
//		u1.setPassword("123456");
//		u1.setRole("user");		
		//User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
//		String username;
//		
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//
//		if (principal instanceof UserDetails) {
//		 username = ((UserDetails)principal).getUsername();
//		} else {
//		 username = principal.toString();
//		}	
		
		String username=userService.findCurrentUserName();
		
		u1=userService.findUserByUsername(username);
		
		evnt = eventService.findByEventId(id);	
		registered=evnt.getRegisteredUser();	
		
		registered.add(u1);
		
		test= u1.getRegisteredEvent();
		
		
		
		evnt.setRegisteredUser(registered);
		
		eventRepository.save(evnt);
		
		
		//model.put("name", evnt);
		//return "event/" + id;
		return "redirect:/event/" + id;
	}
	
	@RequestMapping(value = "/unregister/{id}", method = RequestMethod.GET)
	public String unregisterEvent(Map<String, Object> model, @PathVariable("id") Long id) {
		
		Event evnt;
		User user;
		Set<User> registered = new HashSet<User>();
		Set<Event> test = new HashSet<Event>();	
		
		evnt = eventService.findByEventId(id);
		
		String username=userService.findCurrentUserName();
		user=userService.findUserByUsername(username);
		test=user.getRegisteredEvent();
		
		//test.remove(evnt);
		
		registered=evnt.getRegisteredUser();
		
		registered.remove(user);
		
		eventRepository.save(evnt);
		//userdao.save(user);
		
	
		return "redirect:/event/" + id;
	}
	
	
	
	
	

}

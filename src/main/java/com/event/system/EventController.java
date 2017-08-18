package com.event.system;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.event.system.user.model.User;
import com.event.system.user.model.UserDao;
import com.event.system.user.model.UserService;

@Controller
public class EventController {

	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	EventService eventService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserDao userdao;

	@RequestMapping(value = "event", method = RequestMethod.GET)
	public String eventForm(Model model) {
		model.addAttribute("event", new Event());
		return "eventform";
	}

	@RequestMapping(value = "event", method = RequestMethod.POST)
	public String eventSubmit(@ModelAttribute @Valid Event event2, BindingResult bindingResult, Model model) {
		
//		User u1 = new User();
//		u1.setUsername("abc");
//		u1.setEmail("abc@abc.com");
//		u1.setName("isim");
//		u1.setPassword("123456");
//		u1.setRole("user");
//		userdao.save(u1);
		
		User u1 = new User();
		String username = userService.findCurrentUserName();
		u1= userService.findUserByUsername(username);
		
		event2.setCreatedBy(u1);
		eventRepository.save(event2);
		//showEvents(null);
		return "redirect:/eventlist";
	}

	@RequestMapping(value = "eventlist", method = RequestMethod.GET)
	public String showEvents(Model model) {
		model.addAttribute("events", eventRepository.findAll());
		return "eventlist";
	}
	
	
//	@RequestMapping(value="/event/{name}", method= RequestMethod.GET)
//	public String getEvent(Map<String, Object> model,@PathVariable("name") String name){
//		
//		Event evnt;
//		evnt=eventService.findByEventName(name);
//		
//		model.put("name", evnt);
//		return "eventpage";
//	}

	
	@RequestMapping(value = "/event/{id}", method = RequestMethod.GET)
	public String getEvent(Map<String, Object> model, @PathVariable("id") Long id) {

		Set<Event> userEventList = new HashSet<Event>();	
		Event evnt;
		evnt = eventService.findByEventId(id);
		
		String username=userService.findCurrentUserName();
		
		User currentUser = userService.findUserByUsername(username);
		
		userEventList=currentUser.getRegisteredEvent();
		
		if(userEventList.contains(evnt)==true)
		{
			System.out.println("BULUNDUUUUUUUUU");
			model.put("registered", "var");
		}
		else model.put("registered", "yok");
		
		
		
		model.put("name", evnt);
		return "eventpage";
	}
	
	@RequestMapping(value = "/deleteevent/{id}", method = RequestMethod.GET)
	public String deleteEventById(@PathVariable("id") Long id) {
		try {
			eventRepository.delete(id);
		} catch (Exception e) {
			System.out.println(e);
		}
		return "redirect:/eventlist";
	}

	@RequestMapping(value = "/updateevent/{id}", method = RequestMethod.GET)
	public String updateEventById(Map<String, Object> model, @PathVariable("id") Long id) {
		Event evnt;
		evnt = eventService.findByEventId(id);

		model.put("name", evnt);
		return "updateevent";
	}
	
	@RequestMapping(value = "/updateevent", method = RequestMethod.POST)
	public String UpdatedEventById(@ModelAttribute Event event) {
//		Event evnt;
//		evnt = eventService.findByEventId(id);
//		
		
		eventRepository.save(event);
		//showEvents(null);
		return "redirect:/eventlist";
	}
	
	@RequestMapping(value = "myevents", method = RequestMethod.GET)
	public String showMyEvents(Model model) {
		
		Set<Event> userEventList = new HashSet<Event>();	
		
		String username=userService.findCurrentUserName();
		
		User currentUser = userService.findUserByUsername(username);
		
		userEventList=currentUser.getRegisteredEvent();
		
		model.addAttribute("events", userEventList);
		return "myevents";
	}
	
	@RequestMapping(value = "q/{search}", method = RequestMethod.GET)
	public String searchEvents(Model model,@PathVariable("search") String searchParameter) {
		
//		List<Event> allEvents = (List<Event>) eventRepository.findAll();
//		
//		List<Event> list = (List<Event>) eventRepository.findAll();
//		
//		for (Event o : allEvents) {
//			
//			
//		   
//		}
		model.addAttribute("events", eventService.findBySearch(searchParameter, searchParameter, searchParameter, searchParameter));
		
		return "eventlist";
	}
	
	
	
}

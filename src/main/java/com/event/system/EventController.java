package com.event.system;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EventController {

	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	EventService eventService;

	@RequestMapping(value = "event", method = RequestMethod.GET)
	public String eventForm(Model model) {
		model.addAttribute("event", new Event());
		return "eventform";
	}

	@RequestMapping(value = "event", method = RequestMethod.POST)
	public String eventSubmit(@ModelAttribute Event event) {
		eventRepository.save(event);
		return "eventform";
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

		Event evnt;
		evnt = eventService.findByEventId(id);

		model.put("name", evnt);
		return "eventpage";
	}
	

}

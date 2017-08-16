package com.event.system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerr {

	@Autowired
	EventRepository eventRepository;
	
	@Autowired
	EventService eventService;
	
	
	@RequestMapping(value = "events", method = RequestMethod.GET)
	public List<Event> showEventsAPI(Model model) {
		
		
		return (List<Event>) eventRepository.findAll();
		
	}
	
	@RequestMapping(value = "events/{typeofpaid}", method = RequestMethod.GET)
	public List<Event> showFreeEventsAPI(@PathVariable("typeofpaid") String typeof, Model model) {
		
		
		return (List<Event>) eventService.findByPaidTypeOrEventType(typeof,typeof);
		
	}
	
	@RequestMapping(value = "events/{typeofpaid}/{typeofevent}", method = RequestMethod.GET)
	public List<Event> showEventsTypeWithTypeOfPaid(@PathVariable("typeofpaid") String typeof, @PathVariable("typeofevent") String typeofevent, Model model) {
		
		
		return (List<Event>) eventService.findByTypeOfPaidAndEventType(typeof, typeofevent);
		
	}
	
	
	
	
	
//	@RequestMapping(value = "events", method = RequestMethod.GET)
//	public List showEventsAPI(Model model) {
//		Map map = new HashMap<>();
//		map.put("name", "gloria");
//		map.put("short_description", "iau");
//		map.put("description", "demirtepe");
//		
//		Map map2 = new HashMap<>();
//		map2.put("name", "starbucks");
//		map2.put("short_description", "iau");
//		map2.put("description", "kartaltepe");
//		
//		Map map3 = new HashMap<>();
//		map3.put("name", "kahve dunyası");
//		map3.put("short_description", "iau");
//		map3.put("description", "demirtepe");
//		
//		List list = new ArrayList();
//		list.add(map);
//		list.add(map2);
//		list.add(map3);
//		
//		return  list;
//	}
}

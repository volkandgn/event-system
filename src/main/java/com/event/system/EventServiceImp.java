package com.event.system;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImp implements EventService {
	
	@Autowired
	EventRepository eventRepository;

	@Override
	public Event findByEventName(String eventName) {
		
		return eventRepository.findByEventName(eventName);
	}

	@Override
	public Event findByEventId(Long eventId) {
		// TODO Auto-generated method stub
		return eventRepository.findByEventId(eventId);
	}

	@Override
	public List<Event> findByPaidTypeOrEventType(String freeOrpaid,String typeOfEvent) {
		List<Event> list = eventRepository.findByPaidTypeOrEventType(freeOrpaid,typeOfEvent);
		return list;
	}

	@Override
	public List<Event> findByTypeOfPaidAndEventType(String freeOrpaid, String typeOfEvent) {
		List<Event> list = eventRepository.findByPaidTypeAndEventType(freeOrpaid, typeOfEvent);
		return list;
	}

	@Override
	public List<Event> findBySearch(String eventName, String description, String shortDescription, String eventType) {
		List<Event> list= eventRepository.findByEventNameContainingOrDescriptionContainingOrShortDescriptionContainingOrEventTypeContaining(eventName, description, shortDescription, eventType);
		return list;
	}

}

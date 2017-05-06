package com.event.system;

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

}

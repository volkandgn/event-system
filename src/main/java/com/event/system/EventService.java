package com.event.system;

public interface EventService {
	
	 Event findByEventName(String eventName);
	 Event findByEventId(Long eventId);

}

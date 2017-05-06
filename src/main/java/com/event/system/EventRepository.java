package com.event.system;

import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
		
	 Event findByEventName(String eventName);
	 Event findByEventId(Long eventId);

}

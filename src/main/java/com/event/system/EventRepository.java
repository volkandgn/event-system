package com.event.system;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Long> {
		
	 Event findByEventName(String eventName);
	 Event findByEventId(Long eventId);
	 List<Event> findByPaidTypeOrEventType(String freeOrpaid,String typeOfEvent);
	 List<Event> findByPaidTypeAndEventType(String freeOrpaid,String typeOfEvent);
}

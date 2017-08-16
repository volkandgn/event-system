package com.event.system;

import java.util.List;

public interface EventService {
	
	 Event findByEventName(String eventName);
	 Event findByEventId(Long eventId);
	 List<Event> findByPaidTypeOrEventType(String freeOrpaid,String typeOfEvent);
	 List<Event> findByTypeOfPaidAndEventType(String freeOrpaid,String typeOfEvent);

}

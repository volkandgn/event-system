package com.event.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EventSystemApplication.class, args);
	}

	@Autowired 
	EventRepository eventRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
		Event e1 = new Event();
		
		e1.setEventName("Boş yapma etkinliğidir");
		e1.setShortDescription("Bu Short Description'dır Etkinlik müthiş ya");
		e1.setDescription("Bu Description'dır Etkinlik bilgileri buradadır... Etkinlik bilgileri buradadır...Etkinlik bilgileri buradadır...");
		e1.setLocation("Besyol Gloria");
		//e1.setLimit(50);
		
		eventRepository.save(e1);
		
		e1=new Event();
		e1.setEventName("Hibernate Semineri1");
		e1.setShortDescription("Etkinlik");
		e1.setDescription("Genis kapsamli etkinlik");
		e1.setLocation("Besyol");
		
		eventRepository.save(e1);
		e1=new Event();
		e1.setEventName("Hibernate Semineri2");
		e1.setShortDescription("Etkinlik");
		e1.setDescription("Genis kapsamli etkinlik");
		e1.setLocation("Besyol");
		eventRepository.save(e1);
		
		
	}
}

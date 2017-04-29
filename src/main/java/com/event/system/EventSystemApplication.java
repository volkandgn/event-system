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
		
		e1.setEventName("Hibernate Semineri");
		e1.setShortDescription("Etkinlik");
		e1.setDescription("Genis kapsamli etkinlik");
		e1.setLocation("Besyol");
		//e1.setLimit(50);
		
		eventRepository.save(e1);
		
		e1=new Event();
		e1.setEventName("Hibernate Semineri");
		e1.setShortDescription("Etkinlik");
		e1.setDescription("Genis kapsamli etkinlik");
		e1.setLocation("Besyol");
		
		eventRepository.save(e1);
		e1=new Event();
		e1.setEventName("Hibernate Semineri");
		e1.setShortDescription("Etkinlik");
		e1.setDescription("Genis kapsamli etkinlik");
		e1.setLocation("Besyol");
		eventRepository.save(e1);
		
		
	}
}

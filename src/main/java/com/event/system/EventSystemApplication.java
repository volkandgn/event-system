package com.event.system;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.event.system.user.model.User;

@SpringBootApplication
public class EventSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EventSystemApplication.class, args);
	}

	@Autowired 
	EventRepository eventRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
		Event e1 = new Event();
		
		e1.setEventName("Boş yapma etkinliğidir");
		e1.setShortDescription("Bu Short Description'dır Etkinlik müthiş ya");
		e1.setDescription("Bu Description'dır Etkinlik bilgileri buradadır... Etkinlik bilgileri buradadır...Etkinlik bilgileri buradadır...");
		e1.setLocation("Besyol Gloria");
		//e1.setEventDate(new Date());
		//e1.setLimit(50);
		e1.setGuestLimit(50l);
		e1.setStartHour(new Date());
		
		eventRepository.save(e1);
		
		e1=new Event();
		e1.setEventName("Hibernate Semineri1");
		e1.setShortDescription("Etkinlik");
		e1.setDescription("Genis kapsamli etkinlik");
		e1.setLocation("Besyol");
		
		Date dt = new Date();
		
		Calendar cl;
		e1.setGuestLimit(250l);
		
		
		
		eventRepository.save(e1);
		e1=new Event();
		e1.setEventName("Hibernate Semineri2");
		e1.setShortDescription("Etkinlik");
		e1.setDescription("Genis kapsamli etkinlik");
		e1.setLocation("Besyol");
		e1.setGuestLimit(150l);
		eventRepository.save(e1);
		
		User u1 = new User();
		u1.setUsername("abc");
		u1.setEmail("abc@abc.com");
		u1.setName("isim");
		u1.setPassword("123456");
		u1.setRole("user");
		userRepository.save(u1);
		
	}
}

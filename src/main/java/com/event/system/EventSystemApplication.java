package com.event.system;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.event.system.user.model.Role;
import com.event.system.user.model.User;
import com.event.system.user.model.UserService;

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
		
		
//		Role role_user = new Role();
//		role_user.setRole("user");
		
//		Set<Role> roles = new HashSet<Role>();
//		roles.add(role_user);
		
		Role role = new Role();
		role.setRole("user");
		
		User u1 = new User();
		u1.setUsername("admin");
		u1.setEmail("admin@eventsystem.com");
		u1.setName("Volkan");
		u1.setSurname("Dogan");
		u1.setPassword("123456");
		u1.setRole("admin");
		//userRepository.save(u1);
		
		User u2 = new User();
		u2.setUsername("user");
		u2.setEmail("user1@eventsystem.com");
		u2.setName("Ugurcan");
		u2.setSurname("Lacin");
		u2.setPassword("123456");
		u2.setRole("user");
		
		Set<User> registered = new HashSet<User>();
		
		Event e1 = new Event();
			
		
		e1.setEventName("Event-1");
		e1.setShortDescription("Event-1 Short Description");
		e1.setDescription("Event-1 Description...");
		e1.setLocation("Event-1 Location");
		//e1.setEventDate(new Date());
		//e1.setLimit(50);
		e1.setGuestLimit(50l);
		//e1.setCreatedBy(u1);
		e1.setStartHour(new Date());
		e1.setPaidType("free");
		e1.setEventType("fun");
		
		eventRepository.save(e1);
		
		e1=new Event();
		e1.setEventName("Event-2");
		e1.setShortDescription("Event-2 Short Description");
		e1.setDescription("Event-2 Description...");
		e1.setLocation("Event-2 Location");
		e1.setPaidType("free");
		e1.setEventType("education");
		
		Date dt = new Date();
		
		Calendar cl;
		e1.setGuestLimit(250l);
		
		
		
		eventRepository.save(e1);
		e1=new Event();
		e1.setEventName("Event-3");
		e1.setShortDescription("Event-3 Short Description");
		e1.setDescription("Event-3 Description...");
		e1.setLocation("Event-3 Location");
		e1.setGuestLimit(150l);
		e1.setPaidType("paid");
		e1.setEventType("education");
		
//		registered.add(u1); 
//		registered.add(u2);
//		
//		e1.setRegisteredUser(registered);
		
		userRepository.save(u1);
		userRepository.save(u2);
		
		eventRepository.save(e1);
		
		
		
		
		
//		e1.setDescription("dar kapsamli etkinlik");
//		eventRepository.save(e1);
		
		
		u2.setPassword("654321");
		//userRepository.save(u1);
		
		//userRepository.save(u2);
		
		e1=new Event();
		e1.setEventName("Event-4");
		e1.setShortDescription("Event-4 Short Description");
		e1.setDescription("Event-4 Description...");
		e1.setLocation("Event-4 Location");
		e1.setGuestLimit(150l);
		e1.setPaidType("paid");
		e1.setEventType("education");
		eventRepository.save(e1);
		
		e1=new Event();
		e1.setEventName("Event-5");
		e1.setShortDescription("Event-5 Short Description");
		e1.setDescription("Event-5 Description...");
		e1.setLocation("Event-5 Location");
		e1.setGuestLimit(150l);
		e1.setPaidType("paid");
		e1.setEventType("education");
		eventRepository.save(e1);
		
		e1=new Event();
		e1.setEventName("Event-6");
		e1.setShortDescription("Event-6 Short Description");
		e1.setDescription("Event-6 Description...");
		e1.setLocation("Event-6 Location");
		e1.setGuestLimit(150l);
		e1.setPaidType("free");
		e1.setEventType("fun");
		eventRepository.save(e1);
		
		e1=new Event();
		e1.setEventName("Event-7");
		e1.setShortDescription("Event-7 Short Description");
		e1.setDescription("Event-7 Description...");
		e1.setLocation("Event-7 Location");
		e1.setGuestLimit(150l);
		e1.setPaidType("paid");
		e1.setEventType("sport");
		eventRepository.save(e1);
		
		e1=new Event();
		e1.setEventName("Event-8");
		e1.setShortDescription("Event-8 Short Description");
		e1.setDescription("Event-8 Description...");
		e1.setLocation("Event-8 Location");
		e1.setGuestLimit(150l);
		e1.setPaidType("free");
		e1.setEventType("music");
		eventRepository.save(e1);
		
		e1=new Event();
		e1.setEventName("Event-9");
		e1.setShortDescription("Event-9 Short Description");
		e1.setDescription("Event-9 Description...");
		e1.setLocation("Event-9 Location");
		e1.setGuestLimit(150l);
		e1.setPaidType("free");
		e1.setEventType("sport");
		eventRepository.save(e1);
		
	}
}

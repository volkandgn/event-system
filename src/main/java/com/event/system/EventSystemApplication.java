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
		u1.setUsername("abc");
		u1.setEmail("abc@abc.com");
		u1.setName("isim");
		u1.setPassword("123456");
		u1.setRole("user");
		//userRepository.save(u1);
		
		User u2 = new User();
		u2.setUsername("abc2");
		u2.setEmail("abc2@abc.com");
		u2.setName("isim2");
		u2.setPassword("123456");
		u2.setRole("user");
		
		Set<User> registered = new HashSet<User>();
		
		Event e1 = new Event();
			
		
		e1.setEventName("Boş yapma etkinliğidir");
		e1.setShortDescription("Bu Short Description'dır Etkinlik müthiş ya");
		e1.setDescription("Bu Description'dır Etkinlik bilgileri buradadır... Etkinlik bilgileri buradadır...Etkinlik bilgileri buradadır...");
		e1.setLocation("Besyol Gloria");
		//e1.setEventDate(new Date());
		//e1.setLimit(50);
		e1.setGuestLimit(50l);
		//e1.setCreatedBy(u1);
		e1.setStartHour(new Date());
		e1.setPaidType("free");
		e1.setEventType("fun");
		
		eventRepository.save(e1);
		
		e1=new Event();
		e1.setEventName("Hibernate Semineri1");
		e1.setShortDescription("Etkinlik");
		e1.setDescription("Genis kapsamli etkinlik");
		e1.setLocation("Besyol");
		e1.setPaidType("free");
		e1.setEventType("education");
		
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
		e1.setPaidType("paid");
		e1.setEventType("education");
		
		registered.add(u1);
		registered.add(u2);
		
		e1.setRegisteredUser(registered);
		
		eventRepository.save(e1);
//		e1.setDescription("dar kapsamli etkinlik");
//		eventRepository.save(e1);
		
		
		u2.setPassword("654321");
		//userRepository.save(u1);
		
		//userRepository.save(u2);
		
		
		
		
		
		
		
	}
}

package com.event.system.user.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public String findCurrentUserName() {

		String username;

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
		} else {
			username = principal.toString();
		}
		return username;
	}

	@Override
	public User findUserByUsername(String username) {
		
		return userDao.findByUsername(username);
	}

}

package com.event.system.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.event.system.user.model.User;
import com.event.system.user.model.UserDao;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserDao userDao;
	
	@Autowired
	public CustomUserDetailsService(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserSecurity loadUserByUsername(String username)
			throws UsernameNotFoundException {
		User user = userDao.findByUsername(username);
		return new UserSecurity(user);
	}

}
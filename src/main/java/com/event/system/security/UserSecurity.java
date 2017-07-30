package com.event.system.security;

import org.springframework.security.core.authority.AuthorityUtils;

import com.event.system.user.model.User;



public class UserSecurity extends org.springframework.security.core.userdetails.User {
	private User user;
	

	public UserSecurity(User user) {
		super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public Long getId() {
		return user.getId();
	}

	public String getRole() {
		return user.getRole();
	}
}
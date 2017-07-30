package com.event.system.user.model;

public interface UserService {
	
	String findCurrentUserName();
	User findUserByUsername(String username);

}

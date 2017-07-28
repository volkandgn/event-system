package com.event.system.user.model;

import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long>{
	public User findByUsername(String username);
	public User findByUsernameAndPassword(String username,String password);
}

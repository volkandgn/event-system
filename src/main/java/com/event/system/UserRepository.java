package com.event.system;

import org.springframework.data.repository.CrudRepository;

import com.event.system.user.model.User;

public interface UserRepository extends CrudRepository<User, Long>{

}

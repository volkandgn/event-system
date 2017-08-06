package com.event.system.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.event.system.user.model.Role;
import com.event.system.user.model.User;
import com.event.system.user.model.UserDao;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserDao userDao;

	@Autowired
	public CustomUserDetailsService(UserDao userDao) {
		this.userDao = userDao;
	}

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userDao.findByUsername(username);
//		/* eklenen kod */
//		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		String password = user.getPassword();
//		//enabled = user.isActive();
//		List<Role> roles = user.getRoles();
//		for (Object role : roles) {
//			authorities.add(new GrantedAuthorityImpl(((Role) role).getRole()));
//		}
//		return new org.springframework.security.core.userdetails.User(username, password, enabled, true, true, true,
//				authorities);
//	}

	 @Override
	 public UserSecurity loadUserByUsername(String username)
	 throws UsernameNotFoundException {
	 User user = userDao.findByUsername(username);
	 return new UserSecurity(user);
	 }

}
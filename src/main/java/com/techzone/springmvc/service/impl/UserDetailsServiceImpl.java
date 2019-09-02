package com.techzone.springmvc.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.techzone.springmvc.entity.Role;
import com.techzone.springmvc.entity.User;
import com.techzone.springmvc.repository.UserRepository;

@Component("userDetailService")
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		
		User user = userRepository.findByUsername(username);
		
		System.out.println("Id Of User : " + user.getId());
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
 		for (Role role : user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName().toString()));
			System.out.println("Role : " + role.getRoleName());
		}

//		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}

}

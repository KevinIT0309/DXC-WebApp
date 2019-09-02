package com.techzone.springmvc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techzone.springmvc.entity.Role;
import com.techzone.springmvc.repository.RoleRepository;
import com.techzone.springmvc.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	@Transactional
	public List<Role> getRoles() {
		return roleRepository.findAll();
	}

}

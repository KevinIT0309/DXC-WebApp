package com.techzone.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techzone.springmvc.entity.Role;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role,Integer> {

}

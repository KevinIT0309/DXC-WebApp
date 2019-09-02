package com.techzone.springmvc.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "rolename" , nullable = false)
	private RoleName roleName;
	
//	@ManyToMany(fetch = FetchType.LAZY,
//			cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
//	@JoinTable(
//		name = "user_role",
//		joinColumns = @JoinColumn(name="user_id"),
//		inverseJoinColumns = @JoinColumn(name="role_id")
//		)
	
	@ManyToMany(mappedBy = "roles" /* , cascade = {CascadeType.PERSIST , CascadeType.MERGE} */)
	private Set<User> users;

	public Role() {
		
	}
	
	public Role(RoleName roleName) {
		super();
		this.roleName = roleName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RoleName getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
}

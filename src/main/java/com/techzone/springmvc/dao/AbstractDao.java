package com.techzone.springmvc.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class AbstractDao < K extends Serializable , V > { // Key - Value
	
	private final Class <V> persistentClass;
	
//	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<V>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public V getById(K id) {
		return getSession().get(persistentClass, id);
	}
	

}

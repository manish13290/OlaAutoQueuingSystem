/**
 * 
 */
package com.youplus.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Manish
 *
 */
public abstract class GenericDaoImpl<E, K extends Serializable> implements GenericDao<E, K> {
	@Autowired
	private SessionFactory sessionFactory;

	protected Class<? extends E> daoType;

	/**
	 * By defining this class as abstract, we prevent Spring from creating
	 * instance of this class If not defined as abstract,
	 * getClass().getGenericSuperClass() would return Object. There would be
	 * exception because Object class does not hava constructor with parameters.
	 */
	public GenericDaoImpl() {
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType) t;
		daoType = (Class) pt.getActualTypeArguments()[0];
	}

	protected Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(E entity) {
		currentSession().save(entity);
	}

	@Override
	public void saveOrUpdate(E entity) {
		currentSession().saveOrUpdate(entity);
	}

	@Override
	public void update(E entity) {
		currentSession().saveOrUpdate(entity);
	}

	@Override
	public void remove(E entity) {
		currentSession().delete(entity);
	}

	@Override
	public E find(K key) {
		return currentSession().get(daoType, key);
	}

	@Override
	public List<E> getAll() {
		return currentSession().createCriteria(daoType).list();
	}
}

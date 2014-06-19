package com.mcl.backend.core.persistence.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Generic DAO (Data Access Object) with common methods to CRUD POJOs.
 * 
 * <p>
 * Extend this interface if you want typesafe (no casting necessary) DAO's for
 * your domain objects.
 * 
 * @param <T>
 * a type variable
 * @param <PK>
 * the primary key for that type
 * 
 * @author vishnu-p
 */
public interface GenericDao<T, PK extends Serializable> {

	/**
	 * Generic method used to get all objects of a particular type. This is the
	 * same as lookup up all rows in a table.
	 * 
	 * @return List of populated objects
	 */
	List<T> getAll();

	/**
	 * Generic method to get an object based on class and identifier. An
	 * ObjectRetrievalFailureException Runtime Exception is thrown if nothing is
	 * found.
	 * 
	 * @param id
	 * the identifier (primary key) of the object to get
	 * @return a populated object
	 * @see org.springframework.orm.ObjectRetrievalFailureException
	 */
	T get(PK id);

	/**
	 * Generic method to save an object - handles both update and insert.
	 * 
	 * @param object
	 * the object to save
	 * @return the persisted object
	 */
	T save(T object);

	/**
	 * Generic method to save an object - handles both update and insert.
	 * 
	 * @param object
	 * the object to save
	 * @return the persisted object
	 */
	boolean update(T object);	

	/**
	 * Generic method to delete an object
	 * 
	 * @param id
	 * the identifier (primary key) of the object to remove
	 */
	void remove(PK id);
}
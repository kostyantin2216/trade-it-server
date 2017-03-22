package com.charlieaffs.data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface CommonDao<E extends DataModelObject> extends HibernateDao {

	/**
	 * @param entity The entity to save.
	 * @return The saved entities id or null.
	 */
	Serializable save(E entity);
	
	/**
	 * @param entities The entity to save.
	 * @return The saved entities id's or null.
	 */
	List<Serializable> save(List<E> entities);
	
	/**
	 * @param entity The entity to look for.
	 * @return Integer -1 if error occurred, 0 if false, 1 if true.
	 */
	Integer contains(E entity);
	
	void update(E entity);
	void delete(Serializable id);
	E findById(Serializable id);
	
	/**
	 * 	Caution can return null if no entities can be found.
	 */
	E findEntityByProperty(String property, Object value);

	List<E> findByProperty(String property, Object value);
	List<E> findByMap(Map<String, Object> properties);
	List<E> findAll();	
	int getCount();
	String getTableName();
	String getClassName();

}
package com.charlieaffs.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.NonUniqueObjectException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.type.Type;
import org.springframework.transaction.annotation.Transactional;

import com.charlieaffs.ifs.logging.TILogger;

@Transactional
public abstract class BaseDao<E extends DataModelObject> extends HibernateDaoImpl implements CommonDao<E> {
	
	private final static String ALIAS = "_this";
	
	@Override
	public Serializable save(E entity) {
		Session session = getSession();
		return session.save(entity);
	}
	
	@Override
	public List<Serializable> save(List<E> entities) {
		List<Serializable> savedEntitiesIds = new ArrayList<>();
		Session session = getSession();
		for(int i = 0; i < entities.size(); i++) {
			E entity = entities.get(i);
			try {
				savedEntitiesIds.add(session.save(entity));
			} catch(NonUniqueObjectException ex) {
				TILogger.getLog().warn("Entity( " + entity + ") #" + i + " in table " + getTableName() + " is not unique", ex);
			}
		}
		return savedEntitiesIds;
	}

	@Override
	public void update(E entity) {
		getSession().update(entity);
	}
	
	@Override
	public void delete(Serializable id) {
        Session session = getSession();
        session.delete(session.get(getClassName(), id));
	}
	
	@Override
	public E findEntityByProperty(String property, Object value) {
		Map<String, Object> props = new HashMap<>();
		props.put(property, value);
		List<E> l = findByMap(props);
		if(l != null && !l.isEmpty()) {
			return l.get(0);
		}
		return null;
	}
	
	@Override
	public List<E> findByProperty(String property, Object value) {
		Map<String, Object> props = new HashMap<>();
		props.put(property, value);
		return findByMap(props);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<E> findByMap(Map<String,Object> properties) {
		Query query = createQuery(properties);
		return query.list();
	}
	
	public Query createQuery(Map<String, Object> properties) {
		String tableName = getTableName();
		
		String hqlQuery = "from " + tableName + " as " + ALIAS + " where ";

		Iterator<Map.Entry<String, Object>> iterator = properties.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Object> entry = iterator.next();
			hqlQuery += ALIAS + "." + entry.getKey() + " = :" + entry.getKey();
			if(iterator.hasNext()) {
				hqlQuery += " and ";
			}
		}
		
		TILogger.getLog().debug("Created hql query: " + hqlQuery);
		
		Query query = getSession().createQuery(hqlQuery);
		
		try {
			iterator = properties.entrySet().iterator();
			while(iterator.hasNext()) {
				Map.Entry<String, Object> entry = iterator.next();
				query.setParameter(entry.getKey(), entry.getValue());
				Type propertyType = getPropertyType(getClassName(), entry.getKey());
				/*switch(propertyType.getReturnedClass().getName()) {
					case "java.lang.String":
						query.setString(index, (String) entry.getValue());
						break;
					case "java.lang.Boolean": 
						String boolValue = entry.getValue().toString();
						query.setBoolean(index, boolValue != null && 
								(boolValue.equalsIgnoreCase("true") || boolValue.equals("1")));
						break;
					case "java.lang.Integer":
						query.setInteger(index, (Integer) entry.getValue());
						break;
					case "java.util.Date": case "java.sql.Timestamp":
						query.setDate(index, (Date) entry.getValue());
						break;
				}
				index++;*/
			}
		} catch (ClassNotFoundException e) {
			TILogger.getLog().error("Could not get class with class name: " + getClassName(), e);
			return null;
		}
		
		return query;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E findById(Serializable id) {
        Session session = getSession();
        return (E) session.get(getClassName(), id);
	}
	
	@Override
	public List<E> findAll() {
		return findAll(false);
	}

	@SuppressWarnings("unchecked")
	public List<E> findAll(Boolean activeOnly) {
        return getSession().createQuery("from " + getClassName()).list();
	}
	
	@Override
	public Integer contains(E entity) {
		Integer result = -1;
		Session session = getSession();
		try {
			Object obj = session.get(Class.forName(getClassName()), entity.getSerializedId());
			result = obj == null ? 0 : 1;
		} catch (ClassNotFoundException e) {
			TILogger.getLog().error("Could not find class for name " + getClassName(), e);
		}
		return result;
	}
	
	@Override
	public int getCount() {
		Integer iCount = null;
		Number count = ((Number) getSession().createQuery("select count(*) from " + getTableName()).uniqueResult());
		if (count != null) {
			iCount = count.intValue();
		}
		return iCount;
	}
	
}


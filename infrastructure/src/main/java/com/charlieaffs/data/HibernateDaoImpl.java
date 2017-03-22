package com.charlieaffs.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;

public class HibernateDaoImpl implements HibernateDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public Type getPropertyType(String className, String name) throws ClassNotFoundException {
    	return getPropertyType(Class.forName(className), name);
    }
    
	@Override
    public Type getPropertyType(Class<?> clazz, String name) {
    	return getPropertyType(getClassMetadata(clazz), name);
    }
    
	@Override
    public Type getPropertyType(ClassMetadata metaData, String name) throws HibernateException {
    	try{
    		return  metaData.getPropertyType(name);
    	} catch(HibernateException he) {
    		if(name.equalsIgnoreCase(metaData.getIdentifierPropertyName())) 
    			return metaData.getIdentifierType();
    		
    		String[] names = metaData.getPropertyNames();
    		for(int i=0;i<names.length;i++){
    			if(names[i].equalsIgnoreCase(name))
    				return metaData.getPropertyType(names[i]);
    		}
    		throw he;
    	}
    }
    
	@Override
    public ClassMetadata getClassMetadata(Class<?> clazz) {
		return sessionFactory.getClassMetadata(clazz);
    }
    
	@Override
    public ClassMetadata getClassMetadata(String className) {
    	return sessionFactory.getClassMetadata(className);
    }
	
}

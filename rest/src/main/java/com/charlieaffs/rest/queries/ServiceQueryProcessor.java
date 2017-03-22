package com.charlieaffs.rest.queries;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.type.Type;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.charlieaffs.data.CommonDao;
import com.charlieaffs.data.DataModelObject;
import com.charlieaffs.ifs.logging.TILogger;
import com.charlieaffs.rest.exceptions.IllegalQueryOperandException;
import com.charlieaffs.rest.exceptions.IllegalQueryValueException;

@Transactional
@Component("queryProcessor")
public class ServiceQueryProcessor<E extends DataModelObject> implements ServiceQueryProcess<E> {
	
	private CommonDao<E> dao;
	
	public ServiceQueryProcessor() { }
	
	public ServiceQueryProcessor(CommonDao<E> dao) {
		this.dao = dao;
	}
	
	public void setDao(CommonDao<E> dao) {
		this.dao = dao;
	}
	
	@SuppressWarnings("unchecked")
	public List<E> process(List<ServiceQuery> queries) {
		TILogger.getLog().info("Processing queries: " + queries.toArray().toString());
		
		Criteria crit = dao.getSession().createCriteria(dao.getClassName());
		for(ServiceQuery query : queries) {
			TILogger.getLog().info("Getting criterion for query: " + query.toString());
			Criterion criterion = getCriterion(query);
			if(criterion != null) {
				TILogger.getLog().info("Adding criterion: " + criterion.toString());
				crit.add(criterion);
			}
		}
		TILogger.getLog().info("Getting list for criteria: " + crit.toString());
		List<E> l = crit.list();
		
		TILogger.getLog().info("Results from criteria: " + l.toArray().toString());
		
		return l;
	}
	
	private Criterion getCriterion(ServiceQuery query) throws IllegalQueryOperandException {
		Object value = getQueryValueByType(query);
		
		if(value != null) {
			switch(query.getOp()) {
				case ">":
					return Restrictions.gt(query.getProp(), value);
				case ">=": case "=>":
					return Restrictions.ge(query.getProp(), value);
				case "<":
					return Restrictions.lt(query.getProp(), value);
				case "<=": case "=<":
					return Restrictions.le(query.getProp(), value);
				case "=":
					return Restrictions.eq(query.getProp(), value);
				case "!=":
					return Restrictions.ne(query.getProp(), value);
				default:
					throw new IllegalQueryOperandException("ServiceQuery operand \"" + query.getOp() + "\" is illegal.");
			}
		}
			
		return null;
	}
	
	private Object getQueryValueByType(ServiceQuery query) throws IllegalQueryValueException {
		ClassMetadata meta = dao.getClassMetadata(dao.getClassName());
		if(meta != null) {
			Type type = dao.getPropertyType(meta, query.getProp());
			String value = query.getVal();
			
			switch(type.getReturnedClass().getName()) {
				case "java.lang.String":
					return value;
				case "java.lang.Boolean":
					if(value.equalsIgnoreCase("true") || value.equals("1"))
						return Boolean.TRUE;
					else if(value.equalsIgnoreCase("false") || value.equals("0")) 
						return Boolean.FALSE;
					else
						throw new IllegalQueryValueException("ServiceQuery value \"" + value + "\" must be of type java.lang.Boolean");
				case "java.lang.Integer":
					if(value.matches("^(-?)\\d+$"))
						return Integer.parseInt(value);
					else
						throw new IllegalQueryValueException("ServiceQuery value \"" + value + "\" must be of type java.lang.Integer");
				case "java.util.Date": case "java.sql.Timestamp":
					if(value.matches("\\d+")) 
						return new Timestamp(Long.parseLong(value));
					else
						try {
							return new Timestamp(DateFormat.getInstance().parse(value).getTime());
						} catch (ParseException e) {
							throw new IllegalQueryValueException("ServiceQuery value \"" + value + "\" cannot be parsed into a date", e);
						}
			}
		}
		return null;
	}
}

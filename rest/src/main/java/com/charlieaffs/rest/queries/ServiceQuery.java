package com.charlieaffs.rest.queries;

public class ServiceQuery {
	
	private String prop;
	private String op;
	private String val;
	
	public ServiceQuery() { }
	
	public ServiceQuery(String field, String operand, String value) {
		this.prop = field;
		this.op = operand;
		this.val = value;
	}

	public String getProp() {
		return prop;
	}

	public void setProp(String property) {
		this.prop = property;
	}

	public String getOp() {
		return op;
	}

	public void setOp(String operand) {
		this.op = operand;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String value) {
		this.val = value;
	}

	@Override
	public String toString() {
		return "ServiceQuery [" + prop + " \"" + op + "\" " + val +"]";
	}
	
}

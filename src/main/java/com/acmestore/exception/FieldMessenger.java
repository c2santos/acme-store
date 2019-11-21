package com.acmestore.exception;

import java.io.Serializable;

public class FieldMessenger implements Serializable{

	private static final long serialVersionUID = 1L;

	private String fieldname;
	private String message;
	
	public FieldMessenger() {
		super();
	}

	public FieldMessenger(String fieldname, String message) {
		super();
		this.fieldname = fieldname;
		this.message = message;
	}

	public String getFieldname() {
		return fieldname;
	}

	public void setFieldname(String fieldname) {
		this.fieldname = fieldname;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}

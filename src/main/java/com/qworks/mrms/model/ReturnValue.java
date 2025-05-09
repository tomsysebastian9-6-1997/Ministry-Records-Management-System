package com.qworks.mrms.model;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReturnValue extends Throwable{

	private Date timestamp;
	private int status;
	private String error;
	private String message;
	private ErrorDetailsModel details;
	private String path;
	
	public ReturnValue(Date timestamp, int status, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}

	public ReturnValue(Date timestamp, int status, String error, String message, ErrorDetailsModel details, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.details = details;
		this.path = path;
	}
	
	
}

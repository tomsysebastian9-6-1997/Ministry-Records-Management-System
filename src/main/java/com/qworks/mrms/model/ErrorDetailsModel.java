package com.qworks.mrms.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorDetailsModel {
	private String field;
	private String message;
	
	public ErrorDetailsModel(String field, String message) {
		super();
		this.field = field;
		this.message = message;
	}
	
	
}

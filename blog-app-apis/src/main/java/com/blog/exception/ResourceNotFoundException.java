package com.blog.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	String resourceName;
	
	String feildName;
	
	long feildValue;

	public ResourceNotFoundException(String resourceName, String feildName, long feildValue) {
		//super(String.format("%s not found with %s :%s", resourceName,feildValue));
		super(String.format("%s not found with %s:%s",resourceName,feildName,feildValue));
		this.resourceName = resourceName;
		this.feildName = feildName;
		this.feildValue = feildValue;
	}

	public ResourceNotFoundException() {
		super();
	}
	
	

}

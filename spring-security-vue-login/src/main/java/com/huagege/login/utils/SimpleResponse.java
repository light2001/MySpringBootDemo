package com.huagege.login.utils;

public class SimpleResponse {
	
	public SimpleResponse(Object content){
		this.content = content;
	}
	
	private Object content;

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
	
}
package com.aliergul.chatapp.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class Users implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5139403260151725518L;
	private String id;
	private String name;
	private String surname;
	private LocalDateTime createDate;
	
	public Users(String name, String surname) {
		this.id = UUID.randomUUID().toString().replace("-", "");
		this.name = name;
		this.surname = surname;
		this.createDate = LocalDateTime.now();
	}
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", surname=" + surname + ", createDate=" + createDate + "]";
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getId() {
		return id;
	}
	
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	
}

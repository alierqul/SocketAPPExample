package com.aliergul.chatapp.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

public class Messages implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 446278653642285920L;
	private String id;
	private String text;
	private LocalDateTime logDate;
	private Users sendUser;
	
	public Messages(String text, Users sendUser) {
		this.id = UUID.randomUUID().toString().replace("-", "");
		this.text = text;
		this.sendUser = sendUser;
		this.logDate = LocalDateTime.now();
	}
	
	@Override
	public String toString() {
		return "Messages [id=" + id + ", text=" + text + ", logDate=" + logDate + ", sendUser=" + sendUser + "]";
	}
	
	public String getId() {
		return id;
	}
	
	public String getText() {
		return text;
	}
	
	public LocalDateTime getLogDate() {
		return logDate;
	}
	
	public Users getSendUser() {
		return sendUser;
	}
	
}

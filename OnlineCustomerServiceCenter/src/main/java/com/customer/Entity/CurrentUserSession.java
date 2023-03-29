package com.customer.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class CurrentUserSession {
	
	@Id
	@Column(unique = true)
	private int Id;
	
	private String uuid;
	
	private LocalDateTime timestamp;
	
	private String User_Type;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getUser_Type() {
		return User_Type;
	}

	public void setUser_Type(String User_Type) {
		this.User_Type = User_Type;
	}

	public CurrentUserSession() {
		super();
	}
	
	

	public CurrentUserSession(int id, String uuid, LocalDateTime timestamp, String User_Type) {
		super();
		Id = id;
		this.uuid = uuid;
		this.timestamp = timestamp;
		this.User_Type = User_Type;
	}

	@Override
	public String toString() {
		return "CurrentUserSession [Id=" + Id + ", uuid=" + uuid + ", timestamp=" + timestamp + ", User_Type="
				+ User_Type + "]";
	}
	
	
	

}

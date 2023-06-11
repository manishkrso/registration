package com.soni.app.registration.entity;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ActivationToken {
	@Id
	@GeneratedValue
	UUID tokeId;
	UUID userId;
	Boolean isValid;
	Date createdAt;
	public UUID getTokeId() {
		return tokeId;
	}
	public void setTokeId(UUID tokeId) {
		this.tokeId = tokeId;
	}
	public UUID getUserId() {
		return userId;
	}
	public void setUserId(UUID userId) {
		this.userId = userId;
	}
	public Boolean getIsValid() {
		return isValid;
	}
	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public ActivationToken(UUID tokeId, UUID userId, Boolean isValid, Date createdAt) {
		super();
		this.tokeId = tokeId;
		this.userId = userId;
		this.isValid = isValid;
		this.createdAt = createdAt;
	}
	public ActivationToken() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "ActivationToken [tokeId=" + tokeId + ", userId=" + userId + ", isValid=" + isValid + ", createdAt="
				+ createdAt + "]";
	}
	
	
	
}

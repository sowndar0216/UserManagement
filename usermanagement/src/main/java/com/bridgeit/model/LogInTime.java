package com.bridgeit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="LogInTime")
public class LogInTime {


	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	
	

	@Column(name="lastloginStamp")
	@DateTimeFormat(style = "dd-MM-yyy HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="dd-MM-yyyy HH:mm:ss")
	private Date lastloginStamp;
	
	
	@Column(name="userId")
	private Integer userId;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getLastloginStamp() {
		return lastloginStamp;
	}


	public void setLastloginStamp(Date lastloginStamp) {
		this.lastloginStamp = lastloginStamp;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "LogInTime [id=" + id + ", lastloginStamp=" + lastloginStamp + ", userId=" + userId + "]";
	}

	
	
	
	
}

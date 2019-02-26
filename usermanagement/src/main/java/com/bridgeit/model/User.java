package com.bridgeit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="User")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "first_Name")
	private String firstName;
	
	@Column(name="middle_Name ")
	private String middleName; 
	
	@Column(name="last_Name")
	private String lastName;
	
	@Column(name="gender")
	private String gender;

	@Column(name="country")
	private String Country  ;
	
	@Column(name="phone_number")
	private String phone;
	
	@Column(name="phone_Ext")
	private String phone_Ext;
	
	
	@Column(name="date_of_birth")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(style = "dd-MM-yyy")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="dd-MM-yyyy")
	private Date date_of_birth;
	
	@Column(name="email")
	private String email;
	
	@Column(name="address")
	private String address;
	
	@Column(name="userName ")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	
	
	@Column(name="status")
	private boolean status;
	
	@Column(name="createdStamp")
	@DateTimeFormat(style = "dd-MM-yyy HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="dd-MM-yyyy HH:mm:ss")
	private Date createdStamp;
	
	@Column(name="lastloginStamp")
	@DateTimeFormat(style = "dd-MM-yyy HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="dd-MM-yyyy HH:mm:ss")
	private Date lastloginStamp;
	
	@Column(name="lastupdStamp")
	@DateTimeFormat(style = "dd-MM-yyy HH:mm:ss")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern ="dd-MM-yyyy HH:mm:ss")
	private Date lastupdStamp;
	
	@Column(name="role")
	private String role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone_Ext() {
		return phone_Ext;
	}

	public void setPhone_Ext(String phone_Ext) {
		this.phone_Ext = phone_Ext;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getCreatedStamp() {
		return createdStamp;
	}

	public void setCreatedStamp(Date createdStamp) {
		this.createdStamp = createdStamp;
	}

	public Date getLastloginStamp() {
		return lastloginStamp;
	}

	public void setLastloginStamp(Date lastloginStamp) {
		this.lastloginStamp = lastloginStamp;
	}

	public Date getLastupdStamp() {
		return lastupdStamp;
	}

	public void setLastupdStamp(Date lastupdStamp) {
		this.lastupdStamp = lastupdStamp;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
				+ ", gender=" + gender + ", Country=" + Country + ", phone=" + phone + ", phone_Ext=" + phone_Ext
				+ ", date_of_birth=" + date_of_birth + ", email=" + email + ", address=" + address + ", userName="
				+ userName + ", password=" + password  + ", status=" + status
				+ ", createdStamp=" + createdStamp + ", lastloginStamp=" + lastloginStamp + ", lastupdStamp="
				+ lastupdStamp + ", role=" + role + "]";
	}
	
	
	
}

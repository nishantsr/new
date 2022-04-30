package com.cybage.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.NonNull;
@Entity
public class Users {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	@NotNull
	@NotEmpty(message="Username cannot be empty")
	private String username;
	@NotNull
	@NotEmpty(message="Firstname cannot be empty")
	private String firstName;
	@NotNull
	@NotEmpty(message="Lastame cannot be empty")
	private String lastName;
	@NotNull
	@NotEmpty(message="Password cannot be empty")
	private String password;
	@NotNull
	@NotEmpty(message="EmailID cannot be empty")
	private String emailId;
	@NotNull
	@NotEmpty(message="Mobile cannot be empty")
	private String mobile;
	@NotNull
	@NotEmpty(message="Role cannot be empty")
	private String role;
	public Users() {
		super();
	}
	public Users(int userId, @NotNull @NotEmpty(message = "Username cannot be empty") String username,
			@NotNull @NotEmpty(message = "Firstname cannot be empty") String firstName,
			@NotNull @NotEmpty(message = "Lastame cannot be empty") String lastName,
			@NotNull @NotEmpty(message = "Password cannot be empty") String password,
			@NotNull @NotEmpty(message = "EmailID cannot be empty") String emailId,
			@NotNull @NotEmpty(message = "Mobile cannot be empty") String mobile,
			@NotNull @NotEmpty(message = "Role cannot be empty") String role) {
		super();
		this.userId = userId;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.emailId = emailId;
		this.mobile = mobile;
		this.role = role;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", username=" + username + ", firstName=" + firstName + ", lastName="
				+ lastName + ", password=" + password + ", emailId=" + emailId + ", mobile=" + mobile + ", role=" + role
				+ "]";
	}
	
	
	
	
}

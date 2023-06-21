package com.onerivet.userdetails.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UserInfo")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public int id;
	
	@Column(name = "FirstName")
	public String firstName;
	
	@Column(name = "LastName")
	public String lastName;
	
	@Column(name = "EmailId")
	public String userName;
	
	@Column(name = "PhoneNo")
	public int phoneNo;
	
	@Column(name = "Password")
	public String password;

	@Column(name = "Role")
	public String role;


}

package io.javaee.hibernateDemo.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name= "USER_DETAILS")
public class UserDetails {
	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private int userID;
	@Column(name="USER_NAME")
	private String userName;
	@Column(name="JOIN_DATE")
	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	@Column(name="ADDRESS")
	private String address;
	@Transient
	private int age;
	@Column(name = "DESCRIPTION")
	@Lob 
	private String description;
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}

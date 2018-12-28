package io.javaee.hibernateDemo.crud.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@NamedQuery(name = "UserDetails.byID",query = "from UserDetails where userID = ?0") 
@NamedNativeQuery(name = "UserDetails.byName",query = "select * from USER_DETAILS where USER_NAME = ?0",resultClass = UserDetails.class) 
@Table(name= "USER_DETAILS")
@SelectBeforeUpdate
public class UserDetails {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userID;
	
	@Column(name="USER_NAME")
	private String userName;
	
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
	
	public String toString(){
		return "{"+userID+ " | " +userName+ " }";
		
	}
}

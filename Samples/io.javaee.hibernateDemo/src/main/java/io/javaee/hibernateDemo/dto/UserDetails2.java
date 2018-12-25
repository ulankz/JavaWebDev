package io.javaee.hibernateDemo.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "USER_DETAILS")
public class UserDetails2 {
	
	/*
	@EmbeddedId
	private LoginName userID;
	*/
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private int userID;
	
	@Column(name="USER_NAME")
	private String userName;
	
	
	
////	@OneToMany(mappedBy = "user")
//	@JoinTable(
//			name = "USER_VEHICLE",
//			joinColumns = @JoinColumn(name = "USER_ID"),
//			inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID")
//			)
	//@ManyToMany
	@OneToMany(cascade = CascadeType.ALL)
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
	
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
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
}

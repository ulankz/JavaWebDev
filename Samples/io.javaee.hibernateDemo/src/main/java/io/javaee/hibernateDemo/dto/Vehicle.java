package io.javaee.hibernateDemo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {
	@Id @GeneratedValue
	@Column(name = "VEHICLE_ID")
	private int vehicleID;
	@Column(name = "VEHICLE_NAME")
	private String vehicleName;
	
//	@ManyToOne
//	@NotFound(action = NotFoundAction.IGNORE)
//	@JoinColumn(name = "USER_ID")
//	private UserDetails2 user;
	
//	@ManyToMany(mappedBy = "vehicles")
//	private Collection<UserDetails2> users = new ArrayList<UserDetails2>();
	public int getVehicleID() {
		return vehicleID;
	}
	public void setVehicleID(int vehicleID) {
		this.vehicleID = vehicleID;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
//	public UserDetails2 getUser() {
//		return user;
//	}
//	public void setUser(UserDetails2 user) {
//		this.user = user;
//	}
//	public Collection<UserDetails2> getUsers() {
//		return users;
//	}
//	public void setUsers(Collection<UserDetails2> users) {
//		this.users = users;
//	}
}

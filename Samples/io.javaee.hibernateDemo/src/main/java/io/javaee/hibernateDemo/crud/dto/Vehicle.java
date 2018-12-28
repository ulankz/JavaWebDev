package io.javaee.hibernateDemo.crud.dto;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE")
// SINGLE TABLE STRATEGY
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "VEHICLE_TYPE",
//					discriminatorType = DiscriminatorType.STRING
//					 
//		)

// PER CLASS STRATEGY
//@Inheritance(
//		strategy = InheritanceType.TABLE_PER_CLASS)

// JOINED STRATEGY
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {
	@Id @GeneratedValue
	@Column(name = "VEHICLE_ID")
	private int vehicleID;
	@Column(name = "VEHICLE_NAME")
	private String vehicleName;
	
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
}

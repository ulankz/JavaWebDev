package io.javaee.hibernateDemo.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name= "USER_DETAILS")
public class UserDetails {
	
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
	
	@Column(name="JOIN_DATE")
	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	
	@Column(name="WORK_ADDRESS")
	//@Transient
	private String workAddress;
	
	@Transient
	private int age;
	
	@Column(name = "DESCRIPTION")
	@Lob 
	private String description;
	
//	@Embedded
//	@AttributeOverrides({ 
//	@AttributeOverride(name = "street",column = @Column(name = "HOME_STREET_NAME")),
//	@AttributeOverride(name = "city",column = @Column(name = "HOME_CITY_NAME")),
//	@AttributeOverride(name = "state",column = @Column(name = "HOME_STATE_NAME")),
//	@AttributeOverride(name = "zipcode",column = @Column(name = "HOME_ZIPCODE"))
//	})
//	private Address homeAddress;
	
//	@Embedded
//	@AttributeOverrides({
//	@AttributeOverride(name = "street",column = @Column(name = "OFFICE_STREET_NAME")),
//	@AttributeOverride(name = "city",column = @Column(name = "OFFICE_CITY_NAME")),
//	@AttributeOverride(name = "state",column = @Column(name = "OFFICE_STATE_NAME")),
//	@AttributeOverride(name = "zipcode",column = @Column(name = "OFFICE_ZIPCODE"))
//	})
//	private Address officeAddress;
	
	@ElementCollection
	@JoinTable(name = "USER_ADDRESS",
	joinColumns =@JoinColumn(name = "USER_ID") 
	)
	@GenericGenerator(name = "hilo-gen", strategy = "increment")
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type = "long"))
	private List<Address> listOfAddresses = new ArrayList<Address>();
	
	
	
//	public Address getHomeAddress() {
//		return homeAddress;
//	}
//	public void setHomeAddress(Address address) {
//		this.homeAddress = address;
//	}
//	public Address getOfficeAddress() {
//		return officeAddress;
//	}
//	public void setOfficeAddress(Address address) {
//		this.officeAddress = address;
//	}
	
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
	public String getWorkAddress() {
		return workAddress;
	}
	public void setWorkAddress(String address) {
		this.workAddress = address;
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
	
	public String toString(){
		return "{"+userID+ " | " +userName+ " | "+ description +" | "+workAddress+" | "
	+joinedDate+ " | " + listOfAddresses.size()+ " }";
		
	}
	public List<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(List<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	
}

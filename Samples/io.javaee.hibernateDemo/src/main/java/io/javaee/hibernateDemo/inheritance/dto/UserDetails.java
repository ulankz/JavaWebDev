package io.javaee.hibernateDemo.inheritance.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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

import io.javaee.hibernateDemo.dto.Address;

@Entity
@Table(name= "USER_DETAILS")
public class UserDetails {
	
	
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
	
	@ElementCollection(fetch = FetchType.LAZY)
	@JoinTable(name = "USER_ADDRESS", 
	joinColumns =@JoinColumn(name = "USER_ID") 
	)
	@GenericGenerator(name = "hilo-gen", strategy = "increment")
	@CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type = "long"))
	private List<Address> listOfAddresses = new ArrayList<Address>();
	
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
	+joinedDate+ " | " + (listOfAddresses.size() > 0 ? listOfAddresses.get(0).getCity():" addresses are empty ")+ " }";
		
	}
	public List<Address> getListOfAddresses() {
		return listOfAddresses;
	}
	public void setListOfAddresses(List<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	
}

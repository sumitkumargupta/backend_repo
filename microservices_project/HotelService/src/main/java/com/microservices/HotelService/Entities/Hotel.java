package com.microservices.HotelService.Entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Hotel implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	private Integer noOfRooms;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name ="address_id", referencedColumnName = "id")
	private Address address;

	public Hotel() {
		
	}
	
	public Hotel(Integer id, String name, Integer noOfRooms, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.noOfRooms = noOfRooms;
		this.address = address;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNoOfRooms() {
		return noOfRooms;
	}
	public void setNoOfRooms(Integer noOfRooms) {
		this.noOfRooms = noOfRooms;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	

}

package com.microservices.UsersService.Entities;

public class Hotel {

	private Integer id;
	private String name;
	private Integer noOfRooms;
	private HotelAddress address;
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
	public HotelAddress getAddress() {
		return address;
	}
	public void setAddress(HotelAddress address) {
		this.address = address;
	}
	
	

}

package com.microservices.HotelService.DTO;

import com.microservices.HotelService.Entities.Address;


public class HotelDto {

	private Integer id;
	private String name;
	private Integer noOfRooms;
	private AddressDto address;

	public HotelDto() {
		
	}
	
	public HotelDto(Integer id, String name, Integer noOfRooms, AddressDto address) {
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
	public AddressDto getAddress() {
		return address;
	}
	public void setAddress(AddressDto address) {
		this.address = address;
	}

}

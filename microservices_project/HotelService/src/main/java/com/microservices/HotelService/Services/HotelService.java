package com.microservices.HotelService.Services;

import java.util.List;

import com.microservices.HotelService.DTO.HotelDto;

public interface HotelService {
	
	public List<HotelDto> getAllHotels();
	
	public HotelDto getHotelById(Integer id);
	
	public HotelDto addhotel(HotelDto hotel);
	
	public HotelDto updateHotel(Integer hotelId, HotelDto hotel);
	
	public void deleteHotel(Integer hotelId);
}

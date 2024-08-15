package com.microservices.HotelService.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.microservices.HotelService.DTO.HotelDto;
import com.microservices.HotelService.Entities.Address;
import com.microservices.HotelService.Entities.Hotel;
import com.microservices.HotelService.Exception.HotelNotFoundException;
import com.microservices.HotelService.Repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public List<HotelDto> getAllHotels() {
		// TODO Auto-generated method stub
		List<Hotel> hotels = hotelRepo.findAll();
		List<HotelDto> dtos =  hotels.stream().map((m)-> mapHotelToDto(m)).collect(Collectors.toList());
		return dtos;
	}
	
	@Override
	public HotelDto getHotelById(Integer id) {
		// TODO Auto-generated method stub
		Hotel hotel = hotelRepo.findById(id).orElseThrow(()-> new HotelNotFoundException("Hotel Not found with this id : " +  id, id, HttpStatus.NOT_FOUND));
		return mapHotelToDto(hotel);
	}


	@Override
	public HotelDto addhotel(HotelDto hotelDto) {
		// TODO Auto-generated method stub
		Hotel hotel = mapDtoToHotel(hotelDto);
		hotel = hotelRepo.save(hotel);
		return mapHotelToDto(hotel);
	}

	@Override
	public HotelDto updateHotel(Integer hotelId, HotelDto hotelDto) {
		// TODO Auto-generated method stub
		Hotel hotel = hotelRepo.findById(hotelId).orElseThrow(()-> new HotelNotFoundException("No hotel found with this Id.", hotelId, HttpStatus.NOT_FOUND));
		hotel.setName(hotelDto.getName());
		hotel.setNoOfRooms(hotelDto.getNoOfRooms());
		if(hotelDto.getAddress() != null) {
			Address addr = new Address();
			addr.setId(hotelDto.getAddress().getId());
			addr.setArea(hotelDto.getAddress().getArea()); 
			addr.setLandmark(hotelDto.getAddress().getLandmark()); 
			addr.setCity(hotelDto.getAddress().getCity());
			addr.setState(hotelDto.getAddress().getState()); 
			addr.setZipcode(hotelDto.getAddress().getZipcode());
			hotel.setAddress(addr);
		} else {
			hotel.setAddress(new Address());
		}
		hotel = hotelRepo.save(hotel);
		return mapHotelToDto(hotel);
	}

	@Override
	public void deleteHotel(Integer hotelId) {
		// TODO Auto-generated method stub
		Hotel hotel = hotelRepo.findById(hotelId).orElseThrow(()-> new HotelNotFoundException("No hotel Found ith this id to delte.", hotelId, HttpStatus.NOT_FOUND));
		hotelRepo.delete(hotel);
	}
	
	private HotelDto mapHotelToDto(Hotel hotel) {
		HotelDto dto  = modelMapper.map(hotel, HotelDto.class);
		return dto;
	}
	
	private Hotel mapDtoToHotel(HotelDto dto) {
		Hotel hotel = modelMapper.map(dto, Hotel.class);
		return hotel;
	}

}

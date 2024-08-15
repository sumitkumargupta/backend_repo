package com.microservices.HotelService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.HotelService.DTO.HotelDto;
import com.microservices.HotelService.PayloadAndResponse.ApiResponse;
import com.microservices.HotelService.Services.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	@RequestMapping(value = "/gethotels", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<HotelDto>> getHotels(){
		List<HotelDto> dtos = hotelService.getAllHotels();
		return new ResponseEntity<List<HotelDto>>(dtos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/gethotel/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<HotelDto> getHotelById(@PathVariable("id") Integer hotelId){
		HotelDto dto = hotelService.getHotelById(hotelId);
		return new ResponseEntity<HotelDto>(dto, HttpStatus.OK);
	}
	
	@RequestMapping(value="/addhotel", method= RequestMethod.POST, 
			consumes = "application/json", produces="application/json")
	public ResponseEntity<HotelDto> addNewHotel(@RequestBody HotelDto hotelDto){
		HotelDto dto = hotelService.addhotel(hotelDto);
		return new ResponseEntity<HotelDto>(dto, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/updatehotel/{id}", method= RequestMethod.PUT, 
			consumes="application/json", produces="application/json")
	public ResponseEntity<HotelDto> updateHotelDetails(@PathVariable("id") Integer hotelId, @RequestBody HotelDto hotelDto){
		HotelDto dto = hotelService.updateHotel(hotelId, hotelDto);
		return new ResponseEntity<HotelDto>(dto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<ApiResponse> deleteHotel(@PathVariable("id") Integer hotelId){
		hotelService.deleteHotel(hotelId);
		ApiResponse apiResponse = new ApiResponse("Deleted Successfully", true, HttpStatus.OK, HttpStatus.OK.value());
		return new ResponseEntity<ApiResponse>(apiResponse, apiResponse.getHttpStatus());
	}

}

package com.microservices.HotelService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.HotelService.Entities.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>{

}

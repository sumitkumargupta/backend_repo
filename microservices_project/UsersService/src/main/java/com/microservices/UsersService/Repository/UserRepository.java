package com.microservices.UsersService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.UsersService.Entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}

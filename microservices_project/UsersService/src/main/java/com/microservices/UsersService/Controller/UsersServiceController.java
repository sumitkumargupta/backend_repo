package com.microservices.UsersService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.UsersService.Entities.User;
import com.microservices.UsersService.PayloadAndResponse.ApiResponse;
import com.microservices.UsersService.Services.UserService;

@RestController
@RequestMapping("/usersservice")
public class UsersServiceController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/users", method= RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userService.getUsers();
		return ResponseEntity.ok().body(users);
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.GET)
	public ResponseEntity<User> getUserByTheirId(@PathVariable("id") Integer userId){
		User user = userService.getUserById(userId);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@RequestMapping(value="/user", method= RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User user){
		User newUser = userService.addUser(user);
		return ResponseEntity.ok().body(newUser);
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.PUT)
	public ResponseEntity<User> updateUserDetail(@PathVariable("id") Integer userId, @RequestBody User user) {
		User updatedUser = userService.updateUser(userId, user);
		return ResponseEntity.ok().body(updatedUser);
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("id") Integer userId){
		userService.deleteUser(userId);
		ApiResponse apiResponse = new ApiResponse(true, "Deleted Successfully. User Id: " +userId, HttpStatus.OK);
		return ResponseEntity.ok().body(apiResponse);
	}
}

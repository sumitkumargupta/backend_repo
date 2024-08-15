package com.microservices.UsersService.Services;

import java.util.List;

import com.microservices.UsersService.Entities.User;


public interface UserService {
	
	public List<User> getUsers();
	
	public User getUserById(Integer id);
	
	public User addUser(User user);
	
	public User updateUser(Integer userId, User user);
	
	public void deleteUser(Integer userId);

}

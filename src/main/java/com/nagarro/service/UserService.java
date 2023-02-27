package com.nagarro.service;

import java.util.List;

import com.nagarro.entity.User;

public interface UserService {
	User addUser(User user);
	Object isAuthenticatedUser(User user);
	int deleteUser(String email);
	int updateUser(String email,User user);
	List<User> getUsersList();
	long getUsers();
}
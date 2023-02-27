package com.nagarro.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.entity.User;
import com.nagarro.exception.UserAlreadyExistException;
import com.nagarro.exception.UserNotFoundException;
import com.nagarro.exception.UserUnauthorizedException;
import com.nagarro.service.UserService;
import com.nagarro.utils.ResponseHandler;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	public UserService userService;

	@GetMapping
	public ResponseEntity<Object> getUser() {
		List<User> usersList = userService.getUsersList();
		return ResponseHandler.generateResponse("User Fetched Successfully!", HttpStatus.OK, usersList);
	}

	@PostMapping
	public ResponseEntity<Object> saveUser(@RequestBody User user) {
		try {
			userService.addUser(user);
			return ResponseHandler.generateResponse("User added Successfully!", HttpStatus.CREATED);
		} catch (ConstraintViolationException e) {
			throw e;
		} catch (Exception e) {
			throw new UserAlreadyExistException(e.getMessage());
		}
	}

	@PostMapping("/login")
	public ResponseEntity<Object> isAuthenticatedUser(@RequestBody User user) {
		try {
			Object isAuthUser = userService.isAuthenticatedUser(user);
			if (isAuthUser != null) {
				return ResponseHandler.generateResponse("User LoggedIn Successfully", HttpStatus.OK, isAuthUser);
			} else {
				throw new UserUnauthorizedException("User Unauthorized");
			}
		} catch (Exception e) {
			throw new UserUnauthorizedException("User Unauthorized");
		}
	}

	@DeleteMapping("/{email}")
	public ResponseEntity<Object> deleteUser(@PathVariable String email) {
		int status = userService.deleteUser(email);
		if (status == 1)
			return ResponseHandler.generateResponse("User Deleted Successfully", HttpStatus.OK);
		throw new UserNotFoundException("User Not Found");
	}

	@PutMapping("/{email}")
	public ResponseEntity<Object> updateUser(@PathVariable String email, @RequestBody User user) {
		int status = userService.updateUser(email, user);
		if (status == 1)
			return ResponseHandler.generateResponse("User Updated Successfully", HttpStatus.ACCEPTED);
		throw new UserNotFoundException("User Not Found");
	}

	@GetMapping("/getusers")
	public ResponseEntity<Object> getUsers() {
		long data = userService.getUsers();
		return ResponseHandler.generateResponse("User Fetched Successfully", HttpStatus.OK, data);
	}
}
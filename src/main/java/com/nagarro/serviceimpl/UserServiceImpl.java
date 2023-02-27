package com.nagarro.serviceimpl;

import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nagarro.dao.UserDao;
import com.nagarro.entity.User;
import com.nagarro.exception.UserNotFoundException;
import com.nagarro.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	public static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());

	@Autowired
	public UserDao userRepo;

	@Override
	public User addUser(User user) {
		user.setPassword(new String(Base64.getEncoder().encode(user.getPassword().getBytes())));
		return userRepo.save(user);
	}

	@Override
	public Object isAuthenticatedUser(User user) {
		user.setPassword(new String(Base64.getEncoder().encode(user.getPassword().getBytes())));
		User isFound = userRepo.findByEmailAndPassword(user.getEmail(), user.getPassword());
		if(isFound!=null) {		
			Map <String,Object> data=new HashMap<>();
			data.put("userId",isFound.getId());
			data.put("name",isFound.getFirstname()+" "+isFound.getLastname());
			data.put("token",new String(Base64.getEncoder().encode("user:Passw0rd".getBytes())));
			
		return data;
		}
		throw new UserNotFoundException("Invalid User");
	}

	@Override
	public int deleteUser(String email) {
		User user = userRepo.findByEmail(email);
		try {
			userRepo.delete(user);
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int updateUser(String email, User user) {
		User dbUser = userRepo.findByEmail(email);
		try {
			if (dbUser != null && user != null) {
				updateFields(user, dbUser);
				userRepo.save(dbUser);
				return 1;
			}
				return 0;
		} catch (Exception e) {
			return 0;
		}
	}

	private void updateFields(User user, User dbUser) {
		if (user.getEmail() != null)
			dbUser.setEmail(user.getEmail());

		if (user.getPassword() != null)
			dbUser.setPassword(user.getPassword());

		if (user.getFirstname() != null)
			dbUser.setFirstname(user.getFirstname());

		if (user.getLastname() != null) {
			dbUser.setLastname(user.getLastname());
		}
	}

	@Override
	public long getUsers() {
		return userRepo.findAll().size();
	}

	@JsonIgnoreProperties({"password"})
	@Override
	public List<User> getUsersList() {
		return userRepo.findAll();
	}

}

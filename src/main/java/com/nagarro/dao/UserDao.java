package com.nagarro.dao;

import com.nagarro.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	
	User findByEmailAndPassword(String email,String password);
	User findByEmail(String email);
	
}

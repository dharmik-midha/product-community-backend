package com.nagarro.controller;

import com.nagarro.entity.Likes;
import com.nagarro.service.LikesService;
import com.nagarro.utils.ResponseHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/likes")
public class LikesController {

	@Autowired
	public LikesService likesService;

	@PostMapping
	public ResponseEntity<Object> likeDislike(@RequestBody Likes like) {
		likesService.likeDislike(like);
		return ResponseHandler.generateResponse("Response updated", HttpStatus.ACCEPTED);
	}

}

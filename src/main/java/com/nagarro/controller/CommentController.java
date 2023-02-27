package com.nagarro.controller;

import com.nagarro.entity.Comment;
import com.nagarro.exception.CommentNotFoundException;
import com.nagarro.service.CommentService;
import com.nagarro.utils.ResponseHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/comments")
public class CommentController {

	@Autowired
	public CommentService commentService;

	@PostMapping
	public ResponseEntity<Object> saveComment(@RequestBody Comment comment) {
		commentService.saveComment(comment);
		return ResponseHandler.generateResponse("Comment Saved Successfully", HttpStatus.CREATED);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteComment(@PathVariable long id){
			
		int status = commentService.deleteComment(id);
		if (status == 1)
			return ResponseHandler.generateResponse("Comment Deleted Successfully", HttpStatus.OK);
		else
		    throw new CommentNotFoundException("Invalid Comment Id");

	}

}

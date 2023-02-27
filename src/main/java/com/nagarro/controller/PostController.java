package com.nagarro.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.nagarro.entity.Comment;
import com.nagarro.entity.Post;
import com.nagarro.entity.SearchFilter;
import com.nagarro.exception.PostNotFoundException;
import com.nagarro.service.PostService;
import com.nagarro.utils.ResponseHandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/posts")
public class PostController {
	@Autowired
	public PostService postService;

	@PostMapping
	public ResponseEntity<Object> savePost(@RequestBody Post post) {
		postService.createPost(post);
		return ResponseHandler.generateResponse("Post Created Successfully", HttpStatus.OK);
	}

	@GetMapping()
	public ResponseEntity<Object> getPosts(@RequestParam(name = "search", required = false) String search,
			@RequestParam(name = "date", required = false) Date date,
			@RequestParam(name = "productId", required = false) String productId,
			@RequestParam(name = "email", required = false) String email) {

		SearchFilter searchFilter = new SearchFilter();
		if (search != null)
			searchFilter.setSearch(search);
		
		if (date != null)
			searchFilter.setDate(new Timestamp(date.getTime()));

		if (email != null)
			searchFilter.setEmail(email);

		if (productId != null)
			searchFilter.setProductId(productId);

		List<Post> posts = postService.getPosts(searchFilter);
		return ResponseHandler.generateResponse("Posts Fetched Successfully", HttpStatus.OK, posts);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getPost(@PathVariable long id) {
		try {
			Post post = postService.getPost(id);
			return ResponseHandler.generateResponse("Post Found", HttpStatus.OK, post);
		} catch (Exception e) {
			throw new PostNotFoundException("Post Not Found");
		}
	}

	@GetMapping("/getposts")
	public ResponseEntity<Object> getUsers() {
		long data = postService.getNoOfPosts();
		return ResponseHandler.generateResponse("No. of Posts Fetched Successfully", HttpStatus.OK, data);
	}

	@PostMapping("/{id}/answer")
	public ResponseEntity<Object> postAnswer(@PathVariable long id, @RequestBody Comment comment) {
		int status = postService.updateAnswer(id, comment);
		if (status == 1) {
			return ResponseHandler.generateResponse("Request Done Successfully", HttpStatus.ACCEPTED);
		}
		return ResponseHandler.generateResponse("Request Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping("/solved")
	public ResponseEntity<Object> getNoOfSolvedPosts() {
		int posts = postService.getNoOfSolvedPosts();
		return ResponseHandler.generateResponse("Solved Posts Fetched Successfully", HttpStatus.OK, posts);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePost(@PathVariable long id) {
		int status = postService.deletePost(id);
		if (status == 1) {
			return ResponseHandler.generateResponse("Post Deleted Successfully", HttpStatus.OK);
		}
		throw new PostNotFoundException("Product Not Found");
	}
}

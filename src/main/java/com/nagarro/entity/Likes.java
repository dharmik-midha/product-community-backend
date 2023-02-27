package com.nagarro.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Likes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long likeId;
	
	@OneToOne
	@Autowired
	@JsonIgnoreProperties({"password","email"})
	private User likedBy;

	@ManyToOne
	@Autowired
	@JsonIgnoreProperties({"subject","product","addedBy","body","comments","time","likes","answer"})
	private Post posts;

	public Likes() {
	}

	public long getLikeId() {
		return likeId;
	}

	public void setLikeId(long likeId) {
		this.likeId = likeId;
	}

	public User getLikedBy() {
		return likedBy;
	}

	public void setLikedBy(User likedBy) {
		this.likedBy = likedBy;
	}

	public Post getPosts() {
		return posts;
	}

	public void setWhichPost(Post posts) {
		this.posts = posts;
	}

	public Likes(long likeId, User likedBy, Post posts) { 
		super();
		this.likeId = likeId;
		this.likedBy = likedBy;
		this.posts = posts;
	}


}

package com.nagarro.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long commentId;
	
	@ManyToOne
	@Autowired
	@JsonIgnoreProperties({"password"})
	private User createdBy;
	private String commentMsg;

	
	@ManyToOne
	@Autowired
	@JsonIgnoreProperties({"subject","product","addedBy","body","comments","time","likes","answer"})
	private Post post;

	private Timestamp time=new Timestamp(new Date().getTime());
	
	
	public Comment() {
		super();
	}

	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public String getCommentMsg() {
		return commentMsg;
	}

	public void setCommentMsg(String comment) {
		this.commentMsg = comment;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}


	public Comment(long commentId, User createdBy, String commentMsg, Post post,
			Timestamp time) {
		super();
		this.commentId = commentId;
		this.createdBy = createdBy;
		this.commentMsg = commentMsg;
		this.post = post;
		this.time = time;
	}



}

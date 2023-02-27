package com.nagarro.entity;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long postId;

	@NotBlank(message = "Subject is required")
	private String subject;

	@ManyToOne
	@Autowired
	private Product product;

	@NotBlank(message = "Body is required")
	private String body;

	@ManyToOne
	@Autowired
	@JsonIgnoreProperties({ "password" })
	private User addedBy;

	@OneToOne
	@Autowired
	@JsonIgnoreProperties({"post"})
	private Comment answer;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	@Autowired
	private List<Comment> comments;

	@OneToMany(mappedBy = "posts", cascade = CascadeType.ALL)
	@Autowired
	private List<Likes> likes;

	private Timestamp time = new Timestamp(new Date().getTime());

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public User getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(User addedBy) {
		this.addedBy = addedBy;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public Comment getAnswer() {
		return answer;
	}

	public void setAnswer(Comment answer) {
		this.answer = answer;
	}

	public List<Likes> getLikes() {
		return likes;
	}

	public void setLikes(List<Likes> likes) {
		this.likes = likes;
	}

	public Post() {
		super();
	}

	public Post(long postId, String subject, Product product, String body, User addedBy, Comment answer,
			List<Comment> comments, List<Likes> likes, Timestamp time) {
		super();
		this.postId = postId;
		this.subject = subject;
		this.product = product;
		this.body = body;
		this.addedBy = addedBy;
		this.answer = answer;
		this.comments = comments;
		this.likes = likes;
		this.time = time;
	}

	public Timestamp getTime() {
		return time; 
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}

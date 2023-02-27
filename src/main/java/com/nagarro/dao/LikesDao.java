package com.nagarro.dao;

import com.nagarro.entity.Likes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LikesDao extends JpaRepository<Likes, Long>{
	String FINDBYLIKEDBYANDPOSTSQUERY="select l from Likes l where l.likedBy.id=:likedBy and l.posts.postId=:posts";
	
	@Query(FINDBYLIKEDBYANDPOSTSQUERY)
	Likes findByLikedByAndPosts(long likedBy, long posts);
}

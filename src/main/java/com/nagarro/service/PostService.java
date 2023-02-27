package com.nagarro.service;

import java.util.List;

import com.nagarro.entity.Comment;
import com.nagarro.entity.Post;
import com.nagarro.entity.SearchFilter;

public interface PostService {

	Post createPost(Post post);
	List<Post> getPosts(SearchFilter filter);
	int deletePost(long postId);
	Post getPost(long id);
	long getNoOfPosts();
	int updateAnswer(long postId,Comment comment);
	int getNoOfSolvedPosts();
}
 
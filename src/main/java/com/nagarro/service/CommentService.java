package com.nagarro.service;

import com.nagarro.entity.Comment;

public interface CommentService {
	Comment saveComment(Comment comment);
	int deleteComment(long commentId);
}

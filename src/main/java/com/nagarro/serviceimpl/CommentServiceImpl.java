package com.nagarro.serviceimpl;

import com.nagarro.dao.CommentDao;
import com.nagarro.entity.Comment;
import com.nagarro.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentDao commentRepo;
	
	@Override
	public Comment saveComment(Comment comment) {
		return commentRepo.save(comment);
	}

	@Override
	public int deleteComment(long commentId) {
		try {			
			commentRepo.deleteById(commentId);
			return 1;
			}
			catch(Exception e){
				return 0;
			}
	}


}

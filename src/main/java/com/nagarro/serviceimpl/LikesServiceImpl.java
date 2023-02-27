package com.nagarro.serviceimpl;

import java.util.Objects;

import com.nagarro.dao.LikesDao;
import com.nagarro.entity.Likes;
import com.nagarro.service.LikesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikesServiceImpl implements LikesService{

	@Autowired
	public LikesDao likesRepo;

	@Override
	public Likes likeDislike(Likes like) {
		Likes likes=likesRepo.findByLikedByAndPosts(like.getLikedBy().getId(),like.getPosts().getPostId());
		if(Objects.isNull(likes)) {
			likesRepo.save(like);
		}
		else {
			likesRepo.delete(likes);
		}
		return likes;
	}
	

}

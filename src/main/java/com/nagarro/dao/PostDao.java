package com.nagarro.dao;

import java.sql.Timestamp;
import java.util.List;

import com.nagarro.entity.Post;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDao extends JpaRepository<Post, Long> {
	String FINDBYANSWERQUERY="select p from Post p where p.answer!=null";
	String FINDBYSUBJECTANDBODYQUERY="select p from Post p where p.subject LIKE %:search% or p.body LIKE %:search%";
	
	String FINDBYFILTERQUERY="select p from Post p where (p.subject LIKE %:search% or p.body LIKE %:search%) and (Date(p.time) LIKE COALESCE(Date(:date),'%%')) and (p.addedBy.email LIKE %:email%) and (p.product.productId LIKE COALESCE(:productId,'%%'))";
	
	@Query(FINDBYANSWERQUERY)
	List<Post> findByAnswer();

	@Query(FINDBYSUBJECTANDBODYQUERY)
	List<Post> findBySubjectAndBody(String search);

	@Query(FINDBYFILTERQUERY)
	List<Post> findByFilter(String search, Timestamp date, String email,String productId);


}

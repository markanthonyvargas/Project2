package com.servicepack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.models.Posts;
import com.models.Users;
import com.repo.PostsRepo;

/**
 * This is the implementation of the methods found in PostsService. This is responsible for acting as the service layer
 *  of our database involving the Posts table
 * @author Nicholas Deters, Andrew Kellar, William Stone, Mark Anthony Vargas, Justin Wen
 *
 */
@Service
public class PostsServiceImpl implements PostsService {
	//public static ApplicationContext appContext= new ClassPathXmlApplicationContext("applicationContext.xml");
	//PostsRepo postsDao =  appContext.getBean("postsRepo", PostsRepoImpl.class);
	PostsRepo postsDao;
	
	public PostsServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	public PostsServiceImpl(PostsRepo postsDao) {
		this.postsDao = postsDao;
	}
	
	
	@Override
	public void addPost(Posts post) {
		postsDao.insert(post);
	}

	@Override
	public List<Posts> getAllPosts() {
		return postsDao.selectAll();
	}

	@Override
	public Posts getPostById(int id) {
		return postsDao.selectById(id);
	}

	@Override
	public List<Posts> getPostsByAuthor(Users u) {
		return postsDao.selectByAuthor(u);
	}
	@Override
	public void updatePost(Posts post) {
		postsDao.update(post);
	}
	@Override
	public void delete(Posts postObj) {
		postsDao.delete(postObj);
		
	}
}


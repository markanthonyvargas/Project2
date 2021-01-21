package com.repo;


	
	import java.util.List;

import com.models.Posts;
import com.models.Users;

	public interface PostsRepo {
		
		/**
		 * This method takes in a Post object meant to represent a newly created 
		 * post and insert it into the Posts table
		 * 
		 * @param postObj is a Posts object representing the post to be inserted into the database
		 */
		public void insert(Posts postObj);
		
		/**
		 * This method takes in a Posts object and will update a record with matching information in the posts table
		 * @param postObj is a Posts object representing the post to be updated in the database
		 */
		public void update(Posts postObj);
		
		/**
		 * This method takes in a Posts object and deletes a record in the table with matching information
		 * @param postObj is a Posts object representing the post to be deleted from the database
		 */
		public void delete(Posts postObj);
		
		/**
		 * This method takes in an integer representing a post id and will return a record with the matching primary key
		 * @param id is an integer representing the id of the post to be selected
		 * @return the post whose postId matches the id passed into the function
		 */
		public Posts selectById(int id);
		
		/**
		 * This method takes in a User object and returns Posts records with matching authors
		 * @param u is the Users object representing the User whose posts will be returned
		 * @return a List of Posts created by the specified user
		 */
		public List<Posts> selectByAuthor(Users u);
		
		/**
		 * This method returns all posts in the database
		 * @return a List of all posts in the database
		 */
		public List<Posts> selectAll();
	


}

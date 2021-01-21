package com.servicepack;

import java.util.List;

import com.models.Posts;
import com.models.Users;

public interface PostsService {
	
	
	
	/**
	 * This method is responsible for adding posts to the database
	 * @param post represents the post to be inserted into the database
	 */
	public void addPost(Posts post);
	
	/**
	 * This method is responsible for returning all posts in the database
	 * @return a List of all posts in the database
	 */
	public List<Posts> getAllPosts();
	
	/**
	 * This method is responsible for selecting a post by it's postId
	 * @param id represent the id to select the post by
	 * @return a Post object representing the Post selected
	 */
	public Posts getPostById(int id);
	
	/**
	 * This method is responsible for selecting all posts created by the specified user
	 * @param u represents the User whose posts will be returned
	 * @return a List of posts by the specified user
	 */
	public List<Posts> getPostsByAuthor(Users u);
	
	/**
	 * This method is responsible for updating a post in the database
	 * @param post represents the post to be updated
	 */
	public void updatePost(Posts post);
	
	/**
	 * This method is responsible for deleting a post in the database
	 * @param postObj represents the post to be deleted
	 */
	public void delete(Posts postObj);
	
	
}

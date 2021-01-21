package com.controllerpack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.models.Like;
import com.models.Posts;
import com.models.Users;
import com.servicepack.PostsService;
import com.servicepack.UserService;

/**
 * This class serves as the controller for Posts related endpoints
 * 
 * @author Nicholas Deters, Andrew Kellar, William Stone, Mark Anthony Vargas,
 *         Justin Wen
 *
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PostController {
	private PostsService postsService;
	private UserService userService;

	public PostController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public PostController(PostsService postsService, UserService userService) {
		super();
		this.postsService = postsService;
		this.userService = userService;
	}
	
	@PostMapping(value= "/createPost")
	public void createPost(@RequestBody Posts newPost) {
		Users u = userService.getUserById(newPost.getAuthor().getUserId());
		newPost.setAuthor(u);
		newPost.setLikes(new ArrayList<Users>());
		postsService.addPost(newPost);
	}

	/**
	 * This endpoint is responsible for returning all posts in the database
	 * 
	 * @return List object containing all posts in the database
	 */
	@GetMapping(value = "/getPosts")
	public List<Posts> getAllPosts() {
		System.out.println(postsService.getAllPosts());
		List<Posts> listPosts = postsService.getAllPosts();
		return listPosts;
	}

	/**
	 * This endpoint is responsible for returning all posts from a specified
	 * username from the database
	 * 
	 * @param user is a Users object
	 * @return a list of posts from the specified user
	 */
	@PostMapping(value = "/getPostByUsername")
	public List<Posts> getPostByUsername(@RequestBody Users user) {
		System.out.println(userService.getUserByUsername(user.getUserName()));
		List<Posts> listPosts = postsService.getPostsByAuthor(userService.getUserByUsername(user.getUserName()));
		return listPosts;
	}

	/**
	 * This endpoint is responsible for returning all posts from a specified user's
	 * first and last name from the database
	 * 
	 * @param user is a Users object
	 * @return a list of posts from the specified user
	 */
	@PostMapping(value = "/getPostByName")
	public Map<String, List<Posts>> getPostByName(@RequestBody Users user) {
		System.out.println(userService.getUserByName(user.getFirstname(), user.getLastname()));
		Map<String, List<Posts>> userPostsMap = new HashMap<>();

		List<Users> users = userService.getUserByName(user.getFirstname(), user.getLastname());

		for (Users u : users) {
			userPostsMap.put(u.getUserName(), postsService.getPostsByAuthor(u));
		}
//		List<Posts> listPosts = postsService
//				.getPostsByAuthor(userService.getUserByName(user.getFirstname(), user.getLastname()));

		return userPostsMap;
	}

	/**
	 * This endpoint is responsible for adding a like to a post
	 * 
	 * @param session is the current session
	 * @param post    is the post to be liked
	 */
	@PostMapping(value = "/insertLike")
	public /* @ResponseBody */ void insertLike(@RequestBody Like like, HttpSession session) {
		System.out.println("in the insert like method");
		Users user = userService.getUserByUsername(like.getUserName());
		Posts newPost = postsService.getPostById(like.getPostId());
		if(!newPost.getLikes().contains(user)) {
			newPost.getLikes().add(user);
			postsService.updatePost(newPost);
		}
	}

	/**
	 * This endpoint is responsible for toggling likes on a post
	 * @param session is the current session
	 * @param post    is the post to be updated
	 */
	@PostMapping(value = "/updateLike")
	public /* @ResponseBody */ void updateLike(@RequestBody Like like, HttpSession session) {
		System.out.println("in the delete like method");
		Users user = userService.getUserByUsername(like.getUserName());
		Posts newPost = postsService.getPostById(like.getPostId());
		if (!newPost.getLikes().contains(user)) {
			newPost.getLikes().add(user);
			postsService.updatePost(newPost);
		} else {
			newPost.getLikes().remove(user);
			postsService.updatePost(newPost);
		}
	}
	
	@PostMapping(value = "/insertPostImage")
	public void attachImageToPost(@RequestBody Posts post) {
		int id = post.getPostId();
		String postImg = post.getPostImg();
		
		Posts updatePost = postsService.getPostById(id);
		updatePost.setPostImg(postImg);
		postsService.updatePost(updatePost);
		
	}
}

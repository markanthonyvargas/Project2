package com.controllerpack;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.models.Users;
import com.servicepack.UserService;

/**
 * This class serves as the controller for User related endpoints
 * @author Nicholas Deters, Andrew Kellar, William Stone, Mark Anthony Vargas, Justin Wen
 *
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UserController {
	private UserService userService;

	public UserController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	/**
	 * This endpoint is responsible for inserting a new user into the database
	 * @param currentUser is the information of the new user to be created
	 * @return a boolean that verifies if the created user was successfully entered into the database
	 */
	@PostMapping(value = "/insertNewUser")
	public /* @ResponseBody */ Users insertNewUser(@RequestBody Users currentUser) {
		Users newUser = new Users(currentUser.getFirstname(), currentUser.getLastname(), currentUser.getUserName(),
				Integer.toString(currentUser.getPassWord().hashCode()), currentUser.getEmail());
		newUser.setProfileImg("https://www.freeiconspng.com/uploads/turtle-icon-31.png");
		userService.addUser(newUser);
		 newUser.setPassWord("");
		return newUser;
	}

	/**
	 * This endpoint is responsible for retrieving a user from the database by a specified username
	 * @param username is a String object representing the username used to retrieve a user 
	 * @return a Users object representing the user retrieved from the database
	 */
	@GetMapping(value = "/getUserByUsername")
	public /* @ResponseBody */ Users getUserByUsername(@RequestParam("userName") String username) {
		return userService.getUserByUsername(username);
	}

	/**
	 * This endpoint is responsible for updating a user's information
	 * @param session is the current session
	 * @param currentUser is the user object with updated information
	 * @return the Users object with updated information 
	 */
	@PostMapping(value = "/updateUserInfo")
	public /* @ResponseBody */ Users updateUserInfo(HttpSession session, @RequestBody Users currentUser) {
		System.out.println("in the update method");
		System.out.println(currentUser);
		//System.out.println(session.getAttribute("loggedInUser"));
		//Users user = (Users) session.getAttribute("loggedInUser");
		Users user = userService.getUserById(currentUser.getUserId());
		user.setFirstname(currentUser.getFirstname() != null ? currentUser.getFirstname() : user.getFirstname());
		user.setLastname(currentUser.getLastname() != null ? currentUser.getLastname() : user.getLastname());
		user.setUserName(currentUser.getUserName() != null && userService.checkAvailableUsername(currentUser.getUserName()) ? 
				currentUser.getUserName() : user.getUserName());
		user.setPassWord(currentUser.getPassWord() != null ? Integer.toString(currentUser.getPassWord().hashCode()): user.getPassWord());
		user.setEmail(currentUser.getEmail() != null && userService.checkAvailableEmail(currentUser.getEmail()) ? 
				currentUser.getEmail() : user.getEmail());
		userService.updateUserInfo(user);
//		Users loggedUser = userService.getUserByCredentials(currentUser.getUserName(), currentUser.getPassWord());
//		if (loggedUser == null) {
//			return null;
//		} else {
//			session.setAttribute("loggedInUser", loggedUser);
//			System.out.println(loggedUser);
//			loggedUser.setPassWord("");
//			return loggedUser;
//		}
		//session.setAttribute("loggedInUser", user);
		//Users user2 = (Users) session.getAttribute("loggedInUser");
		user.setPassWord("");
		return user;
	}

	/**
	 * This endpoint is responsible for checking if a specified email is available to use in the website
	 * @param email is the String object representing the email to be checked for availability
	 * @return a boolean indicating if the email is available for use
	 */
	@GetMapping(value = "/checkAvailableEmail")
	public /* @ResponseBody */ boolean checkAvailableEmail(@RequestParam("email") String email) {
		return userService.checkAvailableEmail(email);
	}

	/**
	 * This endpoint is responsible for checking if a specified username is available to use in the website
	 * @param username is the String object representing the username to be checked for availability
	 * @return a boolean indicating if the username is available for use
	 */
	@GetMapping(value = "/checkAvailableUsername")
	public /* @ResponseBody */ boolean checkAvailableUsername(@RequestParam("username") String username) {
		return userService.checkAvailableUsername(username);
	}
	
	/**
	 * This endpoint is responsible for retrieving users from the database by name
	 * @param username is a String object representing the username used to retrieve a user 
	 * @return a Users object representing the user retrieved from the database
	 */
	@GetMapping(value = "/getUsersByName")
	public /* @ResponseBody */ List<Users> getUserByUsername(@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName) {
		return userService.getUserByName(firstName, lastName);
	}
	
	@GetMapping(value = "/getAllUsers")
	public /* @ResponseBody */ List<Users> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@PostMapping(value = "/insertUserImage")
	public boolean addImageToUser(@RequestBody Users u) {
		int id = u.getUserId();
		System.out.println(id);
		String profImg = u.getProfileImg();
		System.out.println(profImg);
		
		Users user = userService.getUserById(id);
		user.setProfileImg(profImg);
		userService.updateUserInfo(user);
		return userService.getUserById(id).getProfileImg().equals(profImg);
	}
	
	@PostMapping(value = "/updateUserImage")
	public boolean changeImageOnUser(@RequestBody Users u) {
		int id = u.getUserId();
		String profImg = u.getProfileImg();
		
		Users user = userService.getUserById(id);
		user.setProfileImg(profImg);
		userService.updateUserInfo(user);
		return userService.getUserById(id).getProfileImg().equals(profImg);
	}

}

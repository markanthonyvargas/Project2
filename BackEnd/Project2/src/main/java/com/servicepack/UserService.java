package com.servicepack;

import java.util.List;

import com.models.Users;

public interface UserService {
	
	/**
	 * This method is responsible for adding a user to the databse
	 * @param userObj represents the User to be added
	 */
	public void addUser(Users userObj);
	
	/**
	 * This method is responsible for returning all users in the database
	 * @return a List of all users in the database
	 */
	public List<Users> getAllUsers();
	
	/**
	 * This method is responsible for selecting a user by their id
	 * @param id represent the user's id
	 * @return a User object representing the user found
	 */
	public Users getUserById(int id);
	
	/**
	 * This method is responsible for selecting a user by their first and last name
	 * @param firstname represents the user's first name
	 * @param lastname represents the user's last name
	 * @return a User object representing the user found
	 */
	public List<Users> getUserByName(String firstname, String lastname);
	
	/**
	 * This method is responsible for selecting a user by their username and password, mainly used for login purposes
	 * @param username represents the user's username
	 * @param password represents the user's password
	 * @return a User object representing the user found 
	 */
	public Users getUserByCredentials(String username, String password);
	
	/**
	 * This method is responsible for selecting a user by their username
	 * @param username represents the user's username
	 * @return a User object representing the user found
	 */
	public Users getUserByUsername(String username);
	
	/**
	 * This method is responsible for checking the availability of a username
	 * @param username represents the username to be checked
	 * @return a boolean indicating the availability of the username
	 */
	public boolean checkAvailableUsername(String username);
	/**
	 * This method is responsbile for checking the availability of an email
	 * @param email represents the email to be checked
	 * @return a boolean indicating the availability of the email
	 */
	public boolean checkAvailableEmail(String email);
	
	/**
	 * This method is responsible for updating a User in the database
	 * @param userObj represents the user object to be updated
	 */
	public void updateUserInfo(Users userObj);
	
	/**
	 * This method is responsible for deleting a user from the database
	 * @param userObj represents the user object to be deleted
	 */
	public void deleteUser(Users userObj);
}


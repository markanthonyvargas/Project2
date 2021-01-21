package com.repo;

import java.util.List;

import com.models.Users;
/**
 * * Dao interface for our user object 
 * @author Nicho
 */
public interface UserRepo {
	
	/**
	 * This method is responsible for insert a user into the database
	 * @param userObj represents the User that will be inserted
	 */
	public void insert(Users userObj);
	
	/**
	 * This method is responsible for updating a Users object in the database 
	 * @param userObj represents the User that will be updated
	 */
	public void update(Users userObj);
	
	/**
	 * This method is responsible for deleting a user from the database
	 * @param userObj represents the User that will be deleted
	 */
	public void delete(Users userObj);
	
	/**
	 * This method is responsible for selecting a User based on the userId
	 * @param id represents the user's ID
	 * @return a User object representing the user found
	 */
	public Users selectById(int id);
	
	/**
	 * This method is responsible for returning all users in the databse
	 * @return a List of Users in the database
	 */
	public List<Users> selectAll();
	
	/**
	 * This method is responsible for selecting a user by their first and last name
	 * @param firstname is a String object representing the user's first name
	 * @param lastname is a String object representing the user's last name
	 * @return a Users object representing the user found
	 */
	public List<Users> selectByFullName(String firstname, String lastname);
	
	/**
	 * This method is responsible for selecting a user by their username and password, mainly used for login purposes 
	 * @param username is a String object that represents the user's username
	 * @param password is a String object that represents the user's password
	 * @return a Users object representing the user found
	 */
	public Users selectByCredentials(String username, String password);
	
	/**
	 * This method is responsible for selecting a user by their username
	 * @param username is a String object that represents the username to select the user by
	 * @return a Users object representing the user found
	 */
	public Users selectByUsername(String username);

	/**
	 * This method is responsible for selecting a user by their email
	 * @param email is a String object that represents the email to select the user by
	 * @return a Users object representing the user found
	 */
	public Users selectByEmail(String email);


	

}

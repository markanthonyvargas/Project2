package com.servicepack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.models.Users;
import com.repo.UserRepo;
import com.repo.UserRepoImpl;

/**
 * This is the implementation of the methods found in UserService. This is responsible for acting as the service layer
 *  of our database involving the Users table
 * @author Nicholas Deters, Andrew Kellar, William Stone, Mark Anthony Vargas, Justin Wen
 *
 */
@Service
public class UserServiceImpl implements UserService {
	UserRepo useDao;
	
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	public UserServiceImpl(UserRepo useDao) {
		this.useDao = useDao;
	}
	
	@Override
	public void addUser(Users userObj) {
		
		useDao.insert(userObj);
		
	}

	@Override
	public List<Users> getAllUsers() {
		return useDao.selectAll();
	}

	@Override
	public Users getUserById(int id) {
		
			return useDao.selectById(id);
	}

	@Override
	public List<Users> getUserByName(String firstName, String lastName) {
		
//		return useDao.selectByName(firstname, lastname);
		return useDao.selectByFullName(firstName, lastName);

	}

	@Override
	public Users getUserByCredentials(String username, String password) {
		return useDao.selectByCredentials(username, password);
	}

	@Override
	public Users getUserByUsername(String username) {
		return useDao.selectByUsername(username);
	}

	@Override
	public boolean checkAvailableUsername(String username) {
		return (useDao.selectByUsername(username)  == null);
	}

	@Override
	public boolean checkAvailableEmail(String email) {
		return (useDao.selectByEmail(email)  == null);
	}

	@Override
	public void updateUserInfo(Users userObj) {
		useDao.update(userObj);
	}

	@Override
	public void deleteUser(Users userObj) {
		useDao.delete(userObj);
	}

}

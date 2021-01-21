package com.controllerpack;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.models.Users;
import com.servicepack.UserService;

/**
 * This class serves as the controller for login related endpoints
 * @author Nicholas Deters, Andrew Kellar, William Stone, Mark Anthony Vargas, Justin Wen
 *
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class LoginController {
	private UserService userService;

	public LoginController() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	public LoginController(UserService userService) {
		super();
		this.userService = userService;
	}

	// endpoint for getting all posts from a specified user
	@PostMapping(value = "/login")
	public /* @ResponseBody */ Users login(HttpSession session, @RequestBody Users currentUser) {
		System.out.println("in the login method");
		System.out.println(currentUser);
		Users loggedUser = userService.getUserByCredentials(currentUser.getUserName(), Integer.toString(currentUser.getPassWord().hashCode()));
		if (loggedUser == null) {
			return null;
		} else {
			//session.setAttribute("loggedInUser", loggedUser);
			System.out.println(loggedUser);
			loggedUser.setPassWord("");
			return loggedUser;
		}
	}
}

package com.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This is the model for Users The class attributes for this model are: userId:
 * (the primary key for users) firstname: (the first name of the user) lastname:
 * (the last name of the user) username: (the user's username) password: (the
 * user's password) email: (the user's email) authoredPosts: (the list of posts
 * written by this user) likedPosts: (the list of posts like by this user)
 * 
 * The class methods are the constructors, getter/setter methods, and to
 * String()
 * 
 * This class utilizes Spring with Hibernate to persist this class into our
 * relational database
 * 
 * @author Nicholas Deters, Andrew Kellar, William Stone, Mark Anthony Vargas,
 *         Justin Wen
 *
 */
@Entity
@Table(name = "Users")
//public class Users<BitMap> {
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;

	@Column(name = "first_name", nullable = false, unique = false)
	private String firstname;

	@Column(name = "last_name", nullable = false, unique = false)
	private String lastname;

	@Column(name = "username", nullable = false, unique = true)
	private String userName;

	@Column(name = "password", nullable = false, unique = false)
	private String passWord;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "profilepic", nullable = false)
	private String profileImg;

	@OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
	private List<Posts> authoredPosts;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "likes")
	// @ManyToMany(mappedBy = "likes")
	private List<Posts> likedPosts;

//	@Column(name = "profilePic", nullable=true, unique=false)
//	private BitMap image;

	public Users() {

	}

	public Users(int userId, String firstname, String lastname, String userName, String passWord, String email,
			String profileImg, List<Posts> authoredPosts, List<Posts> likedPosts) {
		super();
		this.userId = userId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.profileImg = profileImg;
		this.authoredPosts = authoredPosts;
		this.likedPosts = likedPosts;
	}

	public Users(String firstname, String lastname, String userName, String passWord, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.authoredPosts = new ArrayList<>();
		this.likedPosts = new ArrayList<>();
		this.profileImg = "";
	}

	public Users(String firstname, String lastname, String userName, String passWord, String email, String profileImg) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.userName = userName;
		this.passWord = passWord;
		this.email = email;
		this.profileImg = profileImg;
		this.authoredPosts = new ArrayList<>();
		this.likedPosts = new ArrayList<>();
	}

//	public Users(int userId, String firstname, String lastname, String userName, String passWord, String email) {
//		super();
//		this.userId = userId;
//		this.firstname = firstname;
//		this.lastname = lastname;
//		this.userName = userName;
//		this.passWord = passWord;
//		this.email = email;
//	}

//	public Users(String firstname, String lastname, String userName, String passWord, String email,
//			List<Posts> authoredPosts) {
//		super();
//		this.firstname = firstname;
//		this.lastname = lastname;
//		this.userName = userName;
//		this.passWord = passWord;
//		this.email = email;
//		this.authoredPosts = authoredPosts;
//	}

	@JsonIgnore
	public List<Posts> getAuthoredPosts() {
		return authoredPosts;
	}

	public void setAuthoredPosts(List<Posts> authoredPosts) {
		this.authoredPosts = authoredPosts;
	}

	@JsonIgnore
	public List<Posts> getLikedPosts() {
		return likedPosts;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	public void setLikedPosts(List<Posts> likedPosts) {
		this.likedPosts = likedPosts;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Users \n\t\t[userId=" + userId + ", firstname=" + firstname + ", lastname=" + lastname + ", userName="
				+ userName + ", passWord=" + passWord + ", email=" + email + ", authoredPosts=" + authoredPosts
				+ ", likedPosts=" + likedPosts + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Users user = (Users) obj;

		return this.userId == user.userId;
	}

//	public BitMap getImage() {
//		return image;
//	}
//
//
//	public void setImage(BitMap image) {
//		this.image = image;
//	}

}

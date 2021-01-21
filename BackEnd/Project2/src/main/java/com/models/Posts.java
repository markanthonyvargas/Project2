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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * This is the model for Posts
 * The class attributes for this model are:
 * postId (the primary key for posts), 
 * description: (the body of the post), 
 * author: (the author who created the post). 
 * 
 * The class methods are the constructors, 
 * getter/setter methods, and to String(). 
 * 
 * This class utilizes Spring with Hibernate to 
 * persist this class into our relational 
 * database
 * @author Nicholas Deters, Andrew Kellar, William Stone, Mark Anthony Vargas, Justin Wen
 *
 */
@Entity
@Table(name = "Posts")
public class Posts {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="post_id")
	private int postId;
	
	@Column(name = "description", nullable=false, columnDefinition="TEXT")
	private String description;
	
	@Column(name = "post_img")
	private String postImg;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="author_fk")
	private Users author;
	
	@ManyToMany(cascade= {CascadeType.PERSIST, CascadeType.REFRESH}, fetch=FetchType.EAGER)
//	 @ManyToMany(cascade = { CascadeType.ALL })
//	    @JoinTable(
//	        name = "Post_User_Likes", 
//	        joinColumns = { @JoinColumn(name = "user_id") }, 
//	        inverseJoinColumns = { @JoinColumn(name = "post_id") }
//	    )
	private List<Users> likes;

	public Posts() {
	}

	public Posts(int postId, String description, String postImg, Users author, List<Users> likes) {
		super();
		this.postId = postId;
		this.description = description;
		this.postImg = postImg;
		this.author = author;
		this.likes = likes;
	}

	public Posts(String description, Users author) {
		super();
		this.description = description;
		this.author = author;
		this.postImg = null;
		this.likes = new ArrayList<>();
	}
	
	

	public Posts(String description, String postImg, Users author) {
		super();
		this.description = description;
		this.postImg = postImg;
		this.author = author;
		this.likes = new ArrayList<>();
	}

	public String getPostImg() {
		return postImg;
	}

	public void setPostImg(String postImg) {
		this.postImg = postImg;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	//@JsonIgnore
	public Users getAuthor() {
		return author;
	}

	public void setAuthor(Users author) {
		this.author = author;
	}

	//@JsonIgnore
	public List<Users> getLikes() {
		return likes;
	}

	public void setLikes(List<Users> likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		
		String postString = "Posts \n\t\t[postId=" + postId + ", description=" + description + ", author=" 
				+ author.getFirstname() + " " + author.getLastname() + ", likes=";
		
		for(Users u: likes) {
			postString += " " + u.getFirstname() + " " + u.getLastname();
		}
		
		return postString;
	}
	
	
}

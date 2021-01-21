package com.models;

public class Like {
	private String userName;
	private int postId;
	
	public Like() {
		// TODO Auto-generated constructor stub
	}

	public Like(String userName, int postId) {
		super();
		this.userName = userName;
		this.postId = postId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	@Override
	public String toString() {
		return "Like [userName=" + userName + ", postId=" + postId + "]";
	}
	
	
}

package model.vo;

import java.util.TreeSet;

public class User implements java.io.Serializable{

	private String userId;
	private String userPw;
	private String nickname;
	private String email;
	private TreeSet userIngred;
	
	
	public User() {}
	
	public User(String userId, TreeSet userIngred) {
		super();
		this.userId = userId;
		this.userIngred = userIngred;
	}
	
	public User(int userNo, String userId, String userPw, String nickname, String email, TreeSet userIngerd) {
		this.userId = userId;
		this.userPw = userPw;
		this.nickname = nickname;
		this.email = email;
		this.userIngred = userIngerd;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserPw() {
		return userPw;
	}


	public String getNickname() {
		return nickname;
	}

	public String getEmail() {
		return email;
	}
	
	public TreeSet getUserIngred() {
		return userIngred;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}


	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setUserIngred(TreeSet userIngred) {
		this.userIngred = userIngred;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPw=" + userPw + ", nickname=" + nickname + ", email=" + email
				+ ", userIngred=" + userIngred + "]";
	}

	
}

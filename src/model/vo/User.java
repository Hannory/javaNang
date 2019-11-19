package model.vo;

public class User implements java.io.Serializable{
	private int userNo;
	private String userId;
	private String userPw;
	//private String checkPw;
	private String nickname;
	private String email;
	
	
	public User() {}
	

	
	public User(int userNo, String userId, String userPw, String nickname, String email) {
		this.userId = userId;
		this.userPw = userPw;
		this.nickname = nickname;
		this.email = email;
	}
	
	public int getUserNo() {
		return userNo;
	}

	public String getUserId() {
		return userId;
	}

	public String getUserPw() {
		return userPw;
	}

	/*public String getCheckPw() {
		return checkPw;
	}*/

	public String getNickname() {
		return nickname;
	}

	public String getEmail() {
		return email;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	/*public void setCheckPw(String checkPw) {
		this.checkPw = checkPw;
	}*/

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return userId + "/" + userPw + "/" + nickname + "/" + email;
	}
}

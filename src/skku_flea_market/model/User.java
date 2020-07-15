package skku_flea_market.model;

public class User {
	private String userID;
	private String userPW;
	private String user_email;
	private String user_type;

	public User() {
	}

	public User(String userID, String userPW, String user_email, String user_type) {
		super();
		this.userID = userID;
		this.userPW = userPW;
		this.user_email = user_email;
		this.user_type = user_type;
	}

	public User(String userID, String userPW, String user_type) {
		super();
		this.userID = userID;
		this.userPW = userPW;
		this.user_type = user_type;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return userPW;
	}

	public void setPassword(String userPW) {
		this.userPW = userPW;
	}

	public String getEmail() {
		return user_email;
	}

	public void setEmail(String user_email) {
		this.user_email = user_email;
	}

	public String getType() {
		return user_type;
	}

	public void setType(String user_type) {
		this.user_type = user_type;
	}
}

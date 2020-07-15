package skku_flea_market.model;

import java.io.Serializable;

public class LoginBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String userID;
	private String userPW;

	public String getID() {
		return userID;
	}

	public void setID(String userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return userPW;
	}

	public void setPassword(String userPW) {
		this.userPW = userPW;
	}
}

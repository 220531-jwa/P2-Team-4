package dev.team4.models;

public class User {
	int id;
	String userUserName;
	String userPassword;
	boolean isAdmin;

	public User() {

	}

	public User(int id, String userUserName, String userPassword, boolean isAdmin) {
		this.id = id;
		this.userUserName = userUserName;
		this.userPassword = userPassword;
		this.isAdmin = isAdmin;
	}

	// ID
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// USERNAME
	public String getUserUserName() {
		return userUserName;
	}

	public void setUserUserName(String userUserName) {
		this.userUserName = userUserName;
	}

	// PASS
	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	// ADMIN
	public boolean getAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	// OVERDRIVE
	@Override
	public String toString() {
		return "User [id=" + id + ", userUserName=" + userUserName + ", userPassword=" + userPassword + ", isAdmin="
				+ isAdmin + "]";
	}
}
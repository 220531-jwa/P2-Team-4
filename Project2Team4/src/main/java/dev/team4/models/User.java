package dev.team4.models;

public class User {
	int id;
	String username;
	String pass;
	boolean isAdmin;

	public User() {

	}

	public User(int id, String username, String pass, boolean isAdmin) {
		this.id = id;
		this.username = username;
		this.pass = pass;
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
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	// PASS
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
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
		return "User [id=" + id + ", username=" + username + ", pass=" + pass + ", isAdmin=" + isAdmin + "]";
	}
}
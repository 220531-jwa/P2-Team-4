package dev.team4.services;

import java.util.List;

import dev.team4.models.User;
import dev.team4.repo.UserDAO;

public class UserService {

	// USERDAO.JAVA CONNECITON
	private static UserDAO ud;

	public UserService(UserDAO ud) {
		UserService.ud = ud;
	}

	// LOGIN
	public User login(String userUserName, String userPassword) {
		User u = ud.getUserUserName(userUserName);
		if (u.getUserUserName().equals(userUserName)) {
			if (u.getUserPassword().equals(userPassword)) {
				return u;
			} else {
				// WRONG UESRNAME OR PASSWORD
				System.out.println("Invalid credentials");
				return null;
			}
		} else {
			// WRONG USERNAME
			System.out.println("Invalid username");
			return null;
		}
	}

	// CREATE USER
	public User createUser(String userUserName, String userPassword, Boolean isAdmin) {
		return ud.createUser(userUserName, userPassword, isAdmin);
	}

	// GET ALL USERS
	public List<User> getAllUsers() {
		return ud.getAllUsers();
	}

	// GET USER ID
	public User getUserById(int id) throws Exception {
		User u = ud.getUserById(id);

		if (u == null) {
			throw new Exception("User not found");
		}
		return u;
	}

	// UPDATE PASSWORD
	public User updatePassword(int id, String userPassword) {
		return ud.updatePassword(id, userPassword);
	}

	// DELETE USER
	public void deleteUser(int id) {
		ud.deleteUser(id);
	}
}
package dev.team4.services;

import java.util.List;

import dev.team4.models.Flight;
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
	public User createUser(User u) {
		User createdUser = ud.createUser(u);
		return createdUser;
	}

	// CREATE FLIGHT
	public Flight createFlight(Flight flight) {
		if (flight.getAirline().equals("") || flight.getArriving() == null || flight.getDeparting() == null) {
			return null;
		}
		return ud.createFlight(flight);
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

	// GET USERNAME
	public User getUserByUserName(String userUserName) throws Exception {
		User u = ud.getUserUserName(userUserName);
		if (u == null) {
			throw new Exception("User not found");
		}
		return u;
	}

	// UPDATE USER
	public boolean updateUser(User u) {
		if (u != null) {
			return ud.updateUser(u);
		}
		return true;
	}

	// DELETE USER
	public void deleteUser(int id) {
		ud.deleteUser(id);
	}
}
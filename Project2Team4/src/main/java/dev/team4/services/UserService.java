package dev.team4.services;

import dev.team4.models.Flight;
import dev.team4.models.User;
import dev.team4.repo.UserDAO;

public class UserService {

    private static UserDAO ud;

    public UserService(UserDAO ud) {
        this.ud = ud;
    }

    public User login(String username, String password) {
        User u = ud.GetUserByUserName(username);

        if (u.getUserUserName().equals(username)) {
            if (u.getUserPassword().equals(password)) {
                return u;
            } else {
                System.out.println("Invalid credentials");
                return null;

            }
        } else {
            System.out.println("Invalid username");
            return null;
        }

    }

    public Flight createFlight(Flight flight) {
        if (flight.getAirline().equals("") || flight.getArriving() == null || flight.getDeparting() == null) {
            return null;
        }
        return ud.createFlight(flight);
    }
}

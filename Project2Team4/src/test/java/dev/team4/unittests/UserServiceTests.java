package dev.team4.unittests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.team4.models.User;
import dev.team4.repo.UserDAO;
import dev.team4.services.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

	// MOCK
	@InjectMocks
	private static UserService mockUs;
	@Mock
	private static UserDAO mockUd;

	@BeforeEach
	public void setupEach() {
		mockUs = new UserService(mockUd);
	}

	// LOGIN CUSTOMER
	@Test
	public void loginCustomerUser() {
		// Given
		User mock = new User(1, "demonLord", "pokemon", false);
		// When
		when(mockUd.GetUserByUserName("demonLord")).thenReturn(mock);
		// Then
		assertEquals(mock, mockUs.login("demonLord", "pokemon"));
	}

	// LOGIN ADMIN
	@Test
	public void loginAdminUser() {
		// Given
		User mock = new User(1, "king", "felleman", true);
		// When
		when(mockUd.GetUserByUserName("king")).thenReturn(mock);
		// Then
		assertEquals(mock, mockUs.login("king", "felleman"));
	}

	// WRONG CUSTOMER LOGIN CREDENTIALS
	@Test
	public void invalidCustomerLogin() {
		// Given
		User mock = new User(3, "kanto", "services", false);
		// When
		when(mockUd.GetUserByUserName("micky")).thenReturn(mock);
		// Then
		assertNotEquals(mock, mockUs.login("micky", "mouse"));
	}

	// WRONG ADMIN LOGIN CREDENTIALS
	@Test
	public void invalidAdminLogin() {
		// Given
		User mock = new User(2, "calin", "fine", true);
		// When
		when(mockUd.GetUserByUserName("octus")).thenReturn(mock);
		// Then
		assertNotEquals(mock, mockUs.login("octus", "yes"));
	}
}

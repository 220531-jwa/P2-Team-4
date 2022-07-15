// PACKAGE
package dev.team4.unittests;

// IMPORTS
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

// MOCKITO EXTENSION
@ExtendWith(MockitoExtension.class)

// CLASS
public class UserServiceTests {

	// MOCK WITH UserService.java
	@InjectMocks
	private static UserService mockUs;

	// MOCK WITH UserDAO.java
	@Mock
	private static UserDAO mockUd;

	// BEFORE EACH MOCK
	@BeforeEach
	public void setupEach() {
		mockUs = new UserService(mockUd);
	}

	// VALID CUSTOMER LOGIN
	@Test
	public void validCustomerlogin() {
		// Given
		User mock = new User(1, "demonLord", "pokemon", false);
		// When
		when(mockUd.getUsername("demonLord")).thenReturn(mock);
		// Then
		assertEquals(mock, mockUs.login("demonLord", "pokemon"));
	}

	// VALID ADMIN LOGIN
	@Test
	public void validAdminlogin() {
		// Given
		User mock = new User(1, "king", "felleman", true);
		// When
		when(mockUd.getUsername("king")).thenReturn(mock);
		// Then
		assertEquals(mock, mockUs.login("king", "felleman"));
	}

	// INVALID CUSTOMER LOGIN
	@Test
	public void invalidCustomerlogin() {
		// Given
		User mock = new User(3, "kanto", "services", false);
		// When
		when(mockUd.getUsername("micky")).thenReturn(mock);
		// Then
		assertNotEquals(mock, mockUs.login("micky", "mouse"));
	}

	// INVALID ADMIN LOGIN
	@Test
	public void invalidAdminlogin() {
		// Given
		User mock = new User(2, "calin", "fine", true);
		// When
		when(mockUd.getUsername("octus")).thenReturn(mock);
		// Then
		assertNotEquals(mock, mockUs.login("octus", "yes"));
	}
}

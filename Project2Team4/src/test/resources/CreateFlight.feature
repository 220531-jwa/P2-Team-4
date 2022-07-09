Feature: Admin Creates a Flight

  Background:
    Given a Admin is on the AdminHomePage

  Scenario Outline: An Admin can create a Flight
    When the Admin types in the "<airline>", "<arrival>", and "<departure>" and clicks the CreateFlightButton
    Then the Flight should be created

    Examples:
      | airline | arrival  | departure |
      | Delta   | 16:30:00 | 08:00:00  |
      | United  | 12:00:00 | 05:00:00  |

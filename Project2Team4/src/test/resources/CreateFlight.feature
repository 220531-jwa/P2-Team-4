Feature: Admin Creates a Flight

  Background:
    Given a Admin is on the CreateFlightPage

  Scenario Outline: An Admin can create a Flight
    When the Admin types in the "<airline>", "<arrival>", and "<departure>" and clicks the CreateFlightButton
    Then the Admin is back on the HomePage

    Examples:
      | airline | arrival | departure |
      | Delta   | 12:30PM | 08:00AM   |
      | United  | 12:00PM | 05:00AM   |

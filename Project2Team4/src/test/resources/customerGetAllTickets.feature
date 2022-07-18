Feature: Showing all Tickets

  Background: 
  				Given a Customer is on the login page they can login go to customer landing page and see all ticket
 
  Scenario Outline: A Customer can see all the tickets 
  When the Customer types in their "<username>" and "<password>" and clicks the Login button
  Then the user should be on the home page with all tickets available
 
     Examples: 
      | username  | password |
      |  khelilusername |   khelilpass  |
      #|  stephenusername |   stephenpass  |
      |  tylerusername |   tylerpass  |
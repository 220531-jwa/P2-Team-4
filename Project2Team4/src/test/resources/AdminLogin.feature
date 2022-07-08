#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Admin Login

	Background:
				Given a Admin is on the Login Page
 
  Scenario Outline: A Admin can login using their credentials
    When the Admin types in their "<username>" and "<password>" and clicks the Login button
    Then the Admin should be on the Admin Homepage

    Examples: 
      | username  | password  |
      |  tyler    | Blackmon  |
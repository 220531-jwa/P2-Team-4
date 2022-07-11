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

Feature: Customer Login

	Background:
				Given a Customer is on the Login Page
 
  Scenario Outline: A Customer can login using their credentials
    When the Customer types in their "<username>" and "<pass>" and clicks the Customer Login button
    Then the Customer should be on the Customer Homepage

    Examples: 
      | username        | pass        |
      | stephenusername | stephenpass |
      | tylerusername   | tylerpass   |
      | andyusername    | andypass    |
      | khelilusername  | khelilpass  |

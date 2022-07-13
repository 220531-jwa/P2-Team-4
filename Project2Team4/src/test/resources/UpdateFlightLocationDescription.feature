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
Feature: Update Flight Location Description

	Background: 
					Given the administrator is on the Admin Edit Description Page

  Scenario Outline: A administrator can update a flight location description
    When the Admin types in the "<flightid>" and "<flightdescription>" and clicks the submit button
    Then the Admin should be able to see the description changed in the Admin Home Page

    Examples: 
      | flightid | flightdescription |
      | 1        |    Cairo          |
      | 4        |    Kyoto          |

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

Feature:

	Admin Get All Tickets

Background:

	Given The Admin is on the Admin Login Page to login so they can go to the Admin Home Page to see all the tickets

Scenario Outline:

	An Admin can see all the tickets

	When The Admin types in their "<username>" and "<pass>" and clicks the Admin Login button
	Then The Admin should be on the Admin Home Page with all the tickets
 
Examples:

	| username        | pass        |
	| stephenusername | stephenpass |
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

	Admin Creates a Flight

Background:

	Given The Admin is on the Create Flight Page

Scenario Outline:

	An Admin can create a Flight
	
	When The Admin types in the "<airline>", "<arrival>", and "<departure>" and clicks the Create Flight Button
  Then The Admin is back on the Admin Home Page

 Examples:
 
	| airline | arrival  | departure |
	| United  | 01:30:00 | 11:00:00  |
	| Spirit  | 02:00:00 | 12:00:00  |
	| Delta   | 03:00:00 | 13:00:00  |
	| JetBlue | 04:00:00 | 14:00:00  |
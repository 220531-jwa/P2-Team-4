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

	Customer Get All Tickets

Background: 

	Given A Customer is on the Customer Login Page to login so they can go to the Customer Home Page to see all their tickets

Scenario Outline: A Customer can see all their tickets 

	When A Customer types in their "<username>" and "<pass>" and clicks the Customer Login button
	Then A Customer should be on the Customer Home Page with all their tickets
 
Examples:

	| username       | password   |
	| tylerusername  | tylerpass  |
	| andyusername   | andypass   |
	| khelilusername | khelilpass |
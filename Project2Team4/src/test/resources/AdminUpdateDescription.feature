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
	
	Admin Update Description

Background: 

	Given The Admin is on the Admin Edit Description Page
	
Scenario Outline:

	The Admin can update a flight location description

	When The Admin types in the "<flightid>" and "<description>" and clicks the update button
	Then The Admin should be able to see the description changed in the Admin Home Page

Examples: 
	
	| id | description               |
  | 1  | It used to have pharaohs. |
  | 2  | There is a royal family.  |
  | 3  | It has kangaroos.         |
  | 4  | It used to have samurais. |
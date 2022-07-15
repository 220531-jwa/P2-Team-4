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

	Customer Cancel Ticket

Background:

	Given A Customer is on the Cancel Ticket Page

Scenario Outline: A Customer can cancel their ticket

	When A Customer enters the "<ticketid>" and clicks the cancel button
	ThenAa Customer can be redirected to the Customer Home Page

Examples:

	| ticketid |
  | 1	       |
  | 2        |
@Regression
Feature: Title of your feature
	I want to use this template for my feature file
	
@Positive
Scenario Outline: Title of your Scenario Outline
Given User need to open any browser 
And Put application "<App Link>"
And put username "<Username>"
And put password "<Password>"
And click login button
Then login will be successful with valid credential 
Then close the browser when test finish

Examples:
			|App Link | Username   | Password   |
			|App Link | Username   | Password 	|
			|App Link | Username2  | Password2  |
			|App Link | Username3  | Password3  |

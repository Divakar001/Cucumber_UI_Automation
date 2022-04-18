@GetCEOName
Feature: This feature is to get the CEO name from the orangeHRM app
Scenario Outline: This test is to verify the CEO name
	Given the user is logged in successfully and is on home PAge
	When the user clicks on the directory option from the menu bar
	And  the user selects the job title as "Chief Executive Officer" from the drop down using "text"
	And click the search button
	Then the user should see the CEO name as "John Smith"
Examples:
|Chief Executive Officer|
|John Smith|
	
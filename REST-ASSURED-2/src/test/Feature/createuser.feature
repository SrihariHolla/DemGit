Feature: create user functionality
Scenario: verify create user functionality
Given I provide endpoint
And I create object for requestspecification
When I proide body for file
And I execute post Method
Then I find 201 statuscode
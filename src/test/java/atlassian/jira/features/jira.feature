Feature: JIRA - Atlassian

@smoke @regression
Scenario Outline: Create JIRA issue using files in the request body
Given Add the necessary request specification
And Create the new issue using the filename as "<filename>"
And Place the request for Create
And Verify the status code as 201
And Verify the content type of the response
And Verify the response body contains the string as "<expectedstring>"
And Print the response body with status code
And Get the issue key from the response

Examples:
|filename|expectedstring|
|createissue1.json|RA|
|createissue2.json|RA|

@smoke @regression
Scenario Outline: Update JIRA issue using files in the request body
Given Add the necessary request specification
And Update the new issue using the filename as "<filename>"
And Place the request for Update
And Verify the status code as 204
And Verify the content type of the response
And Print the response body with status code

Examples:
|filename|
|updateissue1.json|

@production
Scenario Outline: Get the random issue
Given Add the necessary request specification
And Get the random number using program using max value as <max>
And Place the request for Get
And Verify the status code as 200
And Print the response body with status code
And Get the issue key from the response

Examples:
|max|
|128|

@regression @production
Scenario: Delete JIRA issue by passing the issue key
Given Add the necessary request specification
When Place the request for Delete
Then Verify the status code as 204
And Print the response body with status code

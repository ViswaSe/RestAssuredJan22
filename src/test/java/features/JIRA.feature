Feature: JIRA - Atlassian module

Scenario Outline: Create New JIRA issue
Given Add the necessary request specification
And Add the body file for create using the filename as "<filename>"
And Place the request for Post
Then Verify the status code as 201
And Verify the content type of the response
And Print the response body with status code
And Verify the below response from the response body
#datatable
|key|RA|
And Capture the issue key from the response

Examples:
|filename|
|createissue1.json|
|createissue2.json|

Scenario Outline: Update JIRA issue via chaining
Given Add the body file for update using the filename as "<filename>"
And Place the request for Put
Then Verify the status code as 204
And Verify the content type of the response

Examples:
|filename|
|updateissue.json|

Scenario: Delete JIRA issue via chaining
When Place the request for Delete
Then Verify the status code as 204
And Verify the content type of the response

Scenario: Get All JIRA issues
Given Add the necessary request specification
And Add the necessary query parameters
When Place the request for Get
Then Verify the status code as 200
And Verify the content type of the response
And Print the response body with status code
And Verify the below response validations
#datatable
|self|https://restapi2022.atlassian.net/rest/api/2/issue|
|key|RA|
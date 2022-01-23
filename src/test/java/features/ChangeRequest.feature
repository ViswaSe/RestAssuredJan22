Feature: Change Request Module in Service Now

Scenario Outline: Create a New Change Request
Given Setup the Endpoint and URI
And Set the authentication with username as "<username>" and password as "<password>"
When Add all the required request specification
And Add the request body as "<filename>"
And Place the request
Then Verify the status code of the response as 201
And Verify the content type of the response
Then Print the response and status code

Examples:
|username|password|filename|
|admin|wKFaYB7jp2lB|CreateChangeRequestUsingCucumber1.json|
|admin|wKFaYB7jp2lB|CreateChangeRequestUsingCucumber2.json|
Feature: Change Request in Service Now

#Background: 
#Given Setup the endpoint and URI for the request
#And Setup the authentication with username as 'admin' and password as 'wKFaYB7jp2lB'

Scenario Outline: Create New Change Request in Service Now

Given Add the necessary request specification for the request
And Add body as a file with the filename as "<filename>"
When Place the request
Then Verify the response status code as 201
Then Verify the response content Type
And Print the response in the console

Examples:
|filename|
|createCR1.json|
|createCR2.json|
|createCR3.json|

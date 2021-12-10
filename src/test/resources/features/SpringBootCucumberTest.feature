Feature: Feature example

@API
Scenario: Testing GET to endpoint
	Given I send a GET request to the endpoint
	Then I get a 200 status code

Scenario: Validate the number of entries in the response.
	Given I send a GET request to the https://jsonplaceholder.typicode.com URI
	Then I am going to validate that there are 10 items on /users endpoint

#Scenario: Validate an element in the response
#	Given I send a GET request to the https://jsonplaceholder.typicode.com URI
#	Then I validate Bret in the response at /users endpointF

#Scenario: Validate a JSON element in the response
#	Given I send a GET request to the https://jsonplaceholder.typicode.com URI
#	Then I can validate the nested value: Victor Plains in the response at /users endpoint
# Validar algún escenario que tenga varios pasos incluídos
	#
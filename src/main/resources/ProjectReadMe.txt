Title: User Registration and Login App

Description: Creating an app to provide Registration Functionality.

Endpoints: 
	/register 
		- A new user can register itself using this endpoint. DB will have a userprofile table. On successful registration, a new userprofile entry will be created in DB. 
		- an email should be sent to user with an Activate Profile link and user will be able to set his password using the activation link. 
		- Activate profile must take some identifier as input before creating a new password. 
		
		DB SCHEMA: User[FirstName, LastName, Email, Phone, UserID]   
		
	/activation
		-	Endpoint for userprofile activation and password creation of user. 
		DB SChema: USerId, ActivationToken, isValid, createdAt
		
	/changepassword 
		- Endpoint if user wants to update its password. 
		
	/roles
		- End point to assign role to user. 
		
	/login
		- Enpoint for login to the system. User will supply unique combination of username and password. On success, a valid JWT token will be generated with user roles.
		
		


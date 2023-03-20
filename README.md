# Employee-Registration-System
Spring Boot Project to register employees in a company

Employee Registration Management System
Summary:
This is a Web 2.0 Application that allows the registration of Employee details in the system. This application provides the organization with insights into their workforce and helps in better tracking them. Since this is a Web 2.0 Application, the Users can consume as well as produce the data i.e., Employees and Admins can read the existing Employee records as well as add, modify, and remove the records based on the rights assigned to them. There is also a additional feature to manage posts/updates in the organization.
Purpose:
•	Managing Employee Registration – CRUD operations
•	Managing Posts posted by the Employees – CRD operations
Users:
•	Admin Employee
•	Regular Employee
Database Tables:
•	User
•	Post
Features:
•	Admin Employees
o	Access to CRUD operations over all the Employees data
o	Access to CRD operations over all the Employee Posts
•	Regular Employees
o	Access to R operation over all the Employees data
o	Access to U operation over their personal data
o	Access to CR operations over all the Employee Posts
o	Access to D operation over their personal post
o	Cannot change their details like First Name, Last Name, Admin access and Email ID except Password (they need to approach Admin employees to change these fields)
•	Session Timeout: 120 sec (Adjusted to 2min for the purpose of demonstration)
•	Login, Logout options
UI differences:
•	Admin Employees
o	Welcome page has all links to all the above-mentioned operations
•	Regular Employees
o	Different welcome page compared to Admin welcome page
o	Doesn’t have option to Create New Employee, Delete Employee record in the nav bar of welcome page
Validations:
•	Login Page - Valid combination of Username and Password must be provided
•	Cannot a create/update an Employee with empty/all spaces Email ID or Password
•	Cannot create post with empty/all spaces subject or content
Technical Stack:
•	Client-side: HTML, CSS, JSP
•	Server-side: Spring Boot, Hibernate 
•	Database: MySQL
•	Server: Apache Tomcat

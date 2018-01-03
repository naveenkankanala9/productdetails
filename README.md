# productdetails
Description of the product details of myRetail company

# Target Audience
• Developer/Tester


# Problem: myRetail RESTful service

myRetail is a rapidly growing company with HQ in Richmond, VA and over 200 stores across the east coast. myRetail wants to make its internal data available to any number of client devices, from myRetail.com to native mobile apps. 
The goal for this exercise is to create an end-to-end Proof-of-Concept for a products API, which will aggregate product data from multiple sources and return it as JSON to the caller. 
Your goal is to create a RESTful service that can retrieve product and price details by ID. The URL structure is up to you to define, but try to follow some sort of logical convention.
Build an application that performs the following actions: 

•	Responds to an HTTP GET request at /products/{id} and delivers product data as JSON (where {id} will be a number. 

•	Example product IDs: 15117729, 16483589, 16696652, 16752456, 15643793) 

•	Example response: {"id":13860428,"name":"The Big Lebowski (Blu-ray) (Widescreen)","current_price":{"value": 13.49,"currency_code":"USD"}}

•	Performs an HTTP GET to retrieve the product name from an external API. (For this exercise the data will come from redsky.target.com, but let’s just pretend this is an internal resource hosted by myRetail) 

•	Example: http://redsky.target.com/v2/pdp/tcin/13860428?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics

•	Reads pricing information from a NoSQL data store and combines it with the product id and name from the HTTP request into a single response. 

•	BONUS: Accepts an HTTP PUT request at the same path (/products/{id}), containing a JSON request body similar to the GET response, and updates the product’s price in the data store. 


# Solution:

Product Details is the Application which implements the solution for 

• Responds to an HTTP GET request at /products/{id} and delivers product data as JSON (where {id} will be a number

• Accepts an HTTP PUT request at the same path (/products/{id}) and updates the product’s price in the data store. 


# Technology Stack:
• Spring Boot

• Maven

• MongoDB

• JUnit/Mokito

# Tools Used
• Spring Tool Suite

• Postman

• Git

# Maven dependencies used:
spring-boot-starter-data-mongodb, 
spring-boot-starter-jta-narayan, 
spring-boot-starter-web, 
spring-boot-starter-test, 
spring-boot-starter-actuator, 
spring-boot-devtools, 
spring-data-commons, 
spring-cloud-starter-feign, 
springfox-swagger2, 
springfox-swagger-ui.

Reference: https://mvnrepository.com/


# Setup instructions:
Install Java 1.8

Install Spring Tool Suite 

Install Mongo DB

Install Maven 

Github: Download project from the following git repository https://github.com/naveenkankanala9/productdetails

Clone the git project from git-bash or command prompt (or) download the project as a zipfile

Import the project into STS:
• File->import
• Existing Maven Projects
• Open File -ProductDetailsApplication
• Run as Java application

#Access url:
http://localhost:8081/products

http://localhost:8081/swagger-ui.html



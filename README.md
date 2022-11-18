# LendoAssessment-Mohammed

This documentation will demonstrate how to run the application, and how to access the APIs.

# How to Run The Application 
There are 2 ways to run this application, either by Docker or the IDE.


## 1. Run within the IDE
To use this method make sure that you have the following:
- Java 11 has already been installed and setup
- Git has already been installed and setup
- IDE (prefered) IntelliJ ready to use

#### 1- Clone this project to your machine
Open Git-bash/terminal and run the following command to clone the project.

``` git clone https://github.com/moh-27/LendoAssessment-Mohammed.git ```

#### 2- Open the project
Opent the poject with IntalliJ and locate the LendoAssessmentApplication.class.
This class is in the following path src/main/java/com/lendo/lendoassessment/LendoAssessmentApplication.java

#### 3- Run the main class
Run the LendoAssessmentApplication.class by clicking on the green arrow and selecting run.
![image](https://user-images.githubusercontent.com/30930306/202209079-94da2950-aa04-4555-a295-936fc77ca39a.png)


## 2. Run using Docker
To use this method make sure to have Docker and Docker Compose already install on your machine.

#### 1- Download the Application last Realese 
Go to the release page and download the last version

https://github.com/moh-27/LendoAssessment-mohammed/releases/tag/Docker


#### 2- Download the docker and jar files
Download the docker and jar files and make sure they are in the same folder

#### 3- Build and Run the Docker image
Open a terminal/git-bash in this folder (or move to the downloaded folder directory).

Run the following command:

``` docker build -t lendoAssessment:1.1 . ```

``` docker run -p 127.0.0.1:8080:8080 lendoAssessment  ```


# How to Access the APIs

### PostMan - auth api
To test the API we can use postMan,

first we need to make the authentication POST request, which holds the userName (bassam) and Password (lendo) as parameters.
API POST request: http://localhost:8080/auth?userName=bassam&password=lendo
 In the return we will get the Jwt token, which needed to use the other APIs
![image](https://user-images.githubusercontent.com/30930306/202212298-7b4a13ba-4659-4bb6-afa6-e7b4e8ae75b0.png)


### PostMan - user api
After having the Jwt tocken wh have to added the token as Authorization Hedder in the following syntax:
token:{jwtToken}
![image](https://user-images.githubusercontent.com/30930306/202211586-22fdd36c-61e3-4f77-b45e-0c07e2783026.png)

### List of APIs
POST - Auth API = http://<server.address>:8080/auth?userName&password

GET - get all users =  http://<server.address>:8080/api/user/all

GET - get all posts =  http://<server.address>:8080/api/post/all

GET - get all comments =  http://<server.address>:8080/api/comment/all

GET - get all comments by post Id =  http://<server.address>:8080/api/comment/bypost/{postId}

GET - get all posts by user Id =  http://<server.address>:8080/api/post/byuser/{userId}


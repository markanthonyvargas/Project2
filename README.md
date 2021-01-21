# Social Media Website (Social Turtle)

## Project Description

The Social Turtle is a social media website where users can create posts and interact with other user's posts. Posts are able to contain images if the user wishes, and users can like posts as well. Users can customize their profile picture and other details about themselves.

## Technologies Used

* Java JDK - Version 8
* Maven
* postgreSQL
* Spring Framework (Core, Beans, Context, ORM, AOP, Web MVC)
* AWS S3
* React
* Redux with React
* Email-js
* Log4J
* JUnit
* Jest
* NodeJS

## Features

List of features ready
* Users can use the website by registering and creating an account
* Users can update their information at any time, including adding or updating their profile image
* Users can create posts with text and an image
* Users can search for other users and view their profile
* Users can view other users posts as well as "like" their posts

## Getting Started
1. Clone this repository. Use "git clone https://github.com/markanthonyvargas/Project2.git" in your terminal to clone this project to a destination on your personal machine.
2. Once this project is cloned you will need to import the BackEnd project into your IDE. In STS you will import an existing Maven project.
3. Once imported, you will have to configure your IDE so that your project uses An Apache Tomcat V9 server. Make sure this server is using port 9005.
4. The FrontEnd project must be installed using NodeJS. In Visual Studio Code, open a new terminal and make the socialturtle folder in the FrontEnd folder is the current directory.
5. Run the "npm install" command inside the terminal to install the React project.
6. Before starting your Tomcat server, edit the "log4j.properties" file found in src/main/resources so that "log4j.appender.file.File" property matches a directory on your machine.
7. This project uses system environment variables in the "applicationContext.xml" to connect to a database. These will have to be changed to match your database credentials
8. Once your Tomcat server is running, head back to Visual Studio Code and run the "npm start" command to start your React project.

## Usage

Once the project is ready and the server is running, when the React app is finished starting, the app will open inside your default web browser. If you already have users inserted inside your database you can log in with an existing user; otherwise you will have to register as a new user.

NOTE: For security purpose this project uses system enviornment variables for JDBC. You will have to enter your own credentials for your database inside the "applicationContext.xml" file found in src/main/resources inside the BackEnd project. You will also have to edit the "log4j.properties" file as described in step 6 of "Getting Started"

Feature: Login into Application

Scenario Outline: Positive test validating login
Given Initialize the borwser with chrome
And Navigate to "https://courses.rahulshettyacademy.com/" url
And Click on login link in homepage to land on secure sign in page
When User enter <username> and <password> and logs in
Then Verify that user is successfully logged in

Examples:
|username |password |
|syedriyaz0@gmail.com |123456789 |
|test99@gmail.com |123456 |
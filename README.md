# Web Automation Testing of the OrangeHRM using TestNG.
## Overview
OrangeHRM offers a comprehensive human resource management system to suit a business's HR needs. The project covers the management system in an automated way for both the admin and the employee.

### The Steps For Admin:
- Login as admin
- Go to the PIM menu and create a new employee. Save the employee's first name, last name, employee ID, username and password.
- Search by the employee ID to check if the employee is found on the dashboard
- Go to the Directory menu search by employee name and check if the employee is found and logout the session.

## Technology used:
- Selenium Webdriver
- TestNG Framework
- Java
- Gradle
- Intellij idea
- Allure Report

## To Setup The Environment: Gradle
-For the Dependencies, visit:https://mvnrepository.com/

### Dependencies are:(Based on version)
- Selenium: 
  // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
    implementation group: 'org.seleniumhq.selenium', name: 'selenium-java', version: '4.26.0

- TesNG:  // https://mvnrepository.com/artifact/org.testng/testng
    testImplementation group: 'org.testng', name: 'testng', version: '7.10.2'

- JSON Simple: // https://mvnrepository.com/artifact/com.googlecode.json-simple/json-simple
    implementation group: 'com.googlecode.json-simple', name: 'json-simple', version: '1.1.1'

- Java Faker: // https://mvnrepository.com/artifact/com.github.javafaker/javafaker
    implementation group: 'com.github.javafaker', name: 'javafaker', version: '1.0.2'

- Allure Report:  // https://mvnrepository.com/artifact/io.qameta.allure/allure-testng
    implementation group: 'io.qameta.allure', name: 'allure-testng', version: '2.29.0'
  
## To run this project:
- Clone this project
- Hit the following command into the terminal: gradle clean test
  

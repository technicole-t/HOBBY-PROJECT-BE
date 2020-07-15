Coverage: 80%

# Hobby Web Application Project

The HWA Project is the week 9 assessment for the Software Development training at QA Consultancy. The project brief was to create an OOP-based web application, with utilisation of supporting tools, methodologies, and technologies, that encapsulates all fundamental and practical modules covered during training.

Specifically, you are required to create a full-stack web application following the Enterprise Architecture Model, using:

· an application back-end developed using the language from your Programming Fundamentals module (e.g. Java)

· a managed database hosted within the Cloud Provider examined during your Cloud Fundamentals module (e.g. MySQL in GCP)

· a front-end developed using the language from your Front-End Web Technologies module (e.g. JavaScript)

### Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

To use this program you will need: 

· Java SE 8 or later 
· MySQL database, hosted on GCP.

Currently the database is locally hosted through the application via the h2-console. To change this you would change the path in the 'application properties' files within the src/main/resources folder.

· Eclipse IDE to run Spring Boot.
· Apache Maven
· VSCode for viewing front end HTML, CSS & JavaScript 

### Installing

To get a copy of this repository you will need to: 

· Use the terminal to 'cd' into the location of your choice 
· Then run the command 'git clone https://github.com/technicole-t/HOBBY-PROJECT-BE.git
· Open the IDE
· Right click in the file explorer 
· Import the project into the IDE 

### Running the tests

When you have successfully imported the project into your IDE you will be able to run the tests. 

### Unit Tests
To run the JUnit tests, right click on the src/test/java folder and select 'run as -> JUnit Test Application'.

To view the application test coverage in Spring Boot, you will need to go to the 'Help' tab -> 'Eclipse Marketplace' and search for eclemma and install.

Once this is installed you can right click on src/test/java and select 'coverage as' -> '2 JUnit Test Application'.

### Deployment
To run the project you will need to open the terminal. 

· 'cd' into the location that you cloned the repository 
· run the command 'mvm clean package' 
· 'cd' into the target folder 
· java -jar *NAME-OF-PROJECT*-jar-with-dependancies.jar


### Technologies and Supporting Technologies 
· Trello - Kanban
· MySQL - Database Language
· Spring Boot - Eclipse IDE 
· GCP - Database Host
· Maven - Dependency Management
· SonarQube - Static Analysis Tool
· Nexus - Artifact Repository
· HTML, CSS & JavaScript - Front End Languages 

### Authors
Nicole Thorley - @technicole-t

### License
This project is licensed under the MIT license - see the LICENSE.md file for details

### Acknowledgments

This project would not have been possible without the following people: 

· Software Development Learning Specialist - Jordan Harrison @JHarry444
· Software Development Learning Specialist - Piers Barber @	PCMBarber
· Software Development Learning Specialist - Chris Perrins @christophperrins


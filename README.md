# INNOSID Gamify Server Application

The main goal was to present the [INNOSID](http://sociallab.fer.hr/innosid/) project, its achievements and goals to students and other visitors of multiplier events in a fun and creative way. 


Server application makes the central part of the developed system, communicating with both the developed Unity games, as well as the developed Flutter mobile app.    


## Summary

  - [Getting Started](#getting-started)
  - [Deployment](#deployment)
  - [Built With](#built-with)
  - [Authors](#authors)
  - [Acknowledgments](#acknowledgments)

## Getting Started

These instructions will get you a copy of the project up and running on
your local machine for development and testing purposes. See deployment
for notes on how to deploy the project on a live system.

### Prerequisites

To get the application running you will need the following software installed: 
1. [Git](https://git-scm.com/)
2. [Java](https://www.java.com/en/)
3. [Maven](https://maven.apache.org/)
4. [PostgreSQL](https://www.postgresql.org/)

### Installing

Clone the Git repository on your local machine. You can do this from command line by running the following command:

    git clone https://gitlab.tel.fer.hr/sociallab/pdp-20-21-babic-podobnik/serverapp.git

Now you should have all the files you need on your local system.

Based on the desired data base configuration, feel free to adjust your `spring.jpa.hibernate.ddl-auto` property in the file `src/main/resources/application.properties`.


To run the app from the command line position yourself in the project directory and run the following:

    mvn spring-boot:run


It starts the application on http://localhost:8080.

An interactive list of all _RESTful_ routes you can try is available at http://localhost:8080/swagger-ui.html. 


You can also test the routes regularly from your local browser or any testing tool such as [Postman](https://www.postman.com/).

For further development, import the project in IDE such as [IntelliJ IDEA](https://www.jetbrains.com/idea/) or [Eclipse](https://www.eclipse.org/downloads/packages/).

## Deployment

Add additional notes about how to deploy this on a live system

## Built With

  - [Contributor Covenant](https://www.contributor-covenant.org/) - Used
    for the Code of Conduct
  - [Creative Commons](https://creativecommons.org/) - Used to choose
    the license

## Authors

  - Toni Matić
  - Fani Sentinella-Jerbić
  - Iva Zekić
  
## Acknowledgments

  - Our mentoring team for guidance

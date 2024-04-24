## --- NETOLOGY HOMEWORK ---
### SPRING BOOT, DEPLOYMENT AND INFRASTRUCTURE --> Spring Boot: Purpose, Internal Structure


#### --> Task 1 --> Conditional App


# ConditionalApp

## Description

ConditionalApp is a Spring Boot application designed to demonstrate the use of conditional configuration based on application profiles. The application dynamically selects a profile based on the `netology.profile.dev` property set in `application.properties`, allowing it to adapt to different runtime environments such as development (`dev`) or production (`prod`).

## Features

- **Dynamic Profile Selection**: The application chooses between dev and prod profiles based on a configuration property.
- **Profile-specific Behavior**: Outputs a profile-specific message to showcase the active profile.
- **Docker Support**: Containerization support with Docker for easy deployment across environments.

## Getting Started

Follow these instructions to get a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

- Java JDK 17 or higher
- Docker (for containerization)

### Building the Application

To build the application, you can use the following command in the root directory of the project:
```
./gradlew clean build
```

Or if you are using Maven:
```
./mvnw clean package
```

## Running the Application

After building the project, you can run the application locally using:
```
java -jar build/libs/ConditionalApp-0.0.1-SNAPSHOT.jar
```

## Running the Tests

Execute the following command to run the integration tests:
```
./gradlew test
```

## Docker

The Dockerfile provided in the root directory allows you to build a Docker image of the application. 
Use the following command to build the Docker image:
```
docker build -t conditionalapp .
```

## Deployment with Docker

To run the application as a Docker container, execute:
```
docker run -p 8080:8080 conditionalapp
```


## Profiles

The application supports the following profiles:

Dev Profile: Configured for development purposes with more verbose logging.
Prod Profile: Configured for production deployments with optimized performance settings.
To activate a specific profile, set the netology.profile.dev property in application.properties to true (for dev) or false (for prod).

## Authors
Emrah Hakan AGAN
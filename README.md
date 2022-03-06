#Test manager
https://test-manager-heroku.herokuapp.com

##Aims
* Create a basic test manager application
* Be able to make a local demo to the dev team
* Show the code, explain it as well as the difficulties and the choices made

##Technical stack
* Backend side: Java stack with Spring or SpringBoot. Ideally, data persistence in a light database
* Frontend side: React
* Store the code repository on git

##Specification
Create a test manager, just one page that allows to:
* Display the test names
* Create a new test
* Display the test execution status
* Change the test execution status (undefined by default that can be changed to Passed or Failed)

## Docker

### Build

Build image by Dockerfile
```bash
$ docker build -t test-manager:latest .
```

Build image by Spring Boot Maven
```bash
$ ./mvnw spring-boot:build-image
```

### Run

Run contener
```bash
$ docker run -it -p8080:8080 test-manager:latest
```

Run contener with dev profile
```bash
$ docker run -it -e "SPRING_PROFILES_ACTIVE=dev" -p8080:8080 -t test-manager:latest
```

Run contener with dev profile and debug mode
```bash
$ docker run -it -e "SPRING_PROFILES_ACTIVE=dev" -e "JAVA_TOOL_OPTIONS=-agentlib:jdwp=transport=dt_socket,address=5005,server=y,suspend=n" -p8080:8080 -p5005:5005 -t test-manager:latest
```

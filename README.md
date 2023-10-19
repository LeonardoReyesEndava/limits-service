Limits Service project will read properties using [Spring Cloud Config Server Project](https://github.com/LeonardoReyesEndava/spring-cloud-config-server.git)

If the Config Server is not running, the properties will be read from the local properties file.

## High Level Diagram
Below is a high level on how the limits-service will pull the properties.

![High Level Diagram](./docs/diagrams/LimitService.png)

### Server URL
This service will run under 8080 port: http://localhost:8080

### End Point to test the properties
The first approach to read the properties is using the endpoint http://localhost:8080/limits

### Refresh Properties
For now, the way to refresh properties at runtime, is with a POST request using http://localhost:8080/actuator/refresh

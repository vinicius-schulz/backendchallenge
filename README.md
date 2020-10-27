# backendchallenge
Trustly Technical Challenge for Developers: API that returns the total number of lines and the total number of bytes of all the files of a given public Github repository, grouped by file extension.

## Author
Vinícius Schulz - vinicius-schulz@hotmail.com

## Instalation Instructions to Execute Locally - NO DOCKER

Clone the project:
```
git clone https://github.com/vinicius-schulz/backendchallenge.git
```

Execute the follow command to clean and build the application:

```
mvn clean install 
```

Execute the follow command to run the application:

```
mvn spring-boot:run
```

## Instalation Instructions to Execute Locally - DOCKER

Run the follow command to pull backendchallenge's image from hub.docker.com to your local.

```
docker pull viniciusschulz/backendchallenge
```

Run the follow command to create and run a container.
 
```
docker run -idt -p <port>:8080 --name <container-name> viniciusschulz/backendchallenge
```

Ps: You can run only the second command. That will, pull, create and run automatically you container. Remember to choose the local port (for example: 8080) and define the container name.

## Environment

### AWS 
External URL: http://ec2-18-221-181-117.us-east-2.compute.amazonaws.com:8080/

## Documentation
Swagger: http://ec2-18-221-181-117.us-east-2.compute.amazonaws.com:8080/swagger-ui.html

### API requisition example

```
http://ec2-18-221-181-117.us-east-2.compute.amazonaws.com:8080/git-repository-information/github/vinicius-schulz/backendchallenge
```

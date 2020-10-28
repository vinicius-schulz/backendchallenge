# backendchallenge
Trustly Technical Challenge for Developers: API that returns the total number of lines and the total number of bytes of all the files of a given public Github repository, grouped by file extension.


## Initial considerations
I builded the proposed challenge in two differents ways. The first one, i build using the Jsop library to manipulate the github's html page to found out the file's links (most efficient way). The second way, i builded the solution using the Jgit library, which i cloned the repository to a local directory, and then i read the file's properties (less efficient). Both solutions solve the problem, the difference are in resource usage; i consider the second one worst than in this point, because i have a effort to clone the entire repository before begin read the file's properties.


## Author
Vinícius Schulz - vinicius-schulz@hotmail.com

## Instructions to local execution - NO DOCKER

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

## Instructions to local execution - DOCKER

Run the follow command to pull backendchallenge's image from hub.docker.com to your local.

```
docker pull viniciusschulz/backendchallenge
```

Run the follow command to create and run a container.
 
```
docker run -idt -p <port>:8080 --name <container-name> viniciusschulz/backendchallenge
```

Ps: You can run only the second command. That will, pull, create and run automatically you container in daemon mode. Remember to choose the local port (for example: 8080) and define the container name.

Run the follow command to stop your created container.

```
docker container stop <container-name>
```

Run the follow command to remove your created container.

```
docker container rm -f <container-name>
```

## Environment

### AWS 
External URL: http://ec2-18-221-181-117.us-east-2.compute.amazonaws.com:8080/

## Documentation
Swagger: http://ec2-18-221-181-117.us-east-2.compute.amazonaws.com:8080/swagger-ui.html

### API requisition example

```
http://ec2-18-221-181-117.us-east-2.compute.amazonaws.com:8080/git-repository-information/github/vinicius-schulz/backendchallenge
```

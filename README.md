# backendchallenge
Trustly Technical Challenge for Developers
API that returns the total number of lines and the total number of bytes of all the files of a given public Github repository, grouped by file extension.

## Author
Vinícius Schulz
email: vinicius-schulz@hotmail.com

## Instalation Instructions to Execute Locally - NO DOCKER

Clone the project:
```
git clone https://github.com/vinicius-schulz/backendchallenge.git
```

Execute the build using the command:
```
mvn install 
```

## Instalation Instructions to Execute Locally - DOCKER


## Environment

### AWS 
External URL: http://ec2-18-221-181-117.us-east-2.compute.amazonaws.com:8080/

## Documentation
Swagger: http://ec2-18-221-181-117.us-east-2.compute.amazonaws.com:8080/swagger-ui.html

### API requisition example

```
http://ec2-18-221-181-117.us-east-2.compute.amazonaws.com:8080/git-repository-information/github/vinicius-schulz/backendchallenge
```

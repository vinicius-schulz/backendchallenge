# Backend Challenge
Trustly Technical Challenge for Developers: API that returns the total number of lines and the total number of bytes of all the files of a given public Github repository, grouped by file extension.


## 1. Initial considerations
I builded the proposed challenge in three differents ways. The first one, i build using the Jsop library to manipulate the github's html page to found out the file's links (most efficient way). The second way, i builded the solution using the Jgit library, which i cloned the repository to a local directory, and then i read the file's properties (less efficient). 
At last, i builded using regular expression, to match file path name with my regex.
Both solutions solve the problem, the difference are in resource usage; i consider the second one worst than others in this point, because i have a effort to clone the entire repository before begin read the file's properties.


## 2. Author
Vinícius Schulz - vinicius-schulz@hotmail.com

## 3. Instructions to local execution

### 3.1. Cloning and executing from repository

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

### 3.2. Pulling and Running from a Docker Image

Run the follow command to pull backendchallenge's image from hub.docker.com to your local.

```
docker pull viniciusschulz/backendchallenge:1.0.3
```

Run the follow command to create and run a container.
 
```
docker run -idt -p <port>:80 --name <container-name> viniciusschulz/backendchallenge:1.0.3
```

Ps: You can run only the second command. That will, pull, create and run automatically the container in daemon mode. Remember to choose the local port (for example: 8080) and define the container name. Futhermore, if you want pull the latest version on hub.docker.com, just remove the version 1.0.3.

Run the follow command to stop your created container.

```
docker container stop <container-name>
```

Run the follow command to remove your created container.

```
docker container rm -f <container-name>
```

## 4. Environment

### 4.1. AWS 

#### 4.1.1 Custom DNS: http://www.viniciusschulz.com.br
#### 4.1.2 Original DNS: http://ec2-18-221-181-117.us-east-2.compute.amazonaws.com

PS: Both DNS pointed to same machine, but for convenience questions, please use the first one.

## 5. Documentation
Swagger: http://www.viniciusschulz.com.br/swagger-ui.html

### 5.1. API requisition example

#### 5.1.1. Method 1 - Using Soup
```
http://www.viniciusschulz.com.br/git-repository-information/github/jsoup/vinicius-schulz/backendchallenge
```

#### 5.1.2. Method 2 - Using Jgit
```
http://www.viniciusschulz.com.br/git-repository-information/github/jgit/vinicius-schulz/backendchallenge
```

#### 5.1.3. Method 3 - Using Regular Expression
```
http://www.viniciusschulz.com.br/git-repository-information/github/regex/vinicius-schulz/backendchallenge
```
## 6. Challenge requirements
* Your API must be written using Java 8 or newer, ECMAscript 2015 or newer, or C# 8.0;
* Data must be retrieved from Github website by using web scraping techniques. Do not use Github’s API;
* Do not use web scraping libraries. We would like to know your ideas on how it can be done;
* Your API must support thousands of concurrent requests;
* We think it’s ok if the first request to a particular repository takes some time to respond (since you depend on Github website response times), but we don’t expect the subsequent requests to be long;
* We don’t expect to get timeout errors;
* We must understand your code and use your API without having to ask you any questions. Our primary language is English so please use it on comments and documentation;
* We’d like to see SOLID principles in your solution;
* You are free to choose your API contracts (parameters and response formats) but we’d like to be able to integrate it with any other existing solutions;
* You don’t need to persist any data (but feel free to do it if you want);
* We’d like to see at least one automated test;
* You must deploy your solution to a cloud provider like Amazon AWS or Heroku and send us the link to access it. It’s a plus if you publish a Docker image with your application (including its dependencies) in a registry like Docker Hub and let us know how to get it.

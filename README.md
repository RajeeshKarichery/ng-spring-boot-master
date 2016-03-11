### Rapid prototyping with Spring Boot and AngularJS
This example demonstrates how **Spring Boot**, **Spring Data JPA** and in the front-end **AngularJS** Material Css can be used together to write web applications easily.
In this code example I'm demonstrating this by providing a full CRUD-based web application in about 150 lines of code (100 lines of Java code and 50 lines of JavaScript code).
Atmosphere Comet Server Push

## Frameworks

### Front-end

#### AngularJS Material CSS

#### AngularJS
AngularJS is a MVC based framework for web applications, written in JavaScript. It makes it possible to use the Model-View-Controller pattern on the front-end. It also comes with several additional modules. In this example I'm also using **angular-resource**, which is a simple factory-pattern based module for creating REST clients.

### Back-end

#### Spring Boot /JPA/Atmosphere

#### Spring Data JPA
Spring Data JPA allows you to create repositories for your data without even having to write a lot of code. The only code you need is a simple interface that extends from another interface and then you're done.
With Spring Boot you can even leave the configuration behind for configuring Spring Data JPA, so now it's even easier.

## Installation
Installation is quite easy, first you will have to install some front-end dependencies using Bower:
```
bower install
```

Then you can run Maven to package the application:
```
mvn clean package
```

Now you can run the Java application quite easily:
```
cd target
java -jar ng-spring-boot-1.0.0.jar

```
Broadcast Message like this way
http://localhost:8080/broadcast/{message}

Thank u 



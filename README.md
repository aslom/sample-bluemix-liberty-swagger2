

# Sample code showing how to run Swagger2 with WebSphere Liberty in Eclipse and in Bluemix

Uses instructions from https://github.com/swagger-api/swagger-core/wiki/Swagger-Core-Jersey-2.X-Project-Setup-1.5 and applies them to WebSphere Liberty and Bluemix.

## Customizing code to our service

Rename sample package com.example.sample.api and refactor HelloWorldResource class

Then edit SwaggerBootstrap to use the same base path prefix ("/v1") and set metadata such as API version, title, etc.

Finally edit /src/main/webapp/WEB-INF/web.xml to put package name and your base path prefix for APIs ("/v1")

For local testing to deploy multiple apps to one server modify context path in contextPath = '/service-name' 
(or remove that line and gradle eclipse plugin will default to context path to project name). 

## Pre-requisite

### OSX

Install brew http://brew.sh/

### Eclipse EE

Download Eclipse IDE for Java EE Developers
https://www.eclipse.org/downloads/

### WebSphere Liberty V8.5.5.5

https://developer.ibm.com/wasdev/downloads/liberty-profile-using-non-eclipse-environments/

### WebSphere Liberty in Eclipse

Download and install Eclipse plugin https://developer.ibm.com/wasdev/downloads/

### Gradle

For OSX:
```
brew install gradle
```

### Cloud Foundry Command Line (cli)

Download https://github.com/cloudfoundry/cli#downloads


## Local testing with Eclipse

Generate Eclipse project 

```
gradle eclipse
```

Import into Eclipse workspace File - Import - Existing project

Add WebSphere server to Servers and add liberty-swagger2 project to server (right click created server and Add and Remove ...)

Start server and test REST API:

http://localhost:9080/v1/hello/alek

See Swagger2 JSON:

http://localhost:9080/v1/swagger.json

There is also Swagger UI HTML:

http://localhost:9080/

## Testing with Bluemix

### Using CF command line

Build .war to deploy to Bluemix. 

```
gradle war
```

Edit ``maifest.yml`` to change YOUR_NAME to your name

```
cf api https://api.ng.bluemix.net
cf login -u YOUR_ID@us.ibm.com
cf push
```

### Using gradle

Edit your cat ~/.gradle/gradle.properties
```
cfUsername=USER_NAME@us.ibm.com
cfPassword=PASSWORD
#cfOrganization=ORG
#cfSpace=dev
```

Then run

```
gradle cfPush
```

(That automatically updates war so no need to run gradle war)


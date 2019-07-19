# Play Swagger demo
This application demonstrates implementation of Swagger with Play
framework and Scala.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites


- Java v8+

- sbt build-tool



## Build and run the project

To build and run the project: 

1. Use a command window to change into the example project directory,
   for example: `cd play-swagger-scala`

2. Build the project. Enter: `sbt run`. The project builds and starts
   the embedded HTTP server. Since this downloads libraries and
   dependencies, the amount of time required depends partly on your
   connection's speed.

3. After the message `Server started, ...` displays, enter the following
  URL in a browser: <http://localhost:9000>

## APIs Doc

##### Swagger url

http://localhost:9000/api/swagger-ui/index.html?url=/api/swagger.json


## Built With

* [Scala-2.12](https://docs.scala-lang.org/) - Language
* [Play Framework-2.7](https://www.playframework.com/documentation/2.7.x/ScalaHome)
  \- The web framework used
* [Sbt](https://www.scala-sbt.org/documentation.html) - Dependency
  Management
* [Swagger-play-2.7](https://github.com/swagger-api/swagger-play/tree/master/play-2.7/swagger-play2)
  \- Swagger library for Play Framework 
* [Swagger-ui](https://github.com/webjars/swagger-ui) - Swagger UI
  library by webjars.
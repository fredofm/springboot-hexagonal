# 👋 About

Spring-boot REST microservice based on a multi-module maven project to illustrate how to structure an hexagonal architecture project.

## ⚙️ Requirements

- JDK 10.
- Maven 3.8.4

> If you prefer to use a lower version you will have to remove usage of `var` keyword in the code).

My personal setup to build an run this project:

- WLS 2 (Win 10) running Ubuntu 20.04 LTS
- OpenJDK 64-Bit Server VM GraalVM CE 22.0.0.2

## 📘 Technologies

### Common

| Technology | Purpose |
| ---------- |----------|
|Hexagonal architecture| I tried to follow an hexagonal clean architecture when creating this simple example. You can take a look into the project modules to see how the code was divided into application, domain and infrastructure layers. You can also take a look into the interfaces I'm using as "ports" to avoid layer couplings. |
| [Domain Driven Design](https://en.wikipedia.org/wiki/Domain-driven_design) | I tried to include some DDD patterns into this very simple example, like Entity, ValueObject or RootAggregate. |
| [Lombok](https://projectlombok.org/) | Helper to create builders, setters, getters, etc|
| [MapStruct](https://mapstruct.org/) | Helper to create mappers to pass objects between the different layers |
| [Spring-boot](https://quarkus.io/) | Java framework that helps you to create a REST microservice easily . |
| [rest-assured](https://rest-assured.io/) | REST Assured is a Java DSL for simplifying testing of REST based services |

### H2 adapter

| Technology | Purpose |
| ---------- |----------|
| [H2Database](https://www.h2database.com/html/main.html) | Very fast, open source, JDBC API. Support embedded and server modes; disk-based or in-memory databases |
| [Spring Data JPA](https://spring.io/projects/spring-data-jpa) | JPA based repositories implementation |
| [Flyway](https://flywaydb.org/) | To load database migrations at application startup. |

### REST adapter

| Technology | Purpose |
| ---------- |----------|
| [springdoc-openapi-ui](https://springdoc.org/) | Helps to automate the generation of API documentation using spring boot projects. |
| [rest-assured](https://rest-assured.io/) | Testing and validating REST services |

## 🚀 How to execute the application

Go to the project root directory and execute the following command to compile, test, package and install the different artifacts in your local maven repository.

```shell
mvn clean install
```

Or use the embedded maven wrapper if you don't have a maven installation.

```shell
./mvnw clean install
```

After creating all artifacts you can run the project with the following command:

```shell
mvn spring-boot:run -pl bootloader
```

Or use the embedded maven wrapper if you don't have a maven installation.

```shell
./mvnw spring-boot:run -pl bootloader
```

You should see in the console the following log line:

```log
......
2022-12-29 16:17:44.909  INFO 21694 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8081 (http) with context path ''
2022-12-29 16:17:44.918  INFO 21694 --- [           main] c.m.p.s.c.SpringbootRestApplication      : Started SpringbootRestApplication in 4.48 seconds (JVM running for 4.915)
```

It means the application is running properly and it will provide the following endpoints:

- `http://localhost:8081/api/v1/prices`. GET http method that will receive three parameters.
- `http://localhost:8081/v3/api-docs`. OpenAPI schema auto-generated from the swagger annotation provided by the `springdoc` dependency.
- `http://localhost:8081/swagger-ui.html`. Swagger interface based on the OpenAPI auto-generated schema that helps you to test the `prices` resource endpoint.

### Possible improvements

- Include the [openapi-generator-maven-plugin](https://github.com/OpenAPITools/openapi-generator/tree/master/modules/openapi-generator-maven-plugin) to generate documentation, validations, tests, and code based a provided OpenAPI schema. [OpenAPI generator project](https://github.com/OpenAPITools/openapi-generator) | [OpenAPI](https://github.com/OAI/OpenAPI-Specification).
- Add Unit tests with [JUnit 5](https://quarkus.io/guides/getting-started-testing) and [Mockito](https://quarkus.io/blog/mocking/) frameworks. As this code is quite simple it make no sense to add unit tests, but could be interesting to illustrate the usage of those frameworks.
- Add `fail-safe` plugin to run the IT test instead of `sure-fire`.
- Create the same project with a different framework like [Quarkus](https://quarkus.io/). Quarkus is a full-stack, Kubernetes-native Java framework made for Java virtual machines (JVMs) and native compilation, optimizing Java specifically for containers and enabling it to become an effective platform for serverless, cloud, and Kubernetes environments.
- Add `javadoc` information to all methods and generate `javadoc` and `source` artifact.

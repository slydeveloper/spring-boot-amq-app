Spring Boot + ActiveMQ profile
============================================
Here is very simple example how to disable ActiveMQ in the Spring Boot application.

Code
----
```
@SpringBootApplication(
    exclude = {
		ActiveMQAutoConfiguration.class
	})
public class SpringBootAmqAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootAmqAppApplication.class, args);
	}
}
```
```
@Profile("amqEnabled")
@EnableJms
@Import(ActiveMQAutoConfiguration.class)
@Configuration
public class ActiveMQConfig {
}
```
The `ActiveMQConfig` class is being instantiated by Spring IoC only when `amqEnabled` profile is active.
In result, it activates `ActiveMQAutoConfiguration.class` auto the Active MQ auto configuration class. 

Usage
----------------------
By default, application has turned off the Active MQ.
To activate the Active MQ, just use `amqEnabled` application profile.
- `-Dspring.profiles.active=amqEnabled` in the command line
- `spring.profiles.active=amqEnabled` in the `application.properties` file
- `SPRING_PROFILES_ACTIVE=amqEnabled` in the `docker-compose.yml` file


Requirements
------------
- [Docker](https://docs.docker.com/install/)
- [Docker Compose](https://docs.docker.com/compose/install/)

Docker Compose usage:
---------------------
 - `docker_start.sh` - deploy Spring Boot application and ActiveMQ
 - `docker_stop.sh` - undeploy Spring Boot application and ActiveMQ

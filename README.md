Title: LoginApp 
------------------

Technologies Used: 
------------------
		1. Java/Java EE, 
		2. Log4J, 
		3. Spring Framework, 
		4. Spring Boot,  
		5. PostgreSql
		6. Spring Jdbc, 
		7. Spring MVC,
		8. JSP,
		9. JSTL,
		10. JQuery - Ajax
		11. Maven
		12. GitHub
		13. JUnit

Steps: 
------------------
 1. Created Project through Spring Boot on Start.io.
 2. Used GitHub SCM tool.
 3. Started adding Spring MVC in Eclipse IDE.
 4. Logged application using Log4J.
 5. Then configured Spring DataSource & JDBC Template.
 6. Written Controller, Service & Dao Layer code. I've used Postgres DB
 7. Used JUnit for writing Unit Test Cases.
 8. Used Maven for build & deployment. 
 
 # generic-rest-api
Generic Rest API with Spring Boot, JpaRepository

## Tutorial


### Introduction

In this tutorial we're going to create a generic restful api, without writing too
much back-end java code.

#### In the end of this tutorial, our controllers will look like this.

```java
@RestController
@RequestMapping("/patients")
public class PatientController extends GenericRestController<Patient> { }

```
#### and we will be written no sql or hibernate queries.
our dao classes will be like:
```java
public interface PatientDao extends BaseDao<Patient> { }
```

but our Restful services will be available.

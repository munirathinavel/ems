Title: Entity Management System 
-------------------------------

Technologies Used: 
------------------
		1. Java/Java EE, 
		2. Log4J, 
		3. Spring Framework, 
		4. Spring Boot,  
		5. PostgreSql DB,
		6. Hibernate ORM, 
		7. Spring MVC,
		9. Swagger Documentation API
		11. Maven
		12. GitHub
		13. JUnit

Steps: 
-------
 1. Created Project through Spring Boot on Start.io.
 2. Used GitHub SCM tool to create repository (ems).
 3. Imported ecm git repository in Eclipse IDE
 4. Started adding Spring MVC.
 4. Configured application log file using Log4J.
 5. Then configured DataSource, Session factory & TransactionManager for Hibernate.
 6. Written Controller & Dao Layer code. I've used Postgres DB to deal with storing the data.
 7. Used JUnit for writing Unit Test Cases.
 8. Used Maven for build & deployment. 
 
 
Model Classes: 
-------------
	Created generic base entity class BaseModel.java & then later is was extended by other entities.
	
1. BaseModel.java
2. Patient.java
3. Doctor.java (Sub Entity)
4. Product.java

 
Controller Classes: 
-------------
 	Created generic controller class GenericRestController.java & then later is was extended by other controllers.
 	
1. GenericRestController.java
2. PatientController.java
3. ProductController.java


 	
 Dao Classes: 
-------------
 	Created generic base dao class BaseDao.java & then later is was extended by other Daos.
 	
1. BaseDao.java
2. PatientDao.java
3. ProductDao.java


 	
 
Testing in JakartaEE
====================

This repository is an example of how to test a JakartaEE 10 application using JUnit5, Mockito, and cdi-test. 
It uses Gradle as the build tool.
This application was made as a tutorial, so it serves no other practical purpose.

### High level description

The application has very simple business logic for registering page visitors, with 3 types of EJBs:
- 'VisitorCountBean' is a stateless session bean with no dependencies.
- 'VisitorsBean' is a stateless session bean that depends on EntityManager for data access to the database.
- 'VisitorsEmailMessageBean' is a stateless session bean that depends on another stateless session bean.

The tests are in the `src/test/` directory. The tests are divided into 3 categories:
- 'VisitorCountBeanTest' tests 'VisitorCountBean' using a simple JUnit test.
- 'VisitorsBeanTest' tests 'VisitorsBean' using a JUnit test with cdi-test and an in-memory database.
- 'VisitorsEmailMessageBeanTest' tests 'VisitorsEmailMessageBean' using a JUnit test with cdi-test and Mockito.

The `src/test/resources/` directory contains the `META-INF/beans.xml` and the `META-INF/persistence.xml` files 
that the tests will use.

To run the tests you can use the IDE or the following command:
```
gradlew test
```

### Running the application

To run the application you can use the Glassfish server. Make sure to start the database first.
The database connection is specified in the `src/main/resources/META-INF/persistence.xml` file as `jdbc/__default` which 
is the default connection pool in Glassfish, connecting to the Derby database. To start the Derby database, use the
following command from the `/glassfish7/bin` directory:
```
asadmin start-database
```

[![Creative Commons License](https://i.creativecommons.org/l/by-nc-sa/4.0/88x31.png)][CreativeCommonsLicence]
<br />
This work is licensed under a [Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License][CreativeCommonsLicence]

[CreativeCommonsLicence]: http://creativecommons.org/licenses/by-nc-sa/4.0/

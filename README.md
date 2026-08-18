BIT2203-AdvancedProgramming-CAT
 
Student Details
- Name: Lexus Macharia Ndungu
- Registration Number: SCT221-0672/2023
 
Description of Each Program
 
1. URLParser.java - Breaks a URL into protocol, host, port, path,
   query parameters and fragment.
2. UniversityDatabase.java - JDBC program that creates a courses
   table, inserts sample data, and lists Computer Science courses.
3. ShoppingCartServlet.java - Demonstrates keeping a shopping cart
   using HttpSession so it is not lost between pages.
4. UserService.java / UserRepository.java / AppConfig.java -
   Demonstrates Dependency Injection in Spring using constructor
   injection.
5. TemperatureConverter.java / TemperatureConverterImpl.java /
   RMIServer.java / RMIClient.java - A Remote Method Invocation
   (RMI) example that converts Celsius to Fahrenheit.
6. LifecycleDemoServlet.java - Demonstrates all the Servlet
   lifecycle methods (init, doGet/doPost, destroy).
7. Book.java / BookDAO.java / BookController.java / bookList.jsp -
   A small Library Management System example built using the MVC
   pattern.
 
How to Compile and Run
 
- Plain Java files (URLParser, RMI files, StudentLogin):
  javac FileName.java
  java FileName
 
- JDBC program (UniversityDatabase.java):
  Requires the MySQL Connector/J driver on the classpath and a
  running MySQL server with the university_db database created.
 
- Servlets and JSP files:
  Require a web container such as Apache Tomcat. Place the compiled
  classes in WEB-INF/classes and the .jsp file in the web root, then
  deploy the project to Tomcat.
 
- Spring files (UserService, UserRepository, AppConfig):
  Require the Spring Framework core and context libraries on the
  classpath.
 
Dependencies (JAR files)
- mysql-connector-j (for the JDBC program)
- javax.servlet-api (for the Servlets)
- spring-core, spring-context, spring-beans (for the Spring example)
 

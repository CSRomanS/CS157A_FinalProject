-----------------------
    PROJECT OVERVIEW
-----------------------

Our application is an online platform for businesses to showcase and sell products or services. 
Features:
- Browsing products
- Adding items to cart or wishlist
- Placing orders
- Leaving reviews
- Voting on review helpfulness
- Checking past orders

-----------------
    PREREQUISITES
-----------------

- Eclipse or IntelliJ IDE
- Tomcat v9.0
- MySQL

------------------------
    SETUP & INSTALLATION
------------------------

1. Importing the Project:
   Eclipse: File > Import > Existing Projects into Workspace > select project
   IntelliJ: File > Open > select project

2. Tomcat Setup:
   Eclipse: Servers tab > New > Server > Tomcat v9.0 Server
   IntelliJ: File > Project Structure > Add New Configuration > Tomcat Server > Local

3. Add project to Tomcat.

4. Setup JDBC:
   Update jdbc.properties with URL, username, password (Database: "AEB")

5. MySQL Setup:
   Run SQL from DatabaseCreation.sql and PopulateDatabase.sql 

---------------------
    COMPILATION & RUN
---------------------

1. Compilation:
   Eclipse: Right-click project > Build Project
   IntelliJ: Build > Build Project

2. Running in Ide:
   Eclipse: Servers tab > right-click Tomcat server > Start
   IntelliJ: Top-right > Play button beside Tomcat Server

3. Running in Tomcat server:
   Put the exported CS157A_FinalProject.war into \tomcat\apache-tomcat-9.0.78\webapps
   Run startup.bat in \tomcat\apache-tomcat-9.0.78\bin

4. Access:
   Open browser > http://localhost:8080/CS157A_FinalProject/


-----------------------
    TECHNOLOGIES USED
-----------------------

Core Technologies:
- Tomcat v9.0
- JDK
- JDBC
- Java Servlet

Libraries:
- Json-simple-1.1.1.jar
- Jstl-1.2-sources.jar
- Jstl-api-1.2.jar
- Mysql-connector-j-8.1.0.jar
- standard-1.1.2.jar


----------------
    CONTRIBUTIONS
----------------

- Anh Dinh: SQL, final report, presentation ppt
- Roman Shpilberg: Database, back-end
- Yupeng Ni: Front-end, back-end


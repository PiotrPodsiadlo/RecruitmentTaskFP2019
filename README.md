In order to run application:

1. Clone repository using git clone https://github.com/PiotrPodsiadlo/RecruitmentTaskFP2019.git to chosen folder

2. Open IntelliJ Idea

3. File -> new -> Project from existing sources

4. Choose Maven project and follow the rest of instructions by clicking "next" until project is ready

In order to use Database:

To use data described in application.properties:

create schema FP_Recruitment

after running application import Dump20190811-3

Dump contains sample user and all type of available shares with specific amount and user's wallet (financial resources and user's shares available from the beginning);

In case of need to change credentials, update application.properties:

spring.jpa.hibernate.ddl-auto=create
spring.datasource.url=jdbc:mysql://localhost:3306/FP_Recruitment?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=coderslab


after running application open http://localhost:8080/

A new user can be created as well as sample user can be used by signing in (username: admin, password: admin) 
After signing in operations on shares can be performed.
Share prices are updated in 10 sec. intervals with data from http://webtask.future-processing.com:8068/stocks
every operation (buying/selling) has to be confirmed by user
In case of lack of founds shares cannot be bought 
In case of lack of shares, shares of specific type do not appear in Stocks table. 

# Online Customer Service Support .

<img
  align="right"
        width="40%"
        src="https://user-images.githubusercontent.com/101116044/229041152-8b11c323-544b-4675-85be-1f4efec72c55.jpg"
        alt=""
      />
Online Customer Service Center management system is designed to efficiently store and retrieve important information related to customers, issues, and operators. Customers can easily raise any issues they may be experiencing, and operators can provide them with solutions.

-This is a collaborative project, completed by a team of 5 backend developers.


-We have created a RESTful API for this application. This API is capable of performing all the essential CRUD operations on data related to customers, operators, and admins. This means that we can create, read, update, and delete all relevant information within the system using the API. With our API, we are able to seamlessly integrate various features and functionalities into the application, ensuring a smooth and user-friendly experience for all users.


## Tech Stack

- Java
- Hibernate
- Spring Framework
- Spring Boot
- Spring Data JPA
- Postman
- MySQL
- Maven
- Swagger UI

## Modules
- Login Module
- Admin Module
- Operator Module
- Customer Module

# ER Diagram

<img src="https://user-images.githubusercontent.com/101116044/229040119-f9c087f2-0668-4e7c-969f-f1c6b51d0be1.png" >


<h1 align = "center"> Some functionalities images </h1>
<h2 align = "center"> ** Admin Controller **</h2>


![image](https://user-images.githubusercontent.com/101116044/229352143-fb794e14-be42-4775-8558-3973d240a81d.png)


<h2 align = "center"> ** Customer Controller  **</h2>


![image](https://user-images.githubusercontent.com/101116044/229352146-b88174df-a0fe-480a-8705-949a3a59a395.png)


<h2 align = "center"> **Operator Controller **</h2>


![image](https://user-images.githubusercontent.com/101116044/229352148-80ce9ac8-5482-4269-ad8b-054736a0dd9e.png)


<h2 align = "center"> **Login Controller **</h2>


![image](https://user-images.githubusercontent.com/101116044/229352147-3d3434f5-ae78-4331-a0b6-3821d81a605f.png)




## Installation & Run

- Before running the API server, you should update the database config inside the application.properties file.
- Update the port number, username and password as per your local database configuration.

```

    spring.datasource.url=jdbc:mysql://localhost:3306/spring
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.datasource.username=root
    spring.datasource.password=root
```

## API Root Endpoint

```
https://localhost:8080/
```

```
http://localhost:8080/swagger-ui/index.html
```

## Collaborators

- [Naveen Sharma](https://github.com/naveensharma8527) (Team Lead)
- [Priyanshu](https://github.com/Siddharth263) 
- [Narendra Swami](https://github.com/NarendraKumarSwami) 
- [Gitesh Sutar](https://github.com/gitesh8) 
- [Shubham Dubey](https://github.com/)





<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false" %>

<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <title>Spittr</title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
    </head>
    <body>
        <h1>Register</h1>
        <form method="POST" th:object="${spitter}" enctype="multipart/form-data">
            First Name: <input type="text" name="firstName" /><br/>
            Last Name: <input type="text" name="lastName" /><br/>
            Username: <input type="text" name="userName" /><br/>
            Password: <input type="password" name="password" /><br/>
            Profile Picture: <input type="file"
                name="profilePicture"
                accept="image/jpeg,image/png,image/gif" /><br/>

            <input type="submit" value="Register" />
        </form>
    </body>
</html>
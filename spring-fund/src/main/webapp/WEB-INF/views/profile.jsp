<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Your Profile</h1>
UserName: <c:out value="${spitter.userName}" /><br/>
First Name: <c:out value="${spitter.firstName}" /><br/>
Last Name: <c:out value="${spitter.lastName}" />
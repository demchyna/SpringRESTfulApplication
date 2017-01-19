<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Show all Users page</title>
</head>
<body>
    <a href="<c:url value="../"/>">Home page</a> | <a href="<c:url value="addUser"/>">Add new User</a> | <a href="<c:url value="allUsers"/>">Show All Users</a>
    <br/><br/>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Login</th>
            <th>Password</th>
            <th>Create date</th>
            <th colspan="2">Edit / Delete</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.login}"/></td>
                <td><c:out value="${user.password}"/></td>
                <td><c:out value="${user.createDate}" /></td>
                <td><a href="<c:url value="editUser?id=${user.id}"/>">Edit</a></td>
                <td><a href="<c:url value="deleteUser?id=${user.id}"/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
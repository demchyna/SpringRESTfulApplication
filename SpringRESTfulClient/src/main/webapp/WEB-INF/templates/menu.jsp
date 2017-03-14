<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>

<nav id="menu">
    <hr>
    <table>
        <tr>
            <td><h3><a href="<c:url value="/home" />">Go to Home page</a></h3></td>
            <td><h3>|</h3></td>
            <td><h3><a href="<c:url value="/user/addUser" />">Add new User</a></h3></td>
            <td><h3>|</h3></td>
            <td><h3><a href="<c:url value="/blog/addPost" />">Add new Post</a></h3></td>
            <td><h3>|</h3></td>
            <td><h3><a href="<c:url value="/user/allUsers" />">Show all Users</a></h3></td>
        </tr>
    </table>
    <hr>
</nav>
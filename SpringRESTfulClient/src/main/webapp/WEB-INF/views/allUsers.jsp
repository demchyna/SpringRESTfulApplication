<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<main id="content">
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Login</th>
            <th>Password</th>
            <th>Create date</th>
            <th>Phone number</th>
            <th colspan="2">Edit / Delete</th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><a href="<c:url value="/blog/getUserPosts?id=${user.id}" />"><c:out value="${user.login}"/></a></td>
                <td><c:out value="${user.password}"/></td>
                <td><c:out value="${user.createDate}" /></td>
                <td><c:out value="${user.phone.phoneNumber}" /></td>
                <td><a href="<c:url value="editUser?id=${user.id}"/>">Edit</a></td>
                <td><a href="<c:url value="deleteUser?id=${user.id}"/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</main>
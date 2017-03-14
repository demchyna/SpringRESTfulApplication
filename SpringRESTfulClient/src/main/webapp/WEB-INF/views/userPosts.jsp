<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<main id="content">
    <h3>User login: ${user.login}</h3>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Text</th>
            <th colspan="2">Edit / Delete</th>
        </tr>
        <c:forEach items="${posts}" var="post">
            <tr>
                <td><c:out value="${post.id}"/></td>
                <td><c:out value="${post.postName}"/></td>
                <td><c:out value="${post.postText}" /></td>
                <td><a href="#<%--<c:url value="editPost?id=${post.id}"/>--%>">Edit</a></td>
                <td><a href="#<%--<c:url value="deletePost?id=${post.id}"/>--%>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</main>

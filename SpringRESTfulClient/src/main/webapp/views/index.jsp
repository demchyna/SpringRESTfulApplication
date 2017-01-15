<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Spring RESTful Client</title>
</head>
<body>
    <a href="<c:url value="../"/>">Home page</a> | <a href="<c:url value="user/addUser"/>">Add new User</a> | <a href="<c:url value="user/allUsers"/>">Show All Users</a>
    
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <div style="float: right; right: 0px;">Hello <strong>${pageContext.request.userPrincipal.name}</strong> | <a href="<c:url value="/logout" />">Logout</a></div>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <div style="float: right; right: 0px;">Hello <strong>Guest</strong> | <a href="<c:url value="/login" />">Login</a></div>
    </c:if>
    <br/><br/>

    <h2>Home page</h2>

</body>
</html>

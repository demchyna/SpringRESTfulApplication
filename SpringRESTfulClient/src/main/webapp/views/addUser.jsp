<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add new User page</title>
</head>
<body>
    <a href="<c:url value="../"/>">Home page</a> | <a href="<c:url value="addUser"/>">Add new User</a> | <a href="<c:url value="allUsers"/>">Show All Users</a>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <div style="float: right; right: 0px;">
            Hello <strong><security:authentication property="principal.username"/></strong>!
            Your role is <strong><security:authentication property="principal.authorities"/></strong> | <a href="<c:url value="/logout" />">Logout</a>
        </div>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name == null}">
        <div style="float: right; right: 0px;">Hello <strong>Guest</strong> | <a href="<c:url value="/login" />">Login</a></div>
    </c:if>

    <br/><br/>
    <sf:form modelAttribute="user" method="post">
        <table>
            <tr>
                <td><b>Login:</b></td>
                <td><sf:input path="login"/></td>
            </tr>
            <tr>
                <td><b>Password:</b></td>
                <td><sf:password path="password"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Add new User"/></td>
            </tr>
        </table>
    </sf:form>
</body>
</html>

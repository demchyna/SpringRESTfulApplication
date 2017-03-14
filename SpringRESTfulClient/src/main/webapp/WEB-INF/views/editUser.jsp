<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<main id="content">
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
                <td><b>Phone number:</b></td>
                <td><sf:input path="phone.phoneNumber" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save updated User"/></td>
            </tr>
        </table>
    </sf:form>
</main>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<main id="content">
    <sf:form modelAttribute="blog" method="post">
        <table>
            <tr>
                <td><b>Name:</b></td>
                <td><sf:input path="postName"/></td>
                <td><b>User:</b></td>
                <td>
                    <sf:select path="user.id">
                        <sf:option label="--- Select ---" value="-1"/>
                        <sf:options items="${users}" itemLabel="login" itemValue="id"/>
                    </sf:select>
                </td>
            </tr>
            <tr>
                <td><b>Text:</b></td>
                <td colspan="3"><sf:textarea path="postText"/></td>
            </tr>
            <tr>
                <td colspan="4"><input type="submit" value="Add new Post"/></td>
            </tr>
        </table>
    </sf:form>
</main>

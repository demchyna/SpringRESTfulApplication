<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page isELIgnored="false" %>

<tiles:importAttribute name="stylesheets"/>
<tiles:importAttribute name="javascripts"/>

<!DOCTYPE html>
<head>
    <title><tiles:getAsString name="title" /></title>

    <c:forEach var="css" items="${stylesheets}">
        <link rel="stylesheet" type="text/css" href="<c:url value="${css}"/>">
    </c:forEach>

</head>
<body onload="getCurrentDate();">
    <tiles:insertAttribute name="header" />
    <tiles:insertAttribute name="menu" />
    <tiles:insertAttribute name="body" />
    <tiles:insertAttribute name="footer" />

    <c:forEach var="js" items="${javascripts}">
        <script src="<c:url value="${js}"/>"></script>
    </c:forEach>

</body>
</html>
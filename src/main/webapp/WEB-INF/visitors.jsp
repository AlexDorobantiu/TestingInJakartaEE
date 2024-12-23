<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Visitors</title>
</head>
<body>
<h3>${visitorMessage}</h3>
<h4>Visitors so far:</h4>
<ol>
    <c:forEach var="visitor" items="${visitors}">
        <li>
            ${visitor.name}
        </li>
    </c:forEach>
</ol>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<h1>
    Guests
</h1>
<form method="post" action="${pageContext.request.contextPath}/Visitors">
    <label for="nameId">Your name:</label>
    <input type="text" id="nameId" name="name" placeholder="Enter your name">
    <input type="submit" value="Submit">
</form>
</body>
</html>
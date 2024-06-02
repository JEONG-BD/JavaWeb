<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Todo List</title>
</head>
<body>
    <h1>Todo List</h1>
    <ul>
        <c:forEach items="${dtoList}" var="dto">
            <li>${dto}</li>
        </c:forEach>
    </ul>

</body>
</html>
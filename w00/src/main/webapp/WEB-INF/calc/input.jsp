<%--
  Created by IntelliJ IDEA.
  User: jbd
  Date: 5/27/24
  Time: 7:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--<form action="calcResult.jsp" , method="POST">--%>
    <form action="/calc/makeResult", method="POST">
        <input type="number" name="num1">
        <input type="number" name="num2">
        <button type="submit">SEND</button>
    </form>
</body>

</html>

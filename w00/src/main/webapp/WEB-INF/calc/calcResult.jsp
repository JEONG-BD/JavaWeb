<%--
  Created by IntelliJ IDEA.
  User: jbd
  Date: 5/27/24
  Time: 7:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
      <h1>Num 1 ${param.num1}</h1>
      <h2>Num 1 ${param.num2}</h2>
      <h1>SUM ${ (Integer.parseInt(param.num1 + param.num2)) }</h1>
</body>
</html>

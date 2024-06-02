<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <form action="/todo/register" method="POST">
    <div>
      <input type="text" name="title" placeholder="Insert Ttitle">
    </div>
    <div>
      <input type="date" name="dueDate">
    </div>
    <div>
      <button type="reset">RESET</button>
      <button type="submit">REGISTER</button>
    </div>

  </form>
</body>
</html>

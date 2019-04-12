<%--
  Created by IntelliJ IDEA.
  User: Jinghan Cao
  Date: 2019/4/5
  Time: 0:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dashboard</title>
    <style>
        body{
            background: url("images/bg.jpg") no-repeat;
            height: 100%;
            width: 100%;
            background-size: 100%;
            overflow: hidden;
            color: #ffffff;
        }
        .board{
            padding: 1rem;
            margin: 0 auto;
            background-color: rgba(36,41,46,0.5);
            border-radius: 1rem;
            margin-top: 10%;
            width:20%;
            text-align: center;
        }
    </style>
</head>

<body>
    <div class="board">
        ${message}<br>
        Welcome Back, ${username}<br>
        <a href="login.jsp"><input type="submit" name="" value="logout"></a>
    </div>
</body>
</html>

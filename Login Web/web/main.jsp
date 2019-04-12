<%--
  Created by IntelliJ IDEA.
  User: Jinghan Cao
  Date: 2019/4/4
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main</title>
    <style type="text/css">
        a{
            text-decoration: none;
            color: #ffffff;
        }
        a:hover{
            font-weight: bold;
        }
        body{
            background: url("images/bg.jpg") no-repeat;
            height: 100%;
            width: 100%;
            background-size: 100%;
            overflow: hidden;
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
        #login{
            margin-right: 20%;
        }
    </style>
</head>
<body>
    <div class="board">
        <a href="${pageContext.request.contextPath}/login.jsp" id="login">Log In</a>
        <a href="${pageContext.request.contextPath}/signUp.jsp" id="signup">Sign Up</a>
    </div>
</body>
</html>
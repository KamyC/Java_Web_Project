<%--
  Created by IntelliJ IDEA.
  User: Jinghan Cao
  Date: 2019/4/4
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
    <style>
        body{
            background: url("images/bg.jpg") no-repeat;
            height: 100%;
            width: 100%;
            background-size: 100%;
            overflow: hidden;
        }
        form{
            padding: 2rem;
            background-color: rgba(36,41,46,0.5);
            margin: 0 auto;
            border-radius: 1rem;
            margin-top: 10%;
            width:23%;
            line-height: 1rem;
        }
        td,th{
            color: #ffffff;
        }
        #submit{
            border-radius: 4px;
            border: none;
            font-size: 1rem;
        }
        tr{
            line-height: 2rem;
        }
    </style>

</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/loginServe" id="form">
        <span style="color: red;text-align: center">${message}</span>
        <span style="color: cornflowerblue;text-align: center">${signup_success}</span>
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <th colspan="2"><input type="submit" value="login" id="submit"></th>
            </tr>
            <tr>
                <td colspan="2">Don't have an accoun, <a href="${pageContext.request.contextPath}/signUp.jsp">Sign Up</a></td>
            </tr>
        </table>
    </form>
</body>
</html>

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
    <title>signUp</title>
    <style>
        body{
            background: url("images/bg.jpg") no-repeat;
            height: 100%;
            width: 100%;
            background-size: 100%;
            overflow: hidden;
        }
        table{
            padding: 2rem;
            background-color: rgba(36,41,46,0.5);
            margin: 0 auto;
            border-radius: 1rem;
            margin-top: 10%;
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
        span{
            color: red;
            font-size: 15px;
            margin-left: 1rem;
        }
    </style>
</head>
<body>
    <form method="post" action="${pageContext.request.contextPath}/signUpServe" id="form">
        <table>
            <tr>
                <td>Username:</td>
                <td><input type="text" name="username" value="${fv.username}">
                    <span>${fv.error["username"]}</span>
                    <span>${message}</span>
                </td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="text" name="password" value="${fv.password}"><span>${fv.error["password"]}</span> </td>
            </tr>
            <tr>
                <td>Conform Password:</td>
                <td><input type="text" name="confirm" value="${fv.confirm}"><span>${fv.error["confirm"]}</span></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><input type="text" name="email" value="${fv.email}"><span>${fv.error["email"]}</span> </td>
            </tr>
            <tr>
                <th colspan="2"><input type="submit" value="submit" id="submit"></th>
            </tr>
            <tr>
                <th colspan="2">Already have an account? <a href="login.jsp">sign in</a></th>
            </tr>
        </table>

    </form>
</body>
</html>

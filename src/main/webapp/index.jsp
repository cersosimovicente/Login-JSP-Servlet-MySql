<%-- 
    Document   : index
    Created on : 27 jun 2024, 09:12:15
    Author     : cerso
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="LoginServlet" method="post">
            <input type="hidden" name="option" value="login">
            <table border="1">
                <tbody>
                    <tr>
                        <td>Name User: <input type="text" name="username"></td>
                    </tr>
                    <tr>
                        <td>Password: <input type="password" name="password"></td>
                    </tr>
                    <tr>
                        <td>
                            <input type="submit" value="Login">
                            <a href="./views/CreateUser"><input type="button" value="New User"></a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>

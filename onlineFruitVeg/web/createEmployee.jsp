<%-- 
    Document   : createEmployee
    Created on : 20-Nov-2014, 12:11:20
    Author     : dex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creating a new employee entry</title>
    </head>
    <body>
        <h1>now in create new employee</h1>
        <table>
            <tr><td>ID Number:</td><td><input type="number" id="PK_ID" name="PK_ID"/></td></tr>
            <tr><td>First Name:</td><td><input type="text" id="FName" name="FName"/></td></tr>
            <tr><td>Surname:</td><td><input type="text" id="SName" name="SName"/></td></tr>
            <tr><td>Password:</td><td><input type="password" id="UserPassword" name="UserPassword"/></td></tr>
            <tr><td>Contact Number:</td><td><input type="number" id="ContactNum" name="ContactNum"/></td></tr>
            <tr><td>Role in Company:</td><td><input type="text" id="RoleInCompany" name="RoleInCompany"/></td></tr>
            <tr><td>Salary:</td><td><input type="number" id="Salary" name="Salary"/></td></tr>
        </table>
        <input type="submit" id="createEmployee" value="Add new employee"/>
        <a href="index.jsp"> go back</a>
    </body>
</html>
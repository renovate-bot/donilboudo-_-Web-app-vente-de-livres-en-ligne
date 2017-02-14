<%--
  Created by IntelliJ IDEA.
  User: fabrice
  Date: 2017-02-10
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New book</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/addBook">
    <table>
        <tr>
            <td><label>ISBN</label></td>
            <td><input type="text" name="isbn"></td>
        </tr>
        <tr>
            <td>Title</td>
            <td><input type="text" name="title"></td>
        </tr>
        <tr>
            <td>Author</td>
            <td><input type="text" name="author"></td>
        </tr>
        <tr>
            <td>Editor</td>
            <td><input type="text" name="editor"></td>
        </tr>
        <tr>
            <td>Release date</td>
            <td><input type="date" name="date"></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="number" name="price"></td>
        </tr>
        <tr>
            <td>Resume</td>
            <td><input type="text" name="details"></td>
        </tr>
        <tr>
            <td>Cover image</td>
            <td><input type="image" name="cover_img"></td>
        </tr>
        <tr>
            <td></td>
            <td><button type="submit">Submit</button></td>
        </tr>
    </table>
</form>
</body>
</html>

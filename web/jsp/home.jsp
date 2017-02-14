<%--
  Created by IntelliJ IDEA.
  User: fabrice
  Date: 2017-02-08
  Time: 12:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Librairie en ligne</title>
</head>
<body>
<div align="right" style="margin-right: 20px; margin-top: 10px;">
    <button type="submit" class="btn btn-default" onclick="openShoppingCart()">Panier <span class="badge">${shoppingCartItems}</span></button>
</div>
<br><br>

<h1 align="center">Librairie en ligne</h1>
<br>
<div style="margin-left: 20px; margin-right: 20px;">
    <table>
        <c:forEach items="${books}" var="book">
            <td>
                <table cellpadding="0" cellspacing="0" border="0">
                    <tbody>
                    <tr>
                        <td>
                            <a href="/bookDetails/${book.id}"><img src="<c:url value='/images/${book.coverImage}.jpg'/>" width="207" height="340" alt="" style="visibility: visible;"></a>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div style="width: 207px;">
                                <h2 style="font-size: 15px;" align="center"><a href="/bookDetails/${book.id}">${book.title}</a></h2>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div>
                                <h4 align="center" style="color: red">${book.price}$</h4>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </td>
            <td></td>
            <td></td>
            <td></td>
        </c:forEach>
    </table>
</div>

<script type="text/javascript">
    function openShoppingCart()
    {
        window.location.href = '/shoppingCart';
    }
</script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>

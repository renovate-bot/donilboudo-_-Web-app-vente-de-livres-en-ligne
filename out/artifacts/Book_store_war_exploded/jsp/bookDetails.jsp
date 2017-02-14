<%--
  Created by IntelliJ IDEA.
  User: fabrice
  Date: 2017-02-10
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Detail du livre</title>
</head>
<body>
<div align="right" style="margin-right: 20px; margin-top: 10px;">
    <button type="submit" class="btn btn-default" onclick="openShoppingCart()">Panier <span class="badge">${shoppingCartItems}</span></button>
</div>
<br><br>

<h2 align="center">Page de detail du livre</h2>
<div align="center">
    <form action="${pageContext.request.contextPath}/addShoppingCartItem/${book.id}">
        <table style="margin-left: 50px;">
            <tr>
                <td>
                    <table cellpadding="0" cellspacing="0" border="0" class="pMiniProduct">
                        <tbody>
                        <tr>
                            <td>
                                <img src="<c:url value='/images/${book.coverImage}.jpg'/>" width="207" height="340" alt="" style="visibility: visible;">
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </td>
                <td>
                    <table style="margin-right: 120px; margin-left: 20px;">
                        <tr>
                            <td><b>ISBN:</b> </td>
                            <td>${book.ISBN}</td>
                        </tr>
                        <tr>
                            <td><b>Titre:</b> </td>
                            <td>${book.title}</td>
                        </tr>
                        <tr>
                            <td><b>Auteur:</b> </td>
                            <td>${book.author}</td>
                        </tr>
                        <tr>
                            <td><b>Editeur:</b> </td>
                            <td>${book.editor}</td>
                        </tr>
                        <tr>
                            <td><b>Prix:</b> </td>
                            <td style="color: red">${book.price}$</td>
                        </tr>
                        <tr>
                            <td><b>Résumé:</b> </td>
                            <td style="text-align: justify">${book.details}</td>
                        </tr>
                        <tr></tr>
                        <tr></tr>
                        <tr>
                            <td><button type="submit" class="btn btn-primary" onclick="addItemAlert()">Ajouter au panier</button></td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>
    </form>
</div>


<script type="text/javascript">
    function addItemAlert()
    {
        alert("Votre produit est dans le panier!")
    }

    function openShoppingCart() {
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

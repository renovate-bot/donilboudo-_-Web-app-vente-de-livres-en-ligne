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
    <title>Panier</title>
</head>
<body>
<h1 align="center">Votre panier</h1>
<br><br>
<div panel panel-default style="margin-left: 20px; margin-right: 20px;">
    <table class="table">
        <tr>
            <td><b>#</b></td>
            <td><b>Titre</b></td>
            <td><b>Auteur</b></td>
            <td><b>Prix</b></td>
            <td><b>Quantite</b></td>
        </tr>
        <% int counter = 1; %>
        <c:forEach items="${items}" var="item">
            <tr>
                <td><%= counter %></td>
                <td>${item.book.title}</td>
                <td>${item.book.author}</td>
                <td>${item.book.price}$</td>
                <td><input type="number" id="cbQuantity-${item.id}" value="${item.quantity}" min="1"/></td>
                <td><button onclick="updateShoppingCartItemQuantity(${item.id})">Actualiser</button></td>
                <td><button class="btn btn-primary" onclick="deleteShoppingCartItem(${item.id})">Supprimer</button></td>
            </tr>
            <% counter = counter + 1; %>
        </c:forEach>
    </table>
</div>
<div>
    <h4 align="right" style="color: red; margin-right: 40px;">Prix total: ${totalCost}$</h4>
</div>
<br><br>

<div>
    <!-- BEGIN # BOOTSNIP INFO -->
    <div class="container">
        <div class="row">
            <p class="text-center"><a href="#" class="btn btn-primary btn-lg" role="button" data-toggle="modal" data-target="#login-modal">Effectuer le paiement</a></p>
        </div>
    </div>
    <!-- END # BOOTSNIP INFO -->

    <!-- BEGIN # MODAL LOGIN -->
    <div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header" align="center">
                    <img class="img-circle" id="img_logo" src="http://bootsnipp.com/img/logo.jpg">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                    </button>
                </div>

                <!-- Begin # DIV Form -->
                <div id="div-forms">

                    <!-- Begin # Login Form -->
                    <form id="login-form">
                        <div class="modal-body">
                            <div id="div-login-msg">
                                <%--<div id="icon-login-msg" class="glyphicon glyphicon-chevron-right"></div>--%>
                                <span id="text-login-msg">Entrer votre non d'utilisateur et mot de passe.</span>
                            </div>
                            <input id="login_username" class="form-control" type="text" placeholder="nom d'utilisateur" required>
                            <input id="login_password" class="form-control" type="password" placeholder="mot de passe" required>
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox"> Se souvenir de moi
                                </label>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <div>
                                <button type="submit" class="btn btn-primary btn-lg btn-block">Connexion</button>
                            </div>
                            <div>
                                <button id="login_lost_btn" type="button" class="btn btn-link">Mot de passe perdue?</button>
                                <button id="login_register_btn" type="button" class="btn btn-link">Inscription</button>
                            </div>
                        </div>
                    </form>
                    <!-- End # Login Form -->
                </div>
                <!-- End # DIV Form -->

            </div>
        </div>
    </div>
    <!-- END # MODAL LOGIN -->
</div>

<script type="text/javascript">
    function deleteShoppingCartItem(id)
    {
        window.location.href = '/deleteShoppingCartItem/' + id;
    }

    function updateShoppingCartItemQuantity(id) {
        var newQuantity = document.getElementById("cbQuantity-" + id).value;
        window.location.href = '/updateQuantity/' + id + '/' + newQuantity;
    }

    var $formLogin = $('#login-form');
    var $formLost = $('#lost-form');
    var $formRegister = $('#register-form');
    var $divForms = $('#div-forms');
    var $modalAnimateTime = 300;
    var $msgAnimateTime = 150;
    var $msgShowTime = 2000;

    $("form").submit(function () {
        switch(this.id) {
            case "login-form":
                var $lg_username=$('#login_username').val();
                var $lg_password=$('#login_password').val();
                if ($lg_username == "ERROR") {
                    msgChange($('#div-login-msg'), $('#icon-login-msg'), $('#text-login-msg'), "error", "glyphicon-remove", "Login error");
                } else {
                    msgChange($('#div-login-msg'), $('#icon-login-msg'), $('#text-login-msg'), "success", "glyphicon-ok", "Login OK");
                }
                return false;
                break;
            case "lost-form":
                var $ls_email=$('#lost_email').val();
                if ($ls_email == "ERROR") {
                    msgChange($('#div-lost-msg'), $('#icon-lost-msg'), $('#text-lost-msg'), "error", "glyphicon-remove", "Send error");
                } else {
                    msgChange($('#div-lost-msg'), $('#icon-lost-msg'), $('#text-lost-msg'), "success", "glyphicon-ok", "Send OK");
                }
                return false;
                break;
            case "register-form":
                var $rg_username=$('#register_username').val();
                var $rg_email=$('#register_email').val();
                var $rg_password=$('#register_password').val();
                if ($rg_username == "ERROR") {
                    msgChange($('#div-register-msg'), $('#icon-register-msg'), $('#text-register-msg'), "error", "glyphicon-remove", "Register error");
                } else {
                    msgChange($('#div-register-msg'), $('#icon-register-msg'), $('#text-register-msg'), "success", "glyphicon-ok", "Register OK");
                }
                return false;
                break;
            default:
                return false;
        }
        return false;
    });

    $('#login_register_btn').click( function () { modalAnimate($formLogin, $formRegister) });
    $('#register_login_btn').click( function () { modalAnimate($formRegister, $formLogin); });
    $('#login_lost_btn').click( function () { modalAnimate($formLogin, $formLost); });
    $('#lost_login_btn').click( function () { modalAnimate($formLost, $formLogin); });
    $('#lost_register_btn').click( function () { modalAnimate($formLost, $formRegister); });
    $('#register_lost_btn').click( function () { modalAnimate($formRegister, $formLost); });

    function modalAnimate ($oldForm, $newForm) {
        var $oldH = $oldForm.height();
        var $newH = $newForm.height();
        $divForms.css("height",$oldH);
        $oldForm.fadeToggle($modalAnimateTime, function(){
            $divForms.animate({height: $newH}, $modalAnimateTime, function(){
                $newForm.fadeToggle($modalAnimateTime);
            });
        });
    }

    function msgFade ($msgId, $msgText) {
        $msgId.fadeOut($msgAnimateTime, function() {
            $(this).text($msgText).fadeIn($msgAnimateTime);
        });
    }

    function msgChange($divTag, $iconTag, $textTag, $divClass, $iconClass, $msgText) {
        var $msgOld = $divTag.text();
        msgFade($textTag, $msgText);
        $divTag.addClass($divClass);
        $iconTag.removeClass("glyphicon-chevron-right");
        $iconTag.addClass($iconClass + " " + $divClass);
        setTimeout(function() {
            msgFade($textTag, $msgOld);
            $divTag.removeClass($divClass);
            $iconTag.addClass("glyphicon-chevron-right");
            $iconTag.removeClass($iconClass + " " + $divClass);
        }, $msgShowTime);
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

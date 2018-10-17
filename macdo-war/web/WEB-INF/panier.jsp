
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="panier">
    <h5 id="titlePAnier">Panier</h5>
    <div id="liste">
        <c:forEach var="p" items="${gestionPanier.panier}" varStatus="status">
            <a idIndex="${status.index}" onclick="goPlus(this); return false;" href="">
                <img src="./Images/bouton/plus-square.svg"/></a>
            ${p.quantite} X ${p.produit.nom} ${p.prix} <br>
            prix : <fmt:formatNumber value="${p.prix + p.prix * p.tvaTaux}" maxFractionDigits="2"/> € ttc
            <a idIndex="${status.index}" onclick="goMoins(this); return false;" href="">
                <img src="./Images/bouton/minus-square.svg"/></a>
            <br>
        </c:forEach>
    </div>
    <div id="total">Total<span id="prixttc">${prixTtc} €</span></div>
    <div id="valider"><a href="controler?section=Panier&valider">valider le panier</a></div>
</div>   





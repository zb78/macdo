<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<ul class="nav flex-column">
    <li class="nav-item">

        <c:url value="controler?section=CreationDonnees" var="creaDonnees" />
        <a class="nav-link active" href="${creaDonnees}">Créer les données</a>

    </li>
    <li class="nav-item">
        
        <a class="nav-link" href="#"><image src ="WEB-INF\Images_Projet_Team2\Images_Projet_Team2\vignetteType\menu.png" alt=" Nos menus"/></a>
    </li>
    <li class="nav-item">
        <a class="nav-link" href="#">Link</a>
    </li>
    <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
    </li>
</ul>

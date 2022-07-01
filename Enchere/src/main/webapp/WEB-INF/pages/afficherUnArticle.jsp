<%--
  Created by IntelliJ IDEA.
  User: bmetro2022
  Date: 29/06/2022
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"/>
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet"/>
    <!-- CSS ONLY -->

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.2.0/mdb.min.css" rel="stylesheet"/>

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/accueil.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    <title>Article</title>

</head>
<body>
<div class="container">
    <h1>Détail vente</h1>
    <div class="row align-center">
        <div>${article.nomArticle}</div>
        <div>Description : ${article.description}</div>
        <div>Catégorie : ${article.libelle}</div>
        <div>Mise à prix : ${article.prixInitial}</div>
        <div>Fin de l'enchère : ${article.finEncheres}</div>
        <div>Retrait : ${article.rue}</div>
        <div>${article.codePostale}</div>
        <div>${article.ville}</div>
        <div>Vendeur : ${article.noUtilisateur}</div>

        <div>
            <form action="" method="post">
                <label for="proposition">Ma proposition</label>
                <input id="proposition" type="number" min="${article.prixInitial}">
                <input type="submit" value="Enchérir">
            </form>
        </div>
    </div>
</div>
</body>
</html>

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
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    <link rel="stylesheet" href="css/article.css">
    <title>Article</title>

</head>
<body>
<header>
    <a href="acceuil">
        <img alt="logo" src="./img/logo_redimenssionner-removebg.png">
    </a>
    <div>
        <a href="acceuil"><button class="btn-perso btn-white btn-bottom-animation-1 nostyle-btn">Retour</button></a>
    </div>

</header>
<main>
    <div class="container">

        <div class="row">
            <div class="align-center mt-5">
                <h1 >Détail vente</h1>
                <div>
                    <p>${article.nomArticle}</p>
                </div>
                <div>
                    <p>Description : ${article.description}</p>
                </div>
                <div>
                    <p>Catégorie : ${article.libelle}</p>
                </div>
                <div>
                    <p>Mise à prix : ${article.prixInitial} points</p>
                </div>


                    <c:if test="${article.noArticle}=${encheres.noArticle}">
                        <div>
                            <p>Meilleur offre : ${encheres.montantEnchere}</p>
                        </div>
                    </c:if>


                <div>
                    <p>Fin de l'enchère : ${article.finEncheres}</p>
                </div>
                <!----------tableau retrait---------->
                <fieldset class="fieldset">
                    <legend class="legend">Retour</legend>
                    <p>Rue : ${article.rue}</p>
                    <p>Ville : ${article.ville}</p>
                    <p>Code Postal : ${article.codePostale}</p>
                </fieldset>

                <div>
                    <p>Vendeur : ${article.pseudo}</p>
                </div>
                <!----------formulaire---------->
                <div>
                    <form action="afficherUnArticle" method="post">
                        <label for="proposition">Ma proposition :
                            <input id="proposition" type="number" name="proposition" min="${article.prixInitial}" placeholder="Quel est le montant de votre enchère ?" required>
                        </label>
                        <input type="hidden" id="noUtilisateur" name="noUtilisateur" value="${article.noUtilisateur}">
                        <input type="hidden" id="noArticle" name="noArticle" value="${article.noArticle}">
                        <button type="submit" class="btn-perso btn-white btn-bottom-animation-1 nostyle-btn">Enchérir</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>
</body>
</html>
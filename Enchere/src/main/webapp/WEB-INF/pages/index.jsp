<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="fr">
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
    <link rel="stylesheet" href="css/index.css">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    <title>Accueil</title>
</head>
<body>
<header>
    <a href="acceuil">
        <img alt="logo" src="./img/logo_redimenssionner-removebg.png"  class="logo">
    </a>
    <div id="recherche">
        <label for="searchbar"></label>
        <input id="searchbar" onkeyup="search()" type="text" name="search" placeholder="Recherchez un article ici..">
    </div>
    <div>
        <div id="compte">
            ${compte}
        </div>
        <div id="deco">
            ${deco}
        </div>
    </div>
    <div>
        <div id="vendre">
            <a href="vendreUnArticle" ${detail}>Vendre un article</a>
        </div>
        <div id="co">
            ${connexion}
        </div>
    </div>
</header>
<main>
    <div class="container">
        <div class="row">
            <div class="align-center mt-5">
                <h1 class="h1titre">Accueil</h1>

                <div class="container">
                    <div class="row">

                        <c:forEach var="enchere" items="${enchere}">
                            <div class="col-2 card enchere">
                                <div class="card-body">
                                    <div class="card-title">
                                        <p>${enchere.nomArticle}</p>
                                    </div>
                                    <div class="card-subtitle mb-2 text-muted">
                                        <p>Prix : ${enchere.montantEnchere} points</p>
                                    </div>
                                    <div class="card-text">
                                        <p>Date de fin de l'enchère ${enchere.dateEnchere}</p>
                                    </div>
                                    <div class="card-text">
                                        <p>Vendeur : ${enchere.nomUtilisateur}</p>
                                    </div>
                                    <div class="card-text">
                                        <p>Numéro enchère : ${enchere.noEnchere}</p>
                                    </div>
                                    <div class="card-text">
                                        <a href="afficherUnArticle?noArticle=${enchere.noArticle}" ${detail}> Afficher le détail de l'article</a>
                                    </div>
                                </div>


                            </div>
                        </c:forEach>

                    </div>
                </div>

            </div>

        </div>
    </div>
</main>

<script src="javascript/recherche.js"></script>
</body>
</html>
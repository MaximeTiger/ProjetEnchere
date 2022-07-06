
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="fr">
<head>
    <title>Vendre un article</title>
</head>
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


<link rel="stylesheet" href="css/vendreArticle.css">
<link rel="stylesheet" href="css/header.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />

<body>
<!---------------------------------------------HEADER avec le logo ENI------------------------------------------------>
<header>
    <a href="acceuil">
        <img alt="logo" src="./img/logo_redimenssionner-removebg.png" class="logo">
    </a>
</header>

<!-------------------------------------------------------MAIN--------------------------------------------------------->
<main>
    <div>
        <!--------------------------------------EnTete du Main avec bouton retour et titre------------------------------------>
        <div>
            <div>
                <a href="acceuil"><button class="btn-perso btn-white btn-bottom-animation-1 nostyle-btn retour">Retour</button></a>
            </div>
            <div>
                <h1 class="h1titre">Nouvelle vente</h1>
            </div>
        </div>

        <!------------------------------------Formulaire première partie description article---------------------------------->

        <div class="container">
            <form action="vendreUnArticle" method="post" class="form formulaire">
                <div >
                    <div>
                        <div>
                            <label for="idNom" >Article :
                                <input type="text" name="nomArticle" id="idNom" placeholder="Exemple : Fauteuil " class="right" required>
                            </label>
                        </div>
                        <div >
                            <label for="idDescription" id="labelDescription">Description :
                                <input type="textarea" name="description" id="idDescription" placeholder="Exemple : Fauteuil en cuir" class="right" required>
                            </label>
                        </div>
                        <div>
                            <label for="idCategorie" >Categorie
                                <select name="categorie" id="idCategorie" class="select" required>
                                    <option value="">-- Choisir une catégorie --</option>
                                    <c:forEach var="labelle" items="${labelle}">
                                        <option value="${labelle}">${labelle}</option>
                                    </c:forEach>
                                </select>
                            </label>
                        </div>
                        <div>
                            <label for="idMiseAPrix">Mise à prix :
                                <input type="number" name="miseAPrix" id="idMiseAPrix" min="0.00" class="right" required>
                            </label>
                        </div>
                        <div>
                            <label for="idDebutEnchere">Début de l'enchère :
                                <input type="date" name="debutEnchere" id="idDebutEnchere" value ="2018-08-05" min="2018-08-05" class="right" required>
                            </label>
                        </div>
                        <div>
                            <label for="idFinEnchere">Fin de l'enchère :
                                <input type="date" name="finEnchere" id="idFinEnchere" value ="2018-08-06" min="2018-08-06" class="right" required>
                            </label>
                        </div>
                    </div>
                    <!---------------------------------------Formulaire deuxième partie retrait------------------------------------------->
                    <fieldset class="fieldset">
                        <legend class="legend">Retrait</legend>
                        <div class="alignement-div">
                            <label for="idRue">Rue :
                                <input type="text" name="rue" id="idRue" value="${SessionUtilisateur.rue}" class="rightRetrait" required>
                            </label>
                        </div>
                        <div class="alignement-div">
                            <label for="idCodePostal">Code postal :
                                <input type="text" name="codePostal" id="idCodePostal" pattern =[0-9]{5} value="${SessionUtilisateur.codePostal}" class="rightRetrait" required>
                            </label>
                        </div>
                        <div class="alignement-div">
                            <label for="idVille">Ville :
                                <input type="text" name="ville" id="idVille" value="${SessionUtilisateur.ville}" class="rightRetrait" required>
                            </label>
                        </div>
                    </fieldset>
                    <div>
                        <p class="error">${error}</p>
                    </div>
                </div>
                <!----------------------------------------Formulaire troisième partie boutons----------------------------------------->
                <div class="button">
                    <div class="registrerbtn">
                        <button type="submit" class="btn-perso btn-white btn-bottom-animation-1 nostyle-btn">Enregistrer</button>
                    </div>
                    <div class="resetbtn">
                        <button type="reset" class="btn-perso btn-white btn-bottom-animation-1 nostyle-btn">Annuler</button>
                    </div>
                </div>

            </form>
        </div>
    </div>
</main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
<script src="https://unpkg.com/feather-icons"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.2.0/mdb.min.js"></script>
<script>
    feather.replace();
</script>

</body>
</html>



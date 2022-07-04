
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

    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/article.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />

<body>
<!---------------------------------------------HEADER avec le logo ENI------------------------------------------------>
    <header>
        <div>
            <a href="accueil">ENI-Enchères</a>
        </div>
    </header>

<!-------------------------------------------------------MAIN--------------------------------------------------------->
    <main>
        <div>
<!--------------------------------------EnTete du Main avec bouton retour et titre------------------------------------>
            <div>
                <div>
                    <a href="acceuil"><button class="btn-perso btn-white btn-bottom-animation-1 nostyle-btn">Retour</button></a>
                </div>
                <div>
                    <h1 class="h1titre">Nouvelle vente</h1>
                </div>
            </div>

<!------------------------------------Formulaire première partie description article---------------------------------->

            <div class="form">
                <form action="vendreUnArticle" method="post" class="form formulaire">
                    <div >
                        <div>
                            <div>
                                <label for="idNom">Article :
                                    <input type="text" name="nom" id="idNom" placeholder="Exemple : Fauteuil " required>
                                </label>
                            </div>
                            <div>
                                <label for="idDescription">Description :
                                    <input type="textarea" name="description" id="idDescription" placeholder="Exemple : Fauteuil en cuir" required>
                                </label>
                            </div>
                            <div>
                                <label for="idCategorie">Categorie </label>
                                <select name="categorie" id="idCategorie" required>
                                    <option value="">-- Choisir une catégorie --</option>
                                    <option value="0">Informatique</option>
                                    <option value="1" SELECTED>Ameublement</option>
                                    <option value="2">Vêtement</option>
                                    <option value="3">Sport & Loisirs</option>
                                </select>
                            </div>
                            <div>
                                <label for="idMiseAPrix">Mise à prix :
                                    <input type="number" name="miseAPrix" id="idMiseAPrix" min="0.00" required>
                                </label>
                            </div>
                            <div>
                                <label for="idDebutEnchere">Début de l'enchère :
                                    <input type="date" name="debutEnchere" id="idDebutEnchere" value ="2018-08-05" min="2018-08-05" required>
                                </label>
                            </div>
                            <div>
                                <label for="idFinEnchere">Fin de l'enchère :
                                    <input type="date" name="finEnchere" id="idFinEnchere" min="2018-08-05" required>
                                </label>
                            </div>
                        </div>
<!---------------------------------------Formulaire deuxième partie retrait-------------------------------------------!>
                        <div>
                            <div>
                                <label for="idRue">Rue :
                                    <input type="text" name="rue" id="idRue" value="${SessionUtilisateur.rue}"required>
                                </label>
                            </div>
                            <div>
                                <label for="idCodePostal">Code postal :
                                    <input type="text" name="codePostal" id="idCodePostal" pattern =[0-9]{5} value="${SessionUtilisateur.codePostal}" required>
                                </label>
                            </div>
                            <div>
                                <label for="idVille">Ville :
                                    <input type="text" name="ville" id="idVille" value="${SessionUtilisateur.ville}" required>
                                </label>
                            </div>
                        </div>
                        <div>
                            <p class="error">${error}</p>
                        </div>
                    </div>
<!----------------------------------------Formulaire troisième partie boutons-----------------------------------------!>
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

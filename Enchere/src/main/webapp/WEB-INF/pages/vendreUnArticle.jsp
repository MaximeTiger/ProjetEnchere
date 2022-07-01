
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
    <link rel="stylesheet" href="css/accueil.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />

<body>
<!---------------------------------------------HEADER avec le logo ENI------------------------------------------------!>
    <header>

    <a href="accueil">ENI-Enchères</a>

    </header>

<!-------------------------------------------------------MAIN---------------------------------------------------------!>
    <main>

<!--------------------------------------EnTete du Main avec bouton retour et titre------------------------------------!>
        <div>
            <div>
                <a href="acceuil"><button>Retour</button></a>
            </div>
            <div>
                <h1>Nouvelle vente</h1>
            </div>
        </div>

<!-----------------------------------------------------Formulaire-----------------------------------------------------!>

        <div>
            <form action="vendreUnArticle" method="post">
                <div>
                    <label for="idNom">
                        <input type="text" name="nom" id="idNom" placeholder="Exemple : Fauteuil "required>
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
                        <input type="number" name="miseAPrix" id="idMiseAPrix" required>
                    </label>
                </div>
                <div>
                    <label for="idDebutEnchere">Début de l'enchère :
                        <input type="date" name="debutEnchere" id="idDebutEnchere" min="2018-08-"required>
                    </label>
                </div>
                <div>
                    <label for="idFinEnchere">Fin de l'enchère :
                        <input type="date" name="finEnchere" id="idFinEnchere" required>
                    </label>
                </div>
            </div>

                                <!-------formulaire retrait--------!>
            <label for="idRue">Rue : </label>
            <input type="text" name="rue" id="idRue" value="${utilisateur.rue}"required>

            <label for="idCodePostal">Code postal : </label>
            <input type="text" name="codePostal" id="idCodePostal" value="${utilisateur.codePostal}" required>

            <label for="idVille">Ville : </label>
            <input type="text" name="ville" id="idVille" value="${utilisateur.ville}" required>


            <button type="submit">Enregistrer</button>

            <button type="reset">Annuler</button>

        </form>

    </main>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
<script src="https://unpkg.com/feather-icons"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.2.0/mdb.min.js"></script>
<script>
    feather.replace();
</script>

</body>
</html>

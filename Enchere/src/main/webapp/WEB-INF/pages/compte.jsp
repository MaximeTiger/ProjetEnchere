<%@ page contentType="text/html;charset=UTF-8" %>
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
    <link rel="stylesheet" href="css/article.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    <title>Compte</title>
</head>
<body>
<header>
    <div>

        <a href="acceuil">
            <img alt="logo" src="./img/logo_redimenssionner-removebg.png">
        </a>
    </div>
    <div>
        <a href="acceuil"><button class="btn-perso btn-white btn-bottom-animation-1 nostyle-btn">Retour</button></a>
    </div>

</header>
<main class="justify-content-center">



<h1>Compte</h1>

<form action="compte" method="post">

    <input type="hidden" name="NoUtilisateur" value="${SessionUtilisateur.noUtilisateur}">

    <label for="pseudo">Pseudo :</label>
    <input type="text" name="pseudo" id="pseudo" value="${SessionUtilisateur.pseudo}" ${modif}>

    <label for="nom">Nom :</label>
    <input type="text" name="nom" id="nom" value="${SessionUtilisateur.nom}" ${modif}>

    <label for="prenom">Prenom :</label>
    <input type="text" name="prenom" id="prenom" value="${SessionUtilisateur.prenom}" ${modif}>

    <label for="mail">Mail :</label>
    <input type="email" name="mail" id="mail" value="${SessionUtilisateur.email}" ${modif}>

    <label for="telephone">Telephone : </label>
    <input type="tel" name="telephone" id="telephone" pattern="[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}[0-9]{2}" value="${SessionUtilisateur.telephone}" ${modif}>

    <label for="rue">Rue :</label>
    <input type="text" name="rue" id="rue" value="${SessionUtilisateur.rue}" ${modif}>

    <label for="codePostal">Code postal :</label>
    <input type="text" name="codePostal" id="codePostal" pattern="[0-9]{5}" value="${SessionUtilisateur.codePostal}" ${modif}>

    <label for="ville">Ville :</label>
    <input type="text" name="ville" id="ville" value="${SessionUtilisateur.getVille()}" ${modif}>

    <label for="motdepasse">Mot de Passe :</label>
    <input type="password" name="motdepasse" id="motdepasse" value="${SessionUtilisateur.motDePasse}" ${modif}>

    <label for="confirmationMotdepasse">Confirmation du Mot de Passe</label>
    <input type="password" name="confirmationMotdepasse" id="confirmationMotdepasse" value="${SessionUtilisateur.motDePasse}" ${modif}>

    <button type="submit" class="btn-perso btn-white btn-bottom-animation-1 nostyle-btn" ${modif}>Enregistrer</button>
</form>

    <a href="compte?action=modifier"><button class="btn-perso btn-white btn-bottom-animation-1 nostyle-btn">Modifier</button></a>
    <a href="compte?action=supprimer&NoUtilisateur=${SessionUtilisateur.noUtilisateur}"><button class="btn-perso btn-white btn-bottom-animation-1 nostyle-btn">Supprimer</button></a>

</main>
</body>
</html>

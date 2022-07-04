<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Compte</title>
</head>
<body>

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
    <input type="text" name="codePostal" id="codePostal" value="${SessionUtilisateur.codePostal}" ${modif}>

    <label for="ville">Ville :</label>
    <input type="text" name="ville" id="ville" value="${SessionUtilisateur.getVille()}" ${modif}>

    <label for="motdepasse">Mot de Passe :</label>
    <input type="password" name="motdepasse" id="motdepasse" value="${SessionUtilisateur.motDePasse}" ${modif}>

    <label for="confirmationMotdepasse">Confirmation du Mot de Passe</label>
    <input type="password" name="confirmationMotdepasse" id="confirmationMotdepasse" value="${SessionUtilisateur.motDePasse}" ${modif}>

    <a href="compte?action=modifier">Modifier</a>
    <button type="submit" ${modif}>Enregistrer</button>

</form>

<a href="acceuil?action=connecter">Retour</a>

</body>
</html>

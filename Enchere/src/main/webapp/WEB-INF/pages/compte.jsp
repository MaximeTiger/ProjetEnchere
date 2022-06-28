<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Compte</title>
</head>
<body>

<h1>Compte</h1>

<form action="compte" method="post">

    <input type="hidden" name="NoUtilisateur" value="${utilisateur.noUtilisateur}">

    <label for="pseudo">Pseudo :</label>
    <input type="text" name="pseudo" id="pseudo" value="${utilisateur.pseudo}" ${modif}>

    <label for="nom">Nom :</label>
    <input type="text" name="nom" id="nom" value="${utilisateur.nom}" ${modif}>

    <label for="prenom">Prenom :</label>
    <input type="text" name="prenom" id="prenom" value="${utilisateur.prenom}" ${modif}>

    <label for="mail">Mail :</label>
    <input type="email" name="mail" id="mail" value="${utilisateur.email}" ${modif}>

    <label for="telephone">Telephone : </label>
    <input type="tel" name="telephone" id="telephone" value="${utilisateur.telephone}" ${modif}>

    <label for="rue">Rue :</label>
    <input type="text" name="rue" id="rue" value="${utilisateur.rue}" ${modif}>

    <label for="codePostal">Code postal :</label>
    <input type="text" name="codePostal" id="codePostal" value="${utilisateur.codePostal}" ${modif}>

    <label for="ville">Ville :</label>
    <input type="text" name="ville" id="ville" value="${utilisateur.getVille()}" ${modif}>

    <label for="motdepasse">Mot de Passe :</label>
    <input type="password" name="motdepasse" id="motdepasse" value="${utilisateur.motDePasse}" ${modif}>

    <label for="confirmationMotdepasse">Confirmation du Mot de Passe</label>
    <input type="password" name="confirmationMotdepasse" id="confirmationMotdepasse" value="${utilisateur.motDePasse}" ${modif}>

    <a href="compte?action=modifier">Modifier</a>
    <button type="submit" ${modif}>Enregistrer</button>

</form>

<a href="acceuil?action=connecter">Retour</a>

</body>
</html>

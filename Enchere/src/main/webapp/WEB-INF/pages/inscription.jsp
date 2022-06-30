<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="fr">
<head>
    <title>Inscription</title>
</head>
<body>

<h1>Inscription</h1>

<form action="inscription" method="post">

    <label for="pseudo">Pseudo :</label>
    <input type="text" name="pseudo" id="pseudo">

    <label for="nom">Nom :</label>
    <input type="text" name="nom" id="nom">

    <label for="prenom">Prenom :</label>
    <input type="text" name="prenom" id="prenom">

    <label for="mail">Mail :</label>
    <input type="email" name="mail" id="mail">

    <label for="telephone">Telephone : </label>
    <input type="tel" name="telephone" id="telephone">

    <label for="rue">Rue :</label>
    <input type="text" name="rue" id="rue">

    <label for="codePostal">Code postal :</label>
    <input type="text" name="codePostal" id="codePostal">

    <label for="ville">Ville :</label>
    <input type="text" name="ville" id="ville">

    <label for="motdepasse">Mot de Passe :</label>
    <input type="password" name="motdepasse" id="motdepasse">

    <label for="confirmationMotdepasse">Confirmation du Mot de Passe</label>
    <input type="password" name="confirmationMotdepasse" id="confirmationMotdepasse">

    <button type="submit">Inscription</button>
    <a href="${pageContext.request.contextPath}/acceuil">Retour</a>

</form>

</body>
</html>

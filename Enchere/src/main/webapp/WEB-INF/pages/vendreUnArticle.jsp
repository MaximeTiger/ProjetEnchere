
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="fr">
<head>
    <title>Vendre un article</title>
</head>
<body>

<h1>Nouvelle vente</h1>

<form action="vendreUnArticle" method="post">

    <label for="idNom">Article : </label>
    <input type="text" name="nom" id="idNom" required>

    <label for="idDescription">Description : </label>
    <input type="textarea" name="description" id="idDescription" required>

    <label for="idCategorie">Categorie </label>
        <select name="categorie" id="idCategorie" required>
            <option value="">-- Choisir une catégorie --</option>
            <option value="0">Informatique</option>
            <option value="1">Ameublement</option>
            <option value="2">Vêtement</option>
            <option value="3">Sport & Loisirs</option>
        </select>

    <label >Photo de l'article </label>
    <button>UPLOADER</button>

    <label for="idMiseAPrix">Mise à prix : </label>
    <input type="number" name="miseAPrix" id="idMiseAPrix" required>

    <label for="idDebutEnchere">Début de l'enchère : </label>
    <input type="date" name="debutEnchere" id="idDebutEnchere" required>

    <label for="idFinEnchere">Fin de l'enchère : </label>
    <input type="date" name="finEnchere" id="idFinEnchere" required>


    <label for="idRue">Rue : </label>
    <input type="text" name="rue" id="idRue" value="${utilisateur.rue}"required>

    <label for="idCodePostal">Code postal : </label>
    <input type="text" name="codePostal" id="idCodePostal" value="${utilisateur.codePostal}" required>

    <label for="idVille">Ville : </label>
    <input type="text" name="ville" id="idVille" value="${utilisateur.ville}" required>


    <button type="submit">Enregistrer</button>

    <button type="submit">Annuler</button>

</form>


</body>
</html>

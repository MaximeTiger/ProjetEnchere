
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="fr">
<head>
    <title>Vendre un article</title>
</head>
<body>

<h1>Nouvelle vente</h1>

<form action="vendreUnArticle" method="post">

    <label for="idNom">Article : </label>
    <input type="text" name="nom" id="idNom">

    <label for="idDescription">Description : </label>
    <input type="textarea" name="description" id="idDescription">

    <label for="idCategorie">Categorie </label>
        <select name="categorie" id="idCategorie">
            <option value="0">Informatique</option>
            <option value="1">Ameublement</option>
            <option value="2">Vêtement</option>
            <option value="3">Sport & Loisirs</option>
        </select>

    <label >Photo de l'article </label>
    <button>UPLOADER</button>

    <label for="idMiseAPrix">Mise à prix : </label>
    <input type="number" name="miseAPrix" id="idMiseAPrix">

    <label for="idDebutEnchere">Début de l'enchère : </label>
    <input type="date" name="debutEnchere" id="idDebutEnchere">

    <label for="idFinEnchere">Fin de l'enchère : </label>
    <input type="date" name="finEnchere" id="idFinEnchere">


    <label for="idRue">Rue : </label>
    <input tpe="text" name="rue" id="idRue">

    <label for="idCodePostal">Code postal : </label>
    <input tpe="text" name="codePostal" id="idCodePostal">

    <label for="idVille">Ville : </label>
    <input tpe="text" name="ville" id="idVille">


    <button type="submit">Enregistrer</button>

    <button type="submit">Annuler</button>
    
</form>


</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Inscription</title>
</head>
<body>

<h1>Inscription</h1>

<form action="connexion" method="post">

    <label for="pseudo"></label>
    <input type="text" name="pseudo" id="pseudo">

    <label for="nom"></label>
    <input type="text" name="nom" id="nom">

    <label for="prenom"></label>
    <input type="text" name="prenom" id="prenom">

    <label for="mail"></label>
    <input type="email" name="mail" id="mail">

    <label for="telephone"></label>
    <input type="tel" name="telephone" id="telephone">

    <label for="rue"></label>
    <input type="text" name="rue" id="rue">

    <label for="codePostal"></label>
    <input type="text" name="codePostal" id="codePostal">

    <label for="ville"></label>
    <input type="text" name="ville" id="ville">

    <label for="motdepasse"></label>
    <input type="password" name="motdepasse" id="motdepasse">

    <label for="confirmationMotdepasse"></label>
    <input type="password" name="confirmationMotdepasse" id="confirmationMotdepasse">

    <button type="submit">Inscription</button>
    <a href="${pageContext.request.contextPath}/acceuil">Retour</a>

</form>

</body>
</html>

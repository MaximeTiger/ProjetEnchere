<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Connexion</title>
</head>
<body>

<h1>Connexion</h1>

<form action="connexion" method="post">

    <label for="pseudo"></label>
    <input type="text" name="pseudo" id="pseudo">
    <label for="motdepasse"></label>
    <input type="password" name="motdepasse" id="motdepasse">
    <label for="mdpcheckbox"></label>
    <input type="checkbox" onclick="Afficher()" id="mdpcheckbox"> Afficher le mot de passe

    <button type="submit">Connexion</button>

</form>




<script>
    function Afficher() {
        var input = document.getElementById("motdepasse");
        if (input.type === "password") {
            input.type = "text";
        }
        else {
            input.type = "password";
        }
    }
</script>

</body>
</html>

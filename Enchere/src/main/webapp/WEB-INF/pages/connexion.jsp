<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- CSS ONLY -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="css/style.css">

    <title>Connexion</title>
</head>
<body>

<div class="row d-flex flex-column text-center">
    <div>
        <h1 class="m-3">Connexion</h1>
    </div>
    <div>
        <form action="connexion" method="post">

            <div class="m-2">
                <label for="pseudo">
                    <input type="text" name="pseudo" id="pseudo" placeholder="Pseudo">
                </label>
            </div>
            <div class="m-2">
                <label id="password">
                    <input type="password" placeholder="Mot de passe">
                    <div class="password-icon">
                        <i data-feather="eye"></i>
                        <i data-feather="eye-off"></i>
                    </div>
                </label>
            </div>



            <button type="submit">Connexion</button>
            <a href="${pageContext.request.contextPath}/inscription" class="inscription">Inscription</a>

        </form>
    </div>
</div>



<p>${error}</p>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

<script src="https://unpkg.com/feather-icons"></script>

<script>
    feather.replace();
</script>

<script>

    const eye = document.querySelector(".feather-eye");
    const eyeoff = document.querySelector(".feather-eye-off");
    const passwordField = document.querySelector("input[type=password]");

    eye.addEventListener("click", () => {
        eye.style.display = "none";
        eyeoff.style.display = "block";
        passwordField.type = "text";
    });

    eyeoff.addEventListener("click", () => {
        eyeoff.style.display = "none";
        eye.style.display = "block";
        passwordField.type = "password";
    });

</script>

</body>
</html>

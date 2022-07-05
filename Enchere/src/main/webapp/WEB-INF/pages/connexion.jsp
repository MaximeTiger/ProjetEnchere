<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="fr">
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
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    <title>Connexion & Inscription</title>
</head>
<body>



<div class="connexion">

    <!-- div qui affiche le menu connexion ou inscription ansi que le bouton -->
    <div class="d-flex justify-content-center">
        <ul class="nav nav-pills mb-3" id="ex1" role="tablist">

            <li class="retour">
                <a href="${pageContext.request.contextPath}/acceuil">
                    <button class="retourbtn effect">
                        <span class="material-symbols-outlined color center">arrow_back</span>
                    </button>
                </a>
            </li>

            <li class="nav-item" role="presentation">
                <a class="nav-link active" id="ex1-tab-1" data-mdb-toggle="pill" href="#ex1-pills-1" role="tab" aria-controls="ex1-pills-1" aria-selected="true">Se connecter</a>
            </li>
            <li class="nav-item" role="presentation">
                <a class="nav-link" id="ex1-tab-2" data-mdb-toggle="pill" href="#ex1-pills-2" role="tab" aria-controls="ex1-pills-2" aria-selected="false">S'inscrire</a>
            </li>
        </ul>
    </div>

    <!-- Tableau de connexion & inscription -->
    <div class="tab-content" id="ex1-content">

        <!-- page de connexion -->
        <div class="tab-pane fade show active" id="ex1-pills-1" role="tabpanel" aria-labelledby="ex1-tab-1">
            <!-- titre de la section -->
            <div>
                <h1 class="h1connexion">Connexion</h1>
            </div>
            <!--------------------------- Formulaire connexion--------------------------->
            <div class="form">
                <form action="connexion" method="post" class="form formulaire">
                    <div>
                        <div class="m-3">
                            <label for="pseudoConnexion" class="fit-div">
                                <input type="text" name="pseudo" id="pseudoConnexion" placeholder="Pseudo" class="fit-div" required>
                            </label>
                        </div>
                        <div class="m-3">
                            <label class="password fit-div">
                                <input type="password" placeholder="Mot de passe" name="motdepasse" class="fit-div">
                                <div class="password-icon">
                                    <i data-feather="eye"></i>
                                    <i data-feather="eye-off"></i>
                                </div>
                            </label>
                        </div>
                    </div>
                    <div>
                        <p class="error">${error}</p>
                    </div>

                    <div class="bouton">
                        <div class="input-bouton">
                            <button type="submit" class="btn-perso btn-white btn-bottom-animation-1 nostyle-btn">Connexion</button>
                        </div>
                    </div>
                </form>
            </div>
            <!-- fin du formulaire de connexion -->
        </div>

        <!-- page d'inscription -->
        <div class="tab-pane fade" id="ex1-pills-2" role="tabpanel" aria-labelledby="ex1-tab-2">

            <!-- titre de la section -->
            <div>
                <h1 class="h1connexion">Inscription</h1>
            </div>
            <!------------------ Formulaire d'inscription ------------------>
            <div class="form">
                <form action="inscription" method="post" class="form formulaire">

                    <div class="row justify-content-center">

                        <div class="col-12 mt-2">
                            <label for="pseudoInscription" class="fit-div">
                                <input type="text" name="pseudo" id="pseudoInscription" placeholder="Pseudo" class="fit-div">
                            </label>
                        </div>

                        <div class="col-12 mt-2 d-flex justify-content-center">
                            <div class="p-0 size-div-gauche">
                                <label for="nom" class="fit-div">
                                    <input type="text" name="nom" id="nom" placeholder="Nom" class="fit-div">
                                </label>
                            </div>
                            <div class="p-0 size-div-droite">
                                <label for="prenom" class="fit-div">
                                    <input type="text" name="prenom" id="prenom" placeholder="Prenom" class="fit-div">
                                </label>
                            </div>
                        </div>

                        <div class="col-12 mt-2">
                            <label for="mail" class="fit-div">
                                <input type="email" name="mail" id="mail" placeholder="Mail" class="fit-div">
                            </label>
                        </div>

                        <div class="col-12 mt-2 d-flex justify-content-center">
                            <div class="p-0 size-div-gauche">
                                <label for="telephone" class="fit-div">
                                    <input type="tel" name="telephone" id="telephone" placeholder="Telephone" class="fit-div">
                                </label>
                            </div>
                            <div class="p-0 size-div-droite">
                                <label for="rue" class="fit-div">
                                    <input type="text" name="rue" id="rue" placeholder="Rue" class="fit-div">
                                </label>
                            </div>
                        </div>

                        <div class="col-12 mt-2 d-flex justify-content-center">
                            <div class="p-0 size-div-gauche">
                                <label for="codePostal" class="fit-div">
                                    <input type="text" name="codePostal" id="codePostal" placeholder="Code postal" class="fit-div">
                                </label>
                            </div>
                            <div class="p-0 size-div-droite">
                                <label for="ville" class="fit-div">
                                    <input type="text" name="ville" id="ville" placeholder="Ville" class="fit-div">
                                </label>
                            </div>
                        </div>

                        <div class="col-12 mt-2">
                            <label class="password fit-div">
                                <input type="password" placeholder="Mot de passe" name="motdepasse" class="fit-div">
                                <div class="password-icon">
                                    <i data-feather="eye"></i>
                                    <i data-feather="eye-off"></i>
                                </div>
                            </label>
                        </div>

                        <div class="col-12 mt-2">
                            <label class="password fit-div">
                                <input type="password" placeholder="Confirmez le mot de passe" name="confirmMotdepasse" class="fit-div">
                                <div class="password-icon">
                                    <i data-feather="eye"></i>
                                    <i data-feather="eye-off"></i>
                                </div>
                            </label>
                        </div>

                    </div>

                    <div class="input-bouton">
                        <button type="submit" class="btn-perso btn-white btn-bottom-animation-1 nostyle-btn">Inscription</button>
                    </div>

                </form>
            </div>
            <!-- fin du form -->
        </div>
    </div>
</div>




<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
<script src="https://unpkg.com/feather-icons"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.2.0/mdb.min.js"></script>
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
        passwordField.type = "text";});
    eyeoff.addEventListener("click", () => {
        eyeoff.style.display = "none";
        eye.style.display = "block";
        passwordField.type = "password";
    });
</script>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="fr">
<head>
    <title>Acceuil</title>
</head>
<body>

  <h1>Acceuil</h1>

  <p>${bonjour}</p>

${connexion}
${compte}
<br>

  <c:forEach var="enchere" items="${enchere}">

      <div>
          <div>
              <p>${enchere.noEnchere}</p>
              <p>${enchere.nomArticle}</p>
              <p>${enchere.dateEnchere}</p>
              <p>${enchere.montantEnchere}</p>
              <p>${enchere.nomUtilisateur}</p>
          </div>
      </div>

  </c:forEach>
  <br>
${deco}


</body>
</html>

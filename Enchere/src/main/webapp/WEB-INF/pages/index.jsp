<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      <br>
      <div>
          ${enchere.noEnchere}
          ${enchere.dateEnchere}
          ${enchere.montantEnchere}
          ${enchere.nomUtilisateur}
          ${enchere.nomArticle}
          <a href="${pageContext.request.contextPath}/afficherUnArticle?action=afficher&noArticle=${enchere.noArticle}">Afficher l'article</a>

      <%--${enchere.nomUtilisateur}--%>
      </div>
      <br>
  </c:forEach>

  <a href="${pageContext.request.contextPath}/vendreUnArticle.jsp">vendre un article</a>

  <br>
${deco}


</body>
</html>

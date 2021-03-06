package fr.eni.enchere.ihm;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.BLLFactory;
import fr.eni.enchere.bll.article.ArticleManager;
import fr.eni.enchere.bll.enchere.EnchereManager;
import fr.eni.enchere.bo.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@WebServlet("/acceuil")
public class AcceuilServlet extends HttpServlet {

    private final EnchereManager enchereManager;
    private final ArticleManager articleManager;

    public AcceuilServlet() {
        enchereManager = BLLFactory.getEnchereManager();
        articleManager = BLLFactory.getArticleManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();

        if (session.getAttribute("SessionUtilisateur") == null) {
            session.setAttribute("connexion", "<a href=\"connexion\">Connexion - Inscription</a>\n<br>\n");
            session.setAttribute("detail", "hidden");
        } else if (session.getAttribute("SessionUtilisateur") != null) {
            session.setAttribute("connexion", "");
            session.setAttribute("compte", "<a href=\"compte\">Compte</a>\n");
            session.setAttribute("deco", "<a href=\"connexion?action=deconnexion\">Deconnexion</a>");
            session.setAttribute("detail", "");
        }

        //affichage de la liste d'enchères
        try {
            session.setAttribute("article", articleManager.selectAll());
        } catch (BLLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req, resp);
    }

}
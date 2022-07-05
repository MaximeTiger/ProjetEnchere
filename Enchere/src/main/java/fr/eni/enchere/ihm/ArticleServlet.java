package fr.eni.enchere.ihm;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.BLLFactory;
import fr.eni.enchere.bll.article.ArticleManager;
import fr.eni.enchere.bll.enchere.EnchereManager;
import fr.eni.enchere.bll.utilisateurs.UtilisateursManager;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Enchere;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/afficherUnArticle")
public class ArticleServlet extends HttpServlet {
    private final ArticleManager articleManager;
    private final EnchereManager enchereManager;

    public ArticleServlet() {
        enchereManager = BLLFactory.getEnchereManager();
        articleManager = BLLFactory.getArticleManager();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("noArticle"));

        Article art;

        try {
            art = articleManager.afficherUnArticle(id);
            System.out.println(art.getPrixInitial());
        } catch (BLLException e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("article",art);

        req.getRequestDispatcher("/WEB-INF/pages/afficherUnArticle.jsp").forward(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int montantEnchere = Integer.parseInt(req.getParameter("proposition"));
        LocalDate dateEnchere = LocalDate.now();
        int noUtil = Integer.parseInt(req.getParameter("noUtilisateur"));
        int noArt = Integer.parseInt(req.getParameter("noArticle"));

        Enchere ench = new Enchere(
                dateEnchere,montantEnchere,noUtil,noArt
        );
        try {
            enchereManager.faireEnchere(ench);
        } catch (BLLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/pages/afficherUnArticle.jsp").forward(req,resp);

    }
}
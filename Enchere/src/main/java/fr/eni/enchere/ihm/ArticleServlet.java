package fr.eni.enchere.ihm;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.BLLFactory;
import fr.eni.enchere.bll.article.ArticleManager;
import fr.eni.enchere.bll.enchere.EnchereManager;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Enchere;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/afficherUnArticle")
public class ArticleServlet extends HttpServlet {

    private ArticleManager articleManager;

    private EnchereManager enchereManager;

    public ArticleServlet(ArticleManager articleManager, EnchereManager enchereManager) {
        enchereManager = BLLFactory.getEnchereManager();
        articleManager = BLLFactory.getArticleManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if("afficher".equals(action)){
            doAfficherUnArticle(req, resp);
        }

        req.getRequestDispatcher("/WEB-INF/pages/afficherUnArticle.jsp").forward(req,resp);

    }

    protected void doAfficherUnArticle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("noArticle"));

        Article art;
        try {
            art = articleManager.afficherUnArticle(id);
        } catch (BLLException e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("article",art);

    }

    protected void doEnchere(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LocalDate dateEnchere = LocalDate.parse(req.getParameter("dateEnchere"));
        int montantEnchere = Integer.parseInt(req.getParameter("montantEnchere"));

        Enchere ench = new Enchere(
                dateEnchere,montantEnchere,
                req.getParameter("nomUtilisateur"),req.getParameter("nomArticle")
        );
        if(req.getParameter("noEnchere").isBlank()){
            try {
                enchereManager.faireEnchere(ench);
            } catch (BLLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

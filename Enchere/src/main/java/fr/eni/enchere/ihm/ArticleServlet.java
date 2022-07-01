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

    private final ArticleManager articleManager;

    private final EnchereManager enchereManager;

    public ArticleServlet() {
        enchereManager = BLLFactory.getEnchereManager();
        articleManager = BLLFactory.getArticleManager();
    }
    Article art;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("noArticle"));


        try {
            art = articleManager.afficherUnArticle(id);
        } catch (BLLException e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("article",art);

       req.getRequestDispatcher("/WEB-INF/pages/afficherUnArticle.jsp").forward(req,resp);
    }


  /*  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int montantEnchere = Integer.parseInt(req.getParameter("proposition"));
        LocalDate dateEnchere = LocalDate.now();

        Enchere ench = new Enchere(
                dateEnchere,montantEnchere,noUtil,art.getNoArticle()
        );
        if(req.getParameter("noEnchere").isBlank()){
            try {
                enchereManager.faireEnchere(ench);
            } catch (BLLException e) {
                throw new RuntimeException(e);
            }
        }
        req.getRequestDispatcher("/WEB-INF/pages/afficherUnArticle.jsp").forward(req,resp);

    }*/

}

package fr.eni.enchere.ihm;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.BLLFactory;
import fr.eni.enchere.bll.article.ArticleManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/article")
public class ArticleServlet extends HttpServlet {

    private ArticleManager articleManager;

    public ArticleServlet(ArticleManager articleManager) {
        articleManager = BLLFactory.getArticleManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nomArticle = req.getParameter("nomArticle");

        try {
            req.setAttribute("article",articleManager.afficherUnArticle(nomArticle));
        } catch (BLLException e) {
            throw new RuntimeException(e);
        }

        req.getRequestDispatcher("/WEB-INF/pages/afficherUnArticle.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

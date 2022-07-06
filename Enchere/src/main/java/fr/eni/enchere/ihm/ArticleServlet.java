package fr.eni.enchere.ihm;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.BLLFactory;
import fr.eni.enchere.bll.article.ArticleManager;
import fr.eni.enchere.bll.enchere.EnchereManager;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Utilisateurs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/afficherUnArticle")
public class ArticleServlet extends HttpServlet {
    private final ArticleManager articleManager;
    private final EnchereManager enchereManager;

    public ArticleServlet() {
        enchereManager = BLLFactory.getEnchereManager();
        articleManager = BLLFactory.getArticleManager();
    }
    List<String> nomUtil = new ArrayList<>();
    List<Integer> montants = new ArrayList<>();

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Utilisateurs util = (Utilisateurs) session.getAttribute("SessionUtilisateur");

        int id = Integer.parseInt(req.getParameter("noArticle"));

        Article art;

        try {
            art = articleManager.afficherUnArticle(id);
        } catch (BLLException e) {
            throw new RuntimeException(e);
        }

        System.out.println();

        req.setAttribute("article",art);
/*
        req.setAttribute("encheres",encheres);
*/

        req.getRequestDispatcher("/WEB-INF/pages/afficherUnArticle.jsp").forward(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Utilisateurs util = (Utilisateurs) session.getAttribute("SessionUtilisateur");

        int montantEnchere = Integer.parseInt(req.getParameter("proposition"));
        LocalDate dateEnchere = LocalDate.now();

        int noArt = Integer.parseInt(req.getParameter("noArticle"));

        Enchere ench = new Enchere(
                dateEnchere, montantEnchere, util.getNoUtilisateur(), noArt
        );

        nomUtil.add(util.getPseudo());
        montants.add(montantEnchere);

        try {
            enchereManager.faireEnchere(ench);
        } catch (BLLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/pages/afficherUnArticle.jsp").forward(req,resp);

    }
}
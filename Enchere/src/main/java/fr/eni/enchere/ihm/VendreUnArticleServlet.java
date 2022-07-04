package fr.eni.enchere.ihm;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.BLLFactory;
import fr.eni.enchere.bll.article.ArticleManager;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.DALException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/vendreUnArticle")
public class VendreUnArticleServlet extends HttpServlet {

    private ArticleManager articleManager;

    public VendreUnArticleServlet( ) {
        articleManager = BLLFactory.getArticleManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/pages/vendreUnArticle.jsp").forward(req,resp);
    }

    //affichage depuis l'accueil de la page de vente d'un nouvel article

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("nomArticle"));

        Article saisie = new Article(
                req.getParameter("nom"),
                req.getParameter("description"),
                LocalDate.parse(req.getParameter("debutEnchere")),
                LocalDate.parse(req.getParameter("finEnchere")),
                Integer.parseInt(req.getParameter("miseAPrix")),
                req.getParameter("libelle"),
                req.getParameter("rue"),
                req.getParameter("codePostal"),
                req.getParameter("ville"));

        try{

            if(saisie.getNomArticle() == null || saisie.getNomArticle().isBlank()) {
                req.setAttribute("error", "Le nom de l'article doit etre saisie");
            }
            else if(saisie.getNomArticle() == null || saisie.getNomArticle().isBlank()){
                req.setAttribute("error","Le nom de l'article doit etre saisie");
            }
            else if(saisie.getDescription() == null || saisie.getDescription().isBlank()){
                req.setAttribute("error"," La descritption doit être saisie");
            }
            else if(saisie.getPrixInitial() <= 0) {
                req.setAttribute("error", " Le prix doit être positif");
            }
            else if(saisie.getPrixVente() <= 0) {
                req.setAttribute("error"," Erreur prix de vente doit être positif");
            }

                req.setAttribute("errorPrixV"," Le prix doit être positif");
            articleManager.ajouterUnArticle(saisie);
        }catch(BLLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath()+"/vendreUnArticle");
    }
}


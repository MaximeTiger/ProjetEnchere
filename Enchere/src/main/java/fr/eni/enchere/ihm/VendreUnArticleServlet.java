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
    private int prixInitial;
    private ArticleManager articleMger;
    public VendreUnArticleServlet( ) {
        articleManager = BLLFactory.getArticleManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/pages/vendreUnArticle.jsp").forward(req,resp);
    }

    //affichage depuis l'accueil de la page de vente d'un nouvel article

    protected void doVendreUnArticle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        prixInitial = Integer.parseInt(req.getParameter("prixInitial"));
        LocalDate debut = LocalDate.parse(req.getParameter("debutEncheres"));
        LocalDate fin = LocalDate.parse(req.getParameter("finEncheres"));

        Article saisie = new Article(req.getParameter("nomArticle"), req.getParameter("description"),
                debut, fin,prixInitial
                ,req.getParameter("libelle"), req.getParameter("rue"), req.getParameter("codePostal")
                ,req.getParameter("ville"));

        if(!req.getParameter("noArticle").isBlank()){
            int no = Integer.parseInt(req.getParameter("noArticle"));
            saisie.setNoArticle(no);
        }
        try{

            /*if(article.getNomArticle() == null || article.getNomArticle().isBlank()){
                req.setAttribute("error","Le nom de l'article doit etre saisie");
            }
            else if(article.getDescription() == null || article.getDescription().isBlank()){
                message.append(" Erreur description obligatoire");
            }
            else if(article.getLibelle() == null || article.getLibelle().isBlank())  {
                message.append(" Erreur catégorie obligatoire");
            }
            else if(article.getPrixInitial() <= 0) {
                message.append(" Erreur prix unitaire doit Ãªtre positif");
            }
            else if(article.getPrixVente() <= 0) {
                message.append(" Erreur prix de vente doit Ãªtre positif");
            }*/

            articleMger.ajouterUnArticle(saisie);
        }catch(BLLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath()+"/vendreUnArticle");
    }
}


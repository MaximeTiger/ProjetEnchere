package fr.eni.enchere.ihm;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.BLLFactory;
import fr.eni.enchere.bll.article.ArticleManager;
import fr.eni.enchere.bll.categorie.CategorieManager;
import fr.eni.enchere.bll.retrait.RetraitManager;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.bo.Utilisateurs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/vendreUnArticle")
public class VendreUnArticleServlet extends HttpServlet {

    private final ArticleManager articleManager;
    private final CategorieManager categorieManager;
    private final RetraitManager retraitManager;

    public VendreUnArticleServlet( ) {
        articleManager = BLLFactory.getArticleManager();
        categorieManager = BLLFactory.getCategorieManager();
        retraitManager = BLLFactory.getRetraitManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Utilisateurs util = (Utilisateurs) session.getAttribute("SessionUtilisateur");

        List<String> nomLabelle;

        try {
            nomLabelle = categorieManager.selectName();
        } catch (BLLException e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("labelle",nomLabelle);

        req.getRequestDispatcher("/WEB-INF/pages/vendreUnArticle.jsp").forward(req,resp);
    }

    //affichage depuis l'accueil de la page de vente d'un nouvel article

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Utilisateurs util = (Utilisateurs) session.getAttribute("SessionUtilisateur");

        int numLibel = 0;
        switch (req.getParameter("categorie")){
            case "voiture" :
                numLibel = 1;
                break;
            case "Informatique" :
                numLibel = 2;
                break;
            case "Ameublement" :
                numLibel = 3;
                break;
            case "Vetements" :
                numLibel = 4;
                break;
            case "Sport et Loisirs" :
                numLibel = 5;
                break;
        }

        Article saisie = new Article(
                req.getParameter("nomArticle"),
                req.getParameter("description"),
                LocalDate.parse(req.getParameter("debutEnchere")),
                LocalDate.parse(req.getParameter("finEnchere")),
                Integer.parseInt(req.getParameter("miseAPrix")),
                numLibel,
                req.getParameter("rue"),
                req.getParameter("codePostal"),
                req.getParameter("ville"),
                util.getNoUtilisateur()
        );

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
            }else{
                articleManager.ajouterUnArticle(saisie);

                Article art = articleManager.selectId(saisie.getNomArticle(), saisie.getDescription(),saisie.getNoUtilisateur(), saisie.getNoCategorie());

                Retrait retrait = new Retrait(
                        art.getNoArticle(),
                        util.getRue(),
                        util.getCodePostal(),
                        util.getVille()
                );
                retraitManager.ajouterRetrait(retrait);
            }

        }catch(BLLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("acceuil");
    }
}


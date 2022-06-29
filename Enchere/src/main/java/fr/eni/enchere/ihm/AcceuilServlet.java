package fr.eni.enchere.ihm;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.article.ArticleManager;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bll.BLLFactory;
import fr.eni.enchere.bll.enchere.EnchereManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/acceuil")
public class AcceuilServlet extends HttpServlet {

    private ArticleManager articleMger;
    private int prixInitial;

    private final EnchereManager enchereManager;

    public AcceuilServlet() {
        enchereManager = BLLFactory.getEnchereManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("connecter".equals(action)){
            doConnect(req, resp);
        } else {
            req.setAttribute("connexion", "<a href=\"connexion\">Connexion - Inscription</a>\n<br>\n");
        }
//affichage de la liste d'enchères en mode déconnecter
        try {
            req.setAttribute("enchere",enchereManager.enchereEnCours());
        } catch (BLLException e) {
            e.printStackTrace();
        }


        req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req,resp);
    }

    protected void doConnect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("connexion", "");

    }

    //affichage depuis l'accueil de la page de vente d'un nouvel article
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        prixInitial = Integer.parseInt(req.getParameter("prixInitial"));
        LocalDate debut = LocalDate.parse(req.getParameter("debutEncheres"));
        LocalDate fin = LocalDate.parse(req.getParameter("finEncheres"));


        Article saisie = new Article(req.getParameter("nomArticle"), req.getParameter("descritption"),
                debut, fin,prixInitial
                ,req.getParameter("libelle"), req.getParameter("rue"), req.getParameter("codePostal")
                ,req.getParameter("ville"));
        if(!req.getParameter("noArticle").isBlank()){
            Integer no = Integer.parseInt(req.getParameter("noArticle"));
            saisie.setNoArticle(no);
        }
        try{
            articleMger.ajouterUnArticle(saisie);
        }catch(BLLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath()+"");
    }
}
package fr.eni.enchere.ihm;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.BLLFactory;
import fr.eni.enchere.bll.article.ArticleManager;
import fr.eni.enchere.bll.enchere.EnchereManager;
import fr.eni.enchere.bll.utilisateurs.UtilisateursManager;
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

@WebServlet("/afficherUnArticle")
public class ArticleServlet extends HttpServlet {
    private final ArticleManager articleManager;
    private final EnchereManager enchereManager;
    private final UtilisateursManager utilisateursManager;

    public ArticleServlet() {
        enchereManager = BLLFactory.getEnchereManager();
        articleManager = BLLFactory.getArticleManager();
        utilisateursManager = BLLFactory.getUtilisateursManager();
    }
    int nbEnch = 0;

    int id;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Article art = null;
        Enchere lastEnch = null;
        Utilisateurs lastUtil = null;
        int prixMin;

        id = Integer.parseInt(req.getParameter("noArticle"));

        System.out.println(id);

        try {
            art = articleManager.afficherUnArticle(id);
        } catch (BLLException e) {
            e.printStackTrace();
        }

        session.setAttribute("article",art);

        System.out.println("article a afficher : " + art);

        try {
            lastEnch = enchereManager.selectMaxEnchere(id);
        } catch (BLLException e) {
            e.printStackTrace();
        }

        if (lastEnch == null){
            prixMin = art.getPrixInitial()+1;
            session.setAttribute("prixMin",prixMin);
            session.setAttribute("encherisseur","");
            session.setAttribute("prixEnchere","");
        } else {

            try {
                lastUtil = utilisateursManager.selectById(lastEnch.getNoUtilisateur());
            } catch (BLLException e) {
                e.printStackTrace();
            }

            prixMin = lastEnch.getMontantEnchere()+1;

            session.setAttribute("prixMin",prixMin);
            session.setAttribute("encherisseur","Encherisseur : ");
            session.setAttribute("prixEnchere","Prix : ");
            session.setAttribute("pseudoAcheteur",lastUtil.getPseudo());
            session.setAttribute("meilleur_enchere",lastEnch.getMontantEnchere());
        }


        req.getRequestDispatcher("/WEB-INF/pages/afficherUnArticle.jsp").forward(req,resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        Utilisateurs util = (Utilisateurs) session.getAttribute("SessionUtilisateur");


        int montantEnchere = Integer.parseInt(req.getParameter("proposition"));
        LocalDate dateEnchere = LocalDate.now();



        Enchere ench = new Enchere(dateEnchere, montantEnchere, util.getNoUtilisateur(), id);

        nbEnch ++;

        try {
            enchereManager.faireEnchere(ench);
        } catch (BLLException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("afficherUnArticle?noArticle=" + id);
    }

}
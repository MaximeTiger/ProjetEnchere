package fr.eni.enchere.ihm;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.BLLFactory;
import fr.eni.enchere.bll.UtilisateursManager;
import fr.eni.enchere.bo.Utilisateurs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {

    private final UtilisateursManager mgerInsc;

    public InscriptionServlet(){
        mgerInsc = BLLFactory.getUtilisateursManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/inscription.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utilisateurs util = new Utilisateurs(req.getParameter("pseudo"),req.getParameter("nom"),
                req.getParameter("prenom"),req.getParameter("mail"),req.getParameter("telephone"),
                req.getParameter("rue"),req.getParameter("codePostal"),req.getParameter("ville"),
                req.getParameter("motdepasse"));

        try {
            mgerInsc.suscribe(util);
            System.out.println("good!");
        } catch (BLLException e) {
            e.printStackTrace();
        }

    }
}
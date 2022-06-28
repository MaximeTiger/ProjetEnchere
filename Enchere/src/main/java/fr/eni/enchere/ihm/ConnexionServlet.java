package fr.eni.enchere.ihm;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.BLLFactory;
import fr.eni.enchere.bll.utilisateurs.UtilisateursManager;
import fr.eni.enchere.bo.Utilisateurs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {

    private final UtilisateursManager mgerConn;

    public ConnexionServlet(){
        mgerConn = BLLFactory.getUtilisateursManager();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/connexion.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    Utilisateurs util;
        try {
            util = mgerConn.connexion(req.getParameter("pseudo"),req.getParameter("motdepasse"));
            System.out.println(util);
            if (util != null) {
                req.setAttribute("connexion","Bonjour " + util.getPseudo());
                req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req,resp);
            } else {
                req.setAttribute("error","Mot de passe ou Pseudo incorrect");
                req.getRequestDispatcher("/WEB-INF/pages/connexion.jsp").forward(req,resp);
            }
        } catch (BLLException | ServletException e) {
            e.printStackTrace();
        }

    }

}

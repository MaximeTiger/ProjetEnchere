package fr.eni.enchere.ihm;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.BLLFactory;
import fr.eni.enchere.bll.utilisateurs.UtilisateursManager;
import fr.eni.enchere.bo.Utilisateurs;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {

    HttpSession session;
    private final UtilisateursManager mgerConn;

    public ConnexionServlet(){
        mgerConn = BLLFactory.getUtilisateursManager();
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("deconnexion".equals(action)){
            doDeconnexion(req, resp);
        }

        req.getRequestDispatcher("/WEB-INF/pages/connexion.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    Utilisateurs util;
        try {
            util = mgerConn.connexion(req.getParameter("pseudo"),req.getParameter("motdepasse"));
            if (util != null) {
                req.setAttribute("bonjour","Bonjour " + util.getPseudo());
                session = req.getSession();
                session.setAttribute("utilisateur",util);
                session.setAttribute("compte","<a href=\"compte\">Compte</a>\n");
                session.setAttribute("deco","<a href=\"connexion?action=deconnexion\">Deconnexion</a>");
                req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req,resp);
            } else {
                req.setAttribute("error","Mot de passe ou Pseudo incorrect");
                req.getRequestDispatcher("/WEB-INF/pages/connexion.jsp").forward(req,resp);
            }
        } catch (BLLException | ServletException e) {
            e.printStackTrace();
        }

    }

    protected void doDeconnexion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        session.invalidate();
        req.getRequestDispatcher("acceuil").forward(req,resp);
    }
}

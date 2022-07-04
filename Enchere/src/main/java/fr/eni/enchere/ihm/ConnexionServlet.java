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

    private final UtilisateursManager mgerConn;

    public ConnexionServlet(){
        mgerConn = BLLFactory.getUtilisateursManager();
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("deconnexion".equals(action)){
            doDeconnexion(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/pages/connexion.jsp").forward(req,resp);
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session;
        Utilisateurs util;
            try {
                /*
                 * Vérifie si l'utilisateur existe et créer une session
                 */
                util = mgerConn.connexion(req.getParameter("pseudo"),req.getParameter("motdepasse"));
                session = req.getSession();

                if (util != null) {
                    /*
                     * Si l'utilisateur existe alors il ajoute l'utilisateur à l'attribut SessionUtilisateur
                     * et redirige sur l'index
                     */
                    session.setAttribute("SessionUtilisateur",util);
                    resp.sendRedirect("acceuil");

                } else {
                    /*
                     * Si l'utilisateur n'existe pas alors il ajoute null à l'attribut SessionUtilisateur
                     * et redirige sur la JSP connexion avec un message d'erreur
                     */
                    session.setAttribute("SessionUtilisateur",null);
                    req.setAttribute("error","Mot de passe ou Pseudo incorrect");
                    req.getRequestDispatcher("/WEB-INF/pages/connexion.jsp").forward(req,resp);

                }
            } catch (BLLException | ServletException e) {
                e.printStackTrace();
            }

    }

    /*
     * Invalide la session de l'utilisateur et le redirige sur l'accueil du site
     */
    protected void doDeconnexion(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect("acceuil");
    }
}

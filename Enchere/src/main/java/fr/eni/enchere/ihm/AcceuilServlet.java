package fr.eni.enchere.ihm;


import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.BLLFactory;
import fr.eni.enchere.bll.enchere.EnchereManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/acceuil")
public class AcceuilServlet extends HttpServlet {

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
            throw new RuntimeException(e);
        }


        req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req,resp);
    }

    protected void doConnect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("connexion", "");

    }
}
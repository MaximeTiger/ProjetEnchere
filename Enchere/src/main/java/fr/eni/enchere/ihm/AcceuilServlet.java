package fr.eni.enchere.ihm;

import fr.eni.enchere.bll.enchere.EnchereManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/acceuil")
public class AcceuilServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("connecter".equals(action)){
            doConnect(req, resp);
        } else {
            req.setAttribute("connexion", "<a href=\"connexion\">Connexion - Inscription</a>\n<br>\n");
        }







        req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req,resp);
    }

    protected void doConnect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("connexion", "");

    }
}
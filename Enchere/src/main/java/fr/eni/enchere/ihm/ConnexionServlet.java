package fr.eni.enchere.ihm;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.BLLFactory;
import fr.eni.enchere.bll.UtilisateursManager;

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

    String pseudo = req.getParameter("pseudo");
    String Mdp = req.getParameter("motdepasse");

        try {
            mgerConn.connexion(pseudo,Mdp);
        } catch (BLLException e) {
            e.printStackTrace();
        }

    }

}

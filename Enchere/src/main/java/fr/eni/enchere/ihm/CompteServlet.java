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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/compte")
public class CompteServlet extends HttpServlet {

    private final UtilisateursManager mgerCompte;

    public CompteServlet(){
        mgerCompte = BLLFactory.getUtilisateursManager();
    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("modif","disabled");

        String action = req.getParameter("action");

        if ("modifier".equals(action)){
            doModifier(req, resp);
        }

        req.getRequestDispatcher("/WEB-INF/pages/compte.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Utilisateurs util = new Utilisateurs(Integer.parseInt(req.getParameter("NoUtilisateur")),req.getParameter("pseudo"),
                req.getParameter("nom"),req.getParameter("prenom"),req.getParameter("mail"),req.getParameter("telephone"),
                req.getParameter("rue"),req.getParameter("codePostal"),req.getParameter("ville"),req.getParameter("motdepasse"));

        try {
            mgerCompte.update(util);
        } catch (BLLException e) {
            e.printStackTrace();
        }
        HttpSession session = req.getSession();
        session.setAttribute("utilisateur",util);

        req.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(req,resp);
    }

    protected void doModifier(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("modif","");
    }
}

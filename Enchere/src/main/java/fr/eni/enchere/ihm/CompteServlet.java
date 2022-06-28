package fr.eni.enchere.ihm;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/compte")
public class CompteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("modif","disabled");

        String action = req.getParameter("action");

        if ("modifier".equals(action)){
            doModifier(req, resp);
        }

        req.getRequestDispatcher("/WEB-INF/pages/compte.jsp").forward(req,resp);
    }

    protected void doModifier(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("modif","");
    }
}

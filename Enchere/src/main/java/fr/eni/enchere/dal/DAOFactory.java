package fr.eni.enchere.dal;

import fr.eni.enchere.dal.article.ArticleDAO;
import fr.eni.enchere.dal.article.ArticleDAOImpl;
import fr.eni.enchere.dal.enchere.EnchereDAO;
import fr.eni.enchere.dal.enchere.EnchereDAOImpl;
import fr.eni.enchere.dal.utilisateurs.UtilisateursDAO;
import fr.eni.enchere.dal.utilisateurs.UtilisateursDAOImpl;

public class DAOFactory {
    public static UtilisateursDAO getUtilisateursDAO(){
        return new UtilisateursDAOImpl();
    }

    public static ArticleDAO getArticleDAO(){
        return new ArticleDAOImpl();
    }

    public static EnchereDAO getEnchereDAO(){
        return new EnchereDAOImpl();
    }
}

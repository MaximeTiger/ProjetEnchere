package fr.eni.enchere.dal;

public class DAOFactory {
    public static UtilisateursDAO getUtilisateursDAO{
        return new UtilisateursDAOImpl();
    }
}

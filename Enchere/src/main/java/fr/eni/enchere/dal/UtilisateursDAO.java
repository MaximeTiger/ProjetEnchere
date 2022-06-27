package fr.eni.enchere.dal;

import fr.eni.enchere.bo.Utilisateurs;

public interface UtilisateursDAO {

    Utilisateurs selectInfosUser(String username, String password) throws DALException;
}

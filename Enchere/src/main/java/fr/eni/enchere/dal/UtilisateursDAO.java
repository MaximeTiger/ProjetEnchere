package fr.eni.enchere.dal;

import fr.eni.enchere.bo.Utilisateurs;

public interface UtilisateursDAO {
    void inscription(Utilisateurs u) throws DALException;

    Utilisateurs selectInfosUser(String pseudo, String motDePasse) throws DALException;
}

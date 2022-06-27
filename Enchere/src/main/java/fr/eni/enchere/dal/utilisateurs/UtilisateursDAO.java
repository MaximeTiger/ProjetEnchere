package fr.eni.enchere.dal.utilisateurs;

import fr.eni.enchere.bo.Utilisateurs;
import fr.eni.enchere.dal.DALException;

public interface UtilisateursDAO {
    void inscription(Utilisateurs u) throws DALException;

    Utilisateurs selectInfosUser(String pseudo, String motDePasse) throws DALException;
}

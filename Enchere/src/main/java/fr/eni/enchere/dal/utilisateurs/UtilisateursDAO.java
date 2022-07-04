package fr.eni.enchere.dal.utilisateurs;

import fr.eni.enchere.bo.Utilisateurs;
import fr.eni.enchere.dal.DALException;

public interface UtilisateursDAO {
    void inscription(Utilisateurs u) throws DALException;
    Utilisateurs selectInfosUser(String pseudo, String motDePasse) throws DALException;
    void update(Utilisateurs util) throws DALException;
    public Utilisateurs selectById(Integer id) throws DALException;

    void delete(int id) throws DALException;

}

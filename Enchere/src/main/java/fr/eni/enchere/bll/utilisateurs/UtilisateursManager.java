package fr.eni.enchere.bll.utilisateurs;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bo.Utilisateurs;
import fr.eni.enchere.dal.DALException;

public interface UtilisateursManager {
    void suscribe(Utilisateurs u) throws BLLException;
    Utilisateurs connexion(String pseudo, String motDePasse) throws  BLLException;
    void update(Utilisateurs util) throws BLLException;
    public Utilisateurs selectById(Integer id) throws BLLException;
    void supprimerCompte(int id) throws BLLException;
}

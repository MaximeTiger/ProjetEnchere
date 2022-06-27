package fr.eni.enchere.bll;

import fr.eni.enchere.bo.Utilisateurs;

public interface UtilisateursManager {
    void suscribe(Utilisateurs u) throws BLLException;
    void connexion(String pseudo, String motDePasse) throws  BLLException;
}

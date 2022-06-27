package fr.eni.enchere.bll.utilisateurs;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bll.utilisateurs.UtilisateursManager;
import fr.eni.enchere.bo.Utilisateurs;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.utilisateurs.UtilisateursDAO;

public class UtilisateursManagerImpl implements UtilisateursManager {

    private final UtilisateursDAO utilisateursDAO;

    public UtilisateursManagerImpl(){utilisateursDAO = DAOFactory.getUtilisateursDAO();}
    @Override
    public void suscribe(Utilisateurs u) throws BLLException {
        try {
            utilisateursDAO.inscription(u);
        }catch (DALException e){
            e.printStackTrace();
        }
    }

    @Override
    public Utilisateurs connexion(String pseudo, String motDePasse) throws BLLException {
        Utilisateurs util = null;
        try {
            util = utilisateursDAO.selectInfosUser(pseudo,motDePasse);
        }catch (DALException e){
            e.printStackTrace();
        }
        return util;
    }
}

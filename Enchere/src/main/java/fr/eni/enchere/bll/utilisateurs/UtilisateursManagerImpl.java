package fr.eni.enchere.bll.utilisateurs;

import fr.eni.enchere.bll.BLLException;
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
            throw new BLLException("erreur bll suscribe failed",e);
        }
    }

    @Override
    public Utilisateurs connexion(String pseudo, String motDePasse) throws BLLException {
        Utilisateurs util;
        System.out.println(pseudo);
        System.out.println(motDePasse);
        try {
            util = utilisateursDAO.selectInfosUser(pseudo,motDePasse);
            System.out.println(util);
        }catch (DALException e){
            throw new BLLException("erreur bll connexion failed",e);
        }
        return util;
    }

    @Override
    public void update(Utilisateurs util) throws BLLException {
        try {
            utilisateursDAO.update(util);
        } catch (DALException e) {
            throw new RuntimeException(e);
        }
    }
}

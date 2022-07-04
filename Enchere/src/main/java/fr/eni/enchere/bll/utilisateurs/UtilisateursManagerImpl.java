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
        try {
            util = utilisateursDAO.selectInfosUser(pseudo,motDePasse);
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

    @Override
    public Utilisateurs selectById(Integer id) throws BLLException {
        Utilisateurs user;
        try {
            user = utilisateursDAO.selectById(id);
        } catch (DALException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}

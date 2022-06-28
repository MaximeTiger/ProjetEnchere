package fr.eni.enchere.bll.retrait;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.retrait.RetraitDAO;

public class RetraitManagerImpl implements RetraitManager{

    //attributs
    private RetraitDAO retraitDAO;

    //constructeur pour instancier le data access object
    public RetraitManagerImpl() {
        retraitDAO= DAOFactory.getRetraitDAO();
    }

    @Override
    public void ajouterRetrait(Retrait r) throws BLLException {
        try {
            retraitDAO.insertRetrait(r);
        } catch (DALException e) {
            throw new BLLException("Erreur ajout retrait",e);
        }
    }


}

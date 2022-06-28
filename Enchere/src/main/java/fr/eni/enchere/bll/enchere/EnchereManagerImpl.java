package fr.eni.enchere.bll.enchere;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.enchere.EnchereDAO;
import fr.eni.enchere.dal.utilisateurs.UtilisateursDAO;

public class EnchereManagerImpl implements  EnchereManager{


    private final EnchereDAO enchereDAO;

    public EnchereManagerImpl(){enchereDAO = DAOFactory.getEnchereDAO();}

    @Override
    public Enchere afficherEnchere(Integer id) throws BLLException {
        Enchere enchere = null;
        try {
            enchere = enchereDAO.selectById(id);
        } catch (DALException e) {
            throw new RuntimeException(e);
        }
        return enchere;
    }
}

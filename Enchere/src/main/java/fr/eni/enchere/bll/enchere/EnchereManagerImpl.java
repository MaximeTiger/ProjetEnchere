package fr.eni.enchere.bll.enchere;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.enchere.EnchereDAO;

public class EnchereManagerImpl implements  EnchereManager{


    private final EnchereDAO enchereDAO;

    public EnchereManagerImpl(){enchereDAO = DAOFactory.getEnchereDAO();}

    @Override
    public Enchere afficherEnchere(Integer id) throws BLLException {
        Enchere enchere;
        try {
            enchere = enchereDAO.selectById(id);
        } catch (DALException e) {
            throw new BLLException("erreur BLL affichage enchère",e);
        }
        return enchere;
    }

}

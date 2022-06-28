package fr.eni.enchere.bll.enchere;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.DALException;

public interface EnchereManager {

    Enchere afficherEnchere(Integer id) throws BLLException;

}

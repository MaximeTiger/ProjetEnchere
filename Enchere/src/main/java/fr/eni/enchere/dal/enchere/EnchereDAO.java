package fr.eni.enchere.dal.enchere;

import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.DALException;

public interface EnchereDAO {
    Enchere selectById(Integer id) throws DALException;
}

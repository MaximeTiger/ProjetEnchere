package fr.eni.enchere.dal;

import fr.eni.enchere.bo.Enchere;

public interface EnchereDAO {
    Enchere selectById(Integer id) throws DALException;
}

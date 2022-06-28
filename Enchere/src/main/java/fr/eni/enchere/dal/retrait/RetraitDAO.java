package fr.eni.enchere.dal.retrait;

import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.DALException;

public interface RetraitDAO {
    void insertRetrait(Retrait r) throws DALException;

}

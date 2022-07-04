package fr.eni.enchere.dal.categorie;

import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.DALException;

import java.util.List;

public interface CategorieDAO {
    Categorie selectById(Integer id) throws DALException;
    public List<String> selectName() throws DALException;
}

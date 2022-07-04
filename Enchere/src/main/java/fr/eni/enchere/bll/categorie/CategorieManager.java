package fr.eni.enchere.bll.categorie;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bo.Categorie;

import java.util.List;

public interface CategorieManager {
    Categorie afficherLibelle(Integer id) throws BLLException;
    List<String> selectName() throws BLLException;
}

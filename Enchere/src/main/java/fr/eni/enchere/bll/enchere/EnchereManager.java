package fr.eni.enchere.bll.enchere;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.DALException;

import java.util.List;

public interface EnchereManager {

    Enchere afficherEnchere(Integer id) throws BLLException;
    List<Enchere> enchereEnCours() throws  BLLException;
    List<Enchere> enchereParArticle(String nomArt) throws BLLException;
}

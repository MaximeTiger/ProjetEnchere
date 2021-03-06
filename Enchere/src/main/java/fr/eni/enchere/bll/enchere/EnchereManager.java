package fr.eni.enchere.bll.enchere;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.DALException;

import java.util.List;

public interface EnchereManager {

    Enchere afficherEnchere(Integer id) throws BLLException;
    List<Enchere> enchereEnCours() throws  BLLException;
    List<Enchere> enchereParCategorie(String libelle) throws BLLException;
    void faireEnchere (Enchere enchere) throws  BLLException;
    Enchere selectMaxEnchere(Integer no_article) throws BLLException;
    Enchere selectByArticle(Integer id) throws BLLException;

}

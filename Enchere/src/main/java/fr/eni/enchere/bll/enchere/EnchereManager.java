package fr.eni.enchere.bll.enchere;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bo.Enchere;

import java.util.List;

public interface EnchereManager {

    Enchere afficherEnchere(Integer id) throws BLLException;
    List<Enchere> enchereEnCours() throws  BLLException;
    List<Enchere> enchereParArticle(String nomArt) throws BLLException;
    List<Enchere> enchereParCategorie(String libelle) throws BLLException;
    void faireEnchere (Enchere enchere) throws  BLLException;

}

package fr.eni.enchere.bll.enchere;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.enchere.EnchereDAO;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Enchere> enchereEnCours() throws BLLException {
        List<Enchere> liste = new ArrayList<>();
        try {
            liste = enchereDAO.selectAll();
        } catch (DALException e) {
            throw new BLLException("erreur BLL affichage liste d'enchères",e);
        }
        return liste;
    }

    @Override
    public List<Enchere> enchereParArticle(String nomArt) throws BLLException {
        List<Enchere> liste = new ArrayList<>();
        try {
            liste = enchereDAO.selectByNomArticle(nomArt);
        } catch (DALException e) {
            throw new BLLException("erreur BLL recherche par nom article",e);
        }
        return liste;
    }

    @Override
    public List<Enchere> enchereParCategorie(String libelle) throws BLLException {
        List<Enchere> liste = new ArrayList<>();
        try {
            liste = enchereDAO.selectByCategorie(libelle);
        } catch (DALException e) {
            throw new BLLException("erreur BLL recherche par nom article",e);
        }
        return liste;    }

    @Override
    public void faireEnchere(Enchere enchere) throws BLLException {
        try {
            enchereDAO.insertEnchere(enchere);
        } catch (DALException e) {
            throw new BLLException("erreur BLL insert de l'enchère",e);
        }
    }

    @Override
    public Enchere selectMaxEnchere(Integer no_article) throws BLLException {
        Enchere enchere;
        try {
            enchere = enchereDAO.selectMaxEnchere(no_article);
        } catch (DALException e) {
            throw new RuntimeException(e);
        }
        return enchere;
    }


}

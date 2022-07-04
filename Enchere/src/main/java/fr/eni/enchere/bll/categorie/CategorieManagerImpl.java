package fr.eni.enchere.bll.categorie;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.categorie.CategorieDAO;

import java.util.ArrayList;
import java.util.List;

public class CategorieManagerImpl implements CategorieManager{
    //attributs
    private final CategorieDAO categorieDAO;

    //constructeur pour instancier le data access object
    public CategorieManagerImpl() {
        categorieDAO= DAOFactory.getCategorieDAO();
    }

    @Override
    public Categorie afficherLibelle(Integer id) throws BLLException {
        Categorie categorie;
        try {
            categorie = categorieDAO.selectById(id);
        } catch (DALException e) {
            throw new BLLException("echec affichage catégorie", e);
        }
        return categorie;
    }

    public List<String> selectName() throws BLLException{
        List<String> nomLabelle = new ArrayList<>();
        try {
            nomLabelle = categorieDAO.selectName();
        } catch (DALException e) {
            throw new RuntimeException(e);
        }
        return nomLabelle;
    }
}

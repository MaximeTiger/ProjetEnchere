package fr.eni.enchere.dal.enchere;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.DALException;

import java.util.List;

public interface EnchereDAO {
    Enchere selectById(Integer id) throws DALException;
    List<Enchere> selectAll() throws DALException;
    List<Enchere> selectByCategorie(String libelle) throws DALException;
    void insertEnchere(Enchere enchere) throws  DALException;
    Enchere selectMaxEnchere(Integer no_article) throws DALException;
    Enchere selectByArticle(Integer id) throws DALException;

}

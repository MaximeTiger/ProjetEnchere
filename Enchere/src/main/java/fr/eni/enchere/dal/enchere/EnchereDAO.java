package fr.eni.enchere.dal.enchere;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.DALException;

import java.util.List;

public interface EnchereDAO {
    Enchere selectById(Integer id) throws DALException;
    List<Enchere> selectAll() throws DALException;
   /* Enchere selectByCategorie(Categorie cat) throws DALException;
    Enchere selectByNomArticle(Article art) throws DALException;*/

}

package fr.eni.enchere.dal.enchere;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.DALException;

import java.util.List;

public interface EnchereDAO {
    Enchere selectById(Integer id) throws DALException;
    List<Enchere> selectAll() throws DALException;

    /* je ne sais pas encore comment faire *Bryan
        @Override
         public List<Enchere> selectByCategorie(Categorie cat) throws DALException {
             return null;
         }
     */
    List<Enchere> selectByNomArticle(Article art) throws DALException;
   /* List<Enchere> selectByCategorie(Categorie cat) throws DALException;
    List<Enchere> selectByNomArticle(Article art) throws DALException;*/

}

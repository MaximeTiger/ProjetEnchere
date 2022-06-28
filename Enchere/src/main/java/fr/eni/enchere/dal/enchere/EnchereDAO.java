package fr.eni.enchere.dal.enchere;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.DALException;

import java.util.List;

public interface EnchereDAO {
    Enchere selectById(Integer id) throws DALException;
    List<Enchere> selectAll() throws DALException;
    List<Enchere> selectByNomArticle(String nomArt) throws DALException;

    /* je ne sais pas encore comment faire *Bryan
        @Override
         public List<Enchere> selectByCategorie(Categorie cat) throws DALException {
             return null;
         }
     */

    /* je ne sais pas encore comment faire *Bryan
        @Override
         public List<Enchere> selectByCategorie(Categorie cat) throws DALException {
             return null;
         }
     */
    /* List<Enchere> selectByCategorie(Categorie cat) throws DALException;*/

}

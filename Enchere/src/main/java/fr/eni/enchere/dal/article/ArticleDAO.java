package fr.eni.enchere.dal.article;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.DALException;

public interface ArticleDAO {
    void insertUnArticle(Article a) throws DALException;
    Article selectByNomArticle(String nomArticle) throws DALException;
}

package fr.eni.enchere.dal.article;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.DALException;

import java.util.List;

public interface ArticleDAO {
    void insertUnArticle(Article a) throws DALException;
    Article selectById(int noArticle) throws DALException;
    List<Article> selectAll() throws DALException;
}

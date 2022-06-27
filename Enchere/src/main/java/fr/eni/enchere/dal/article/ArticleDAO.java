package fr.eni.enchere.dal.article;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.DALException;

public interface ArticleDAO {
    public void vendreUnArticle (Article a) throws DALException;
}

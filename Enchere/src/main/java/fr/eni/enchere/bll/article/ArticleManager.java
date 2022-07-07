package fr.eni.enchere.bll.article;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.DALException;

import java.util.List;

public interface ArticleManager {
    //ajouter un article
    void ajouterUnArticle(Article a) throws BLLException;

    Article afficherUnArticle(int noArticle) throws BLLException;
    List<Article> selectAll() throws BLLException;

    }

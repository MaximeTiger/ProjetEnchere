package fr.eni.enchere.bll.article;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bo.Article;

public interface ArticleManager {
    //ajouter un article
    void ajouterUnArticle(Article a) throws BLLException;

    Article afficherUnArticle(String nomArticle) throws BLLException;


}

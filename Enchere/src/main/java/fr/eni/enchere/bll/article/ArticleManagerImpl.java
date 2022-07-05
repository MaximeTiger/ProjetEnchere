package fr.eni.enchere.bll.article;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.article.ArticleDAO;

public class ArticleManagerImpl implements ArticleManager{

    //attributs
    private final ArticleDAO articleDAO;

    //constructeur pour instancier le data access object
    public ArticleManagerImpl() {
        articleDAO= DAOFactory.getArticleDAO();
    }

    //ajouter un article
    @Override
    public void ajouterUnArticle(Article a) throws BLLException {
        try {
            articleDAO.insertUnArticle(a);
        } catch (DALException e) {
            throw new BLLException("Erreur ajout article",e);
        }
    }

    @Override
    public Article afficherUnArticle(int noArticle) throws BLLException {
        Article a = null;
        try {
            a = articleDAO.selectById(noArticle);
        } catch (DALException e) {
            e.printStackTrace();
        }
        return a;
    }
}

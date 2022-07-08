package fr.eni.enchere.bll.article;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.DAOFactory;
import fr.eni.enchere.dal.article.ArticleDAO;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Article> selectAll() throws BLLException {
        List<Article> listeArticle = new ArrayList<>();
        try {
            listeArticle = articleDAO.selectAll();
        } catch (DALException e) {
            e.printStackTrace();
        }
        return listeArticle;
    }

    @Override
    public Article selectId(String nomArticle, String description, int noUtil, int noCat) throws BLLException {
        Article art = null;
        try {
            art = articleDAO.selectId(nomArticle,description,noUtil,noCat);
        } catch (DALException e) {
            e.printStackTrace();
        }
        return art;
    }
}

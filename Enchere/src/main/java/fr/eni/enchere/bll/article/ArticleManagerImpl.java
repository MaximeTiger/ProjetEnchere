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
        Article a;
        try {
            a = articleDAO.selectById(noArticle);
        } catch (DALException e) {
            throw new RuntimeException(e);
        }
        return a;
    }

    //Valider un article
    public void validerUnArticle (Article article) throws BLLException {
        StringBuilder message = new StringBuilder() ;

        if (article.getNomArticle() == null) {
            try {
                articleDAO.insertUnArticle(article);
                if(article.getNomArticle() == null || article.getNomArticle().isBlank()){
                    message.append(" Erreur nom obligatoire");
                }
                if(article.getDescription() == null || article.getDescription().isBlank()){
                    message.append(" Erreur description obligatoire");
                }
                if(article.getLibelle() == null || article.getLibelle().isBlank())  {
                    message.append(" Erreur catégorie obligatoire");
                }
                if(article.getPrixInitial() <= 0) {
                    message.append(" Erreur prix unitaire doit Ãªtre positif");
                }
                if(article.getPrixVente() <= 0) {
                    message.append(" Erreur prix de vente doit Ãªtre positif");
                }
            }catch(DALException e){
                throw new BLLException("Enregistrer l'article :" + article, e);
            }
        }
    }
}

package fr.eni.enchere.bll;

import fr.eni.enchere.bll.article.ArticleManager;
import fr.eni.enchere.bll.article.ArticleManagerImpl;
import fr.eni.enchere.bll.categorie.CategorieManager;
import fr.eni.enchere.bll.categorie.CategorieManagerImpl;
import fr.eni.enchere.bll.enchere.EnchereManager;
import fr.eni.enchere.bll.enchere.EnchereManagerImpl;
import fr.eni.enchere.bll.retrait.RetraitManager;
import fr.eni.enchere.bll.retrait.RetraitManagerImpl;
import fr.eni.enchere.bll.utilisateurs.UtilisateursManager;
import fr.eni.enchere.bll.utilisateurs.UtilisateursManagerImpl;

public class BLLFactory {
    public static UtilisateursManager getUtilisateursManager() {return new UtilisateursManagerImpl();}
    public static ArticleManager getArticleManager(){return new ArticleManagerImpl();}
    public static CategorieManager getCategorieManager(){return new CategorieManagerImpl();}
    public static RetraitManager getRetraitManager(){return new RetraitManagerImpl();}
    public static EnchereManager getEnchereManager() {return new EnchereManagerImpl();}

}

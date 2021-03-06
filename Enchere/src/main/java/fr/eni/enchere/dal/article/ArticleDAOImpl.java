package fr.eni.enchere.dal.article;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.ConnectionProvider;
import fr.eni.enchere.dal.DALException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAOImpl implements ArticleDAO {

    private static final String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article,description,no_categorie,date_debut_encheres," +
            "date_fin_encheres,prix_initial,no_utilisateur)"+
        "VALUES (?,?,?,?,?,?,?)";

    private static final String SELECT_BY_ID = "SELECT ARTICLES_VENDUS.nom_article,ARTICLES_VENDUS.description,\n" +
            "CATEGORIES.libelle,ARTICLES_VENDUS.prix_initial,ARTICLES_VENDUS.date_fin_encheres,\n" +
            "RETRAITS.rue,RETRAITS.code_postal,RETRAITS.ville,UTILISATEURS.pseudo\n" +
            "FROM ARTICLES_VENDUS,RETRAITS,CATEGORIES,UTILISATEURS\n" +
            "WHERE ARTICLES_VENDUS.no_article = ?\n" +
            "AND RETRAITS.no_article=ARTICLES_VENDUS.no_article\n" +
            "AND CATEGORIES.no_categorie=ARTICLES_VENDUS.no_categorie\n" +
            "AND UTILISATEURS.no_utilisateur = ARTICLES_VENDUS.no_utilisateur";

    private static final String SELECT_ALL = "SELECT ARTICLES_VENDUS.*\n" +
            "FROM ARTICLES_VENDUS";

    private static final String SELECT_ID = "SELECT no_article from ARTICLES_VENDUS " +
            "where nom_article = ?\n" +
            "AND description = ? and no_utilisateur = ? and no_categorie = ?";


    public void insertUnArticle (Article a) throws DALException {

        try (Connection conn = ConnectionProvider.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setString(1,a.getNomArticle());
            stmt.setString(2,a.getDescription());
            stmt.setInt(3, a.getNoCategorie());
            stmt.setObject(4, Date.valueOf(a.getDebutEncheres()));
            stmt.setObject(5, Date.valueOf(a.getFinEncheres()));
            stmt.setInt(6,a.getPrixInitial());
            stmt.setInt(7, a.getNoUtilisateur());

            System.out.println("no art a : " + a.getNomArticle());
            System.out.println("desc a : " + a.getDescription());
            System.out.println("no cat a : " + a.getNoCategorie());
            System.out.println("debut ench a : " + a.getDebutEncheres());
            System.out.println("fin ench a : " + a.getFinEncheres());
            System.out.println("prix init a : " + a.getPrixInitial());
            System.out.println("no util a : " + a.getNoUtilisateur());

            stmt.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Article selectById(int noArticle) throws DALException {

        Article art = null;

        try (Connection conn = ConnectionProvider.getConnection()) {

            PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);

            stmt.setInt(1,noArticle);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                art = new Article(
                        rs.getString("nom_article"),
                        rs.getString("description"),
                        rs.getString("libelle"),
                        rs.getInt("prix_initial"),
                        rs.getDate("date_fin_encheres"),
                        rs.getString("rue"),
                        rs.getString("code_postal"),
                        rs.getString("ville"),
                        rs.getString("pseudo")
                        );
            }
        }

        //message d'erreur si un probl??me est rencontr??
        catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new DALException("Erreur a la selection d'un article");
        }
        return art;
    }

    @Override
    public Article selectId(String nomArticle,String description, int noUtil, int noCat) throws DALException {

        Article art = null;

        try (Connection conn = ConnectionProvider.getConnection()) {

            PreparedStatement stmt = conn.prepareStatement(SELECT_ID);

            stmt.setString(1,nomArticle);
            stmt.setString(2,description);
            stmt.setInt(3,noUtil);
            stmt.setInt(4,noCat);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                art = new Article(
                        rs.getInt("no_article")
                        );
            }
        }

        //message d'erreur si un probl??me est rencontr??
        catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new DALException("Erreur a la selection d'un article");
        }
        return art;
    }
    
    public List<Article> selectAll() throws DALException{
        List<Article> listeArticle = new ArrayList<>();
        
        try(Connection conn = ConnectionProvider.getConnection()) {

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);

            while (rs.next()) {
                Article article = new Article(
                        rs.getInt("no_article"),
                        rs.getString("nom_article"),
                        rs.getString("description"),
                        rs.getDate("date_debut_encheres"),
                        rs.getDate("date_fin_encheres"),
                        rs.getInt("prix_initial"),
                        rs.getInt("prix_vente"),
                        rs.getInt("no_utilisateur"),
                        rs.getInt("no_categorie")
                );
                listeArticle.add(article);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new DALException("Erreur dal a la selection des articles");
        }
        return listeArticle;
    }
    
}

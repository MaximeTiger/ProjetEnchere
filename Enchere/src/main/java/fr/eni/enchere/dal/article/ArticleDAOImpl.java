package fr.eni.enchere.dal.article;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.ConnectionProvider;
import fr.eni.enchere.dal.DALException;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class ArticleDAOImpl implements ArticleDAO {

    private static final String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente)"+
        "VALUES (?,?,?,?,?,?)";

    private static final String SELECT_BY_ID = "SELECT ARTICLES_VENDUS.nom_article,ARTICLES_VENDUS.description,\n" +
            "       CATEGORIES.libelle,ARTICLES_VENDUS.prix_vente,ARTICLES_VENDUS.date_fin_encheres,\n" +
            "       RETRAITS.rue,RETRAITS.code_postal,RETRAITS.ville,UTILISATEURS.pseudo\n" +
            "FROM ARTICLES_VENDUS,RETRAITS,CATEGORIES,UTILISATEURS\n" +
            "WHERE ARTICLES_VENDUS.no_article = ?\n" +
            "  AND RETRAITS.no_article=ARTICLES_VENDUS.no_article\n" +
            "  AND CATEGORIES.no_categorie=ARTICLES_VENDUS.no_categorie\n" +
            "AND UTILISATEURS.no_utilisateur = ARTICLES_VENDUS.no_utilisateur";


    public void insertUnArticle (Article a) throws DALException {

        try (Connection conn = ConnectionProvider.getConnection()){
            PreparedStatement stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setString(1,a.getNomArticle());
            stmt.setString(2,a.getDescription());
            stmt.setObject(3, Date.valueOf(a.getDebutEncheres()));
            stmt.setObject(4, Date.valueOf(a.getFinEncheres()));
            stmt.setInt(5,a.getPrixInitial());
            stmt.setInt(6,a.getPrixVente());

            stmt.executeQuery();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                a.setNoArticle(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Article selectById(int noArticle) throws DALException {

        Article art = null;

        try (Connection conn = ConnectionProvider.getConnection()) {

            PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);

            System.out.println(noArticle);

            stmt.setInt(1,noArticle);

            ResultSet rs = stmt.executeQuery();


            if (rs.next()) {
                art = new Article(
                        rs.getString("nom_article"),
                        rs.getString("description"),
                        rs.getString("libelle"),
                        rs.getInt("prix_vente"),
                        rs.getDate("date_fin_encheres"),
                        rs.getString("rue"),
                        rs.getString("code_postal"),
                        rs.getString("ville"),
                        rs.getString("pseudo")
                        );
            }
        }

        //message d'erreur si un problème est rencontré
        catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new DALException("Erreur a la selection d'un article");
        }
        return art;
    }
    
}

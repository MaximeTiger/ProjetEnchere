package fr.eni.enchere.dal.article;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.dal.ConnectionProvider;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.article.ArticleDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleDAOImpl implements ArticleDAO {

    private static final String INSERT = "INSERT INTO ARTICLES_VENDUS (nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente)"+
        "VALUES (?,?,?,?,?,?)";


    public void insertUnArticle (Article a) throws DALException {

        try (Connection conn = ConnectionProvider.getConnection();){
            PreparedStatement stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

            stmt.setString(1,a.getNomArticle());
            stmt.setString(2,a.getDescription());
            stmt.setDate(3,a.getDebutEncheres());
            stmt.setDate(4,a.getFinEncheres());
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
    public Article select() throws DALException {

        return null;
    }
}

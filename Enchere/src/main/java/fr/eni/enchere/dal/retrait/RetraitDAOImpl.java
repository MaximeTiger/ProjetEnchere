package fr.eni.enchere.dal.retrait;

import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.ConnectionProvider;
import fr.eni.enchere.dal.DALException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetraitDAOImpl implements RetraitDAO{

    private static final String INSERT = "INSERT INTO RETRAITS (no_article,rue,code_postal,ville) VALUES (?,?,?,?)";

    private static final String SELECT_BY_NO_ARTICLE = "SELECT ARTICLES_VENDUS.no_article, RETRAITS.no_article, RETRAITS.rue, RETRAITS.code_postal, RETRAITS.ville "
            +"FROM ARTICLES_VENDUS, RETRAITS WHERE no_article = ?";
    public void insertRetrait(Retrait r) throws DALException {

        try(Connection conn = ConnectionProvider.getConnection()){

            //Faire l'insert
            PreparedStatement stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

            //Valoriser les parametres
            stmt.setInt(1,r.getNoArticle());
            stmt.setString(2,r.getRue());
            stmt.setString(3,r.getCodePostal());
            stmt.setString(4,r.getVille());

            //Executer la requete
            stmt.executeQuery();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Retrait selectByNoArticle(Integer noArticle){

        Retrait retrait = null;

        try (Connection conn = ConnectionProvider.getConnection()){

            PreparedStatement stmt = conn.prepareStatement(SELECT_BY_NO_ARTICLE);
            stmt.setInt(1,noArticle);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                retrait = new Retrait(
                        rs.getString("rue"),
                        rs.getString("code_postal"),
                        rs.getString("ville")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return retrait;
    }

}

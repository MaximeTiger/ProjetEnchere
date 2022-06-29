package fr.eni.enchere.dal.retrait;

import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.ConnectionProvider;
import fr.eni.enchere.dal.DALException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetraitDAOImpl implements RetraitDAO{

    private static final String INSERT = "INSERT INTO RETRAITS (rue,code_postal,ville) VALUES (?,?,?)";

    private static final String SELECT_BY_NOM_ARTICLE = "SELECT ARTICLES_VENDUS.nom_article, RETRAITS.no_article, RETRAITS.rue, RETRAITS.code_postal, RETRAITS.ville "
            +"FROM ARTICLES_VENDUS, RETRAITS WHERE nom_article=?";
    public void insertRetrait(Retrait r) throws DALException {
        Retrait retrait = null;

        try(Connection conn = ConnectionProvider.getConnection()){

            //Faire l'insert
            PreparedStatement stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

            //Valoriser les parametres
            stmt.setString(1,r.getRue());
            stmt.setString(2,r.getCodePostal());
            stmt.setString(3,r.getVille());


            //Executer la requete
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                r.setNomArticle(rs.getString(1));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Retrait selectByNomArticle(String nomArticle){

        Retrait retrait = null;

        try (Connection conn = ConnectionProvider.getConnection();){

            PreparedStatement stmt = conn.prepareStatement(SELECT_BY_NOM_ARTICLE);
            stmt.setString(1,nomArticle);

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

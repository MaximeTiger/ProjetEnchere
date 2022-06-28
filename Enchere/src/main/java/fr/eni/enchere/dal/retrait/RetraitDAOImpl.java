package fr.eni.enchere.dal.retrait;

import fr.eni.enchere.bo.Retrait;
import fr.eni.enchere.dal.ConnectionProvider;
import fr.eni.enchere.dal.DALException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetraitDAOImpl implements RetraitDAO{

    private static final String INSERT = "INSERT INTO RETRAITS (rue,code_postal,ville) VALUES (?,?,?)";

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
            stmt.executeQuery();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                r.setNomArticle(rs.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

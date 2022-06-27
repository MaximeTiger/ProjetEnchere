package fr.eni.enchere.dal;

import fr.eni.enchere.bo.Enchere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnchereDAOImpl implements EnchereDAO {

    private static final String SELECT_BY_ID = "SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur " +
            "FROM ENCHERES WHERE no_enchere= ?";

    @Override
    public Enchere selectById(Integer id) throws DALException {

        Enchere ench = null;
        try(Connection conn = ConnectionProvider.getConnection()) {

            PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);

            stmt.setInt(1,id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                ench = new Enchere(
                        rs.getInt("no_enchere"),
                        rs.getDate("date_enchere"),
                        rs.getInt("montant_enchere"),
                        rs.getInt("no_article"),
                        rs.getInt("no_utilisateur")
                );
            }
        }

        catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new DALException("Erreur a la selection d'une enchère");
        }
        return ench;
    }
}

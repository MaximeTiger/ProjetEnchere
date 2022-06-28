package fr.eni.enchere.dal.categorie;

import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.dal.ConnectionProvider;
import fr.eni.enchere.dal.DALException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategorieDAOImpl implements CategorieDAO {

    private static final String SELECT_BY_ID = "SELECT libelle " +
            "FROM CATEGORIES WHERE no_categorie= ?";

    @Override
    public Categorie selectById(Integer id) throws DALException {

        Categorie cat = null;
        try (Connection conn = ConnectionProvider.getConnection()) {

            PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                cat = new Categorie(
                        rs.getString("libelle")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new DALException("Erreur a la selection d'une enchère");
        }
        return cat;
    }
}

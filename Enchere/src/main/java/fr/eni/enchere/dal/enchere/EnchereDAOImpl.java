package fr.eni.enchere.dal.enchere;

import fr.eni.enchere.bo.Article;
import fr.eni.enchere.bo.Categorie;
import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.ConnectionProvider;
import fr.eni.enchere.dal.DALException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EnchereDAOImpl implements EnchereDAO {

    private static final String SELECT_BY_ID = "SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur " +
            "FROM ENCHERES WHERE no_enchere= ?";

    private static final String SELECT_ALL = "SELECT no_enchere, date_enchere, montant_enchere, no_article, no_utilisateur FROM ENCHERES";

    private static final String SELECT_BY_CATEGORIE = "SELECT ARTICLES_VENDUS.nom_article,ENCHERES.date_enchere,ENCHERES.montant_enchere," +
            "UTILISATEURS.nom FROM ENCHERES,ARTICLES_VENDUS,UTILISATEURS,CATEGORIES " +
            "WHERE libelle=?";

    private static final String SELECT_BY_NOM_ARTICLE = "SELECT ARTICLES_VENDUS.nom_article,ENCHERES.date_enchere,ENCHERES.montant_enchere," +
            "UTILISATEURS.nom FROM ENCHERES,ARTICLES_VENDUS,UTILISATEURS " +
            "WHERE nom_article=?";

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

    @Override
    public List<Enchere> selectAll() throws DALException {
        List<Enchere> listEnchere = new ArrayList<>();
        try (
                //Try with resources
                Connection conn = ConnectionProvider.getConnection()
        )
        {

            //Executer la requete
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);

            while (rs.next()){
                //Créer l'enchère
                Enchere enchere = new Enchere(rs.getInt("no_enchere"),
                        rs.getDate("date_enchere"),
                        rs.getInt("montant_enchere"),
                        rs.getInt("no_article"),
                        rs.getInt("no_utilisateur")
                );
                //Ajoute l'enchère à la liste
                listEnchere.add(enchere);
            }

        }

        //message d'erreur si un problème est rencontré
        catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new DALException("Erreur dal a la selection des encheres");
        }
        return listEnchere;
    }

   /* je ne sais pas encore comment faire *Bryan
   @Override
    public Enchere selectByCategorie(Categorie cat) throws DALException {
        return null;
    }

    @Override
    public Enchere selectByNomArticle(Article art) throws DALException {
        return null;
    }*/
}

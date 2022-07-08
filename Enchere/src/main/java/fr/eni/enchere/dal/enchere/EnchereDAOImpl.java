package fr.eni.enchere.dal.enchere;

import fr.eni.enchere.bo.Enchere;
import fr.eni.enchere.dal.ConnectionProvider;
import fr.eni.enchere.dal.DALException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnchereDAOImpl implements EnchereDAO {

    private static final String SELECT_BY_ID = "SELECT ENCHERES.no_enchere, ENCHERES.date_enchere, " +
            "ENCHERES.montant_enchere, ARTICLES_VENDUS.nom_article, UTILISATEURS.nom " +
            "FROM ENCHERES,ARTICLES_VENDUS,UTILISATEURS WHERE no_enchere= ?";

    private static final String SELECT_ALL = "SELECT ENCHERES.no_enchere, ENCHERES.date_enchere," +
            "ENCHERES.montant_enchere,UTILISATEURS.nom, ARTICLES_VENDUS.nom_article, ENCHERES.no_article " +
            "FROM ENCHERES,ARTICLES_VENDUS,UTILISATEURS " +
            "WHERE UTILISATEURS.no_utilisateur = ENCHERES.no_utilisateur AND ARTICLES_VENDUS.no_article = ENCHERES.no_article";

    private static final String SELECT_BY_NOM_ARTICLE = "SELECT ENCHERES.no_enchere, ENCHERES.date_enchere, " +
            "ENCHERES.montant_enchere, ARTICLES_VENDUS.nom_article, UTILISATEURS.nom " +
            "FROM ENCHERES,ARTICLES_VENDUS, UTILISATEURS WHERE nom_article=?";

    private static final String SELECT_BY_CATEGORIE = "SELECT ENCHERES.no_enchere, ENCHERES.date_enchere, " +
            "ENCHERES.montant_enchere, ARTICLES_VENDUS.nom_article, UTILISATEURS.nom, CATEGORIES.libelle " +
            "FROM ENCHERES,ARTICLES_VENDUS,UTILISATEURS,CATEGORIES WHERE libelle=?";

    private static final String INSERT = "INSERT INTO ENCHERES (date_enchere, montant_enchere, no_article, no_utilisateur) " +
            "VALUES (?,?,?,?)";

    private static final String SELECT_BY_ID_LAST_ENCHERE = "select * from ENCHERES where no_article = ? order by montant_enchere desc";

    private static final String SELECT_BY_ARTICLE = "SELECT * FROM ENCHERES WHERE no_article = ?";
    @Override
    public Enchere selectById(Integer id) throws DALException {

        Enchere ench = null;
        try(
                Connection conn = ConnectionProvider.getConnection()
        ) {

            PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID);

            stmt.setInt(1,id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                ench = new Enchere(
                        rs.getInt("no_enchere"),
                        rs.getObject("date_enchere",LocalDate.class),
                        rs.getInt("montant_enchere"),
                        rs.getString("nom_article"),
                        rs.getString("nom")
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

        List<Enchere> listeEnchere = new ArrayList<>();

        try (Connection conn = ConnectionProvider.getConnection())
        {

            //Executer la requete
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);

            while (rs.next()){
                //Créer l'enchère
                Enchere enchere = new Enchere(
                        rs.getInt("no_enchere"),
                        rs.getObject("date_enchere", LocalDate.class),
                        rs.getInt("montant_enchere"),
                        rs.getString("nom"),
                        rs.getString("nom_article"),
                        rs.getInt("no_article")
                        );
                //Ajoute l'enchère à la liste
                listeEnchere.add(enchere);
            }

        }

        //message d'erreur si un problème est rencontré
        catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new DALException("Erreur dal a la selection des encheres");
        }
        return listeEnchere;
    }

   @Override
    public List<Enchere> selectByCategorie(String libelle) throws DALException {

       List<Enchere> listeEnchere = new ArrayList<>();

       try(
               Connection conn = ConnectionProvider.getConnection()
       ) {

           PreparedStatement stmt = conn.prepareStatement(SELECT_BY_CATEGORIE);

           stmt.setString(1,libelle);

           ResultSet rs = stmt.executeQuery();

           while (rs.next()){
               //Créer l'enchère
               Enchere enchere = new Enchere(
                       rs.getInt("no_enchere"),
                       rs.getObject("date_enchere",LocalDate.class),
                       rs.getInt("montant_enchere"),
                       rs.getString("nom_article"),
                       rs.getString("nom")
               );
               //Ajoute l'enchère à la liste
               listeEnchere.add(enchere);
           }
       }

       catch (SQLException e) {
           System.out.println(e.getMessage());
           throw new DALException("Erreur dal a la recherche d'une enchère");
       }
       return listeEnchere;
   }

    @Override
    public void insertEnchere(Enchere enchere) throws DALException {
        try (
                //Try with resources
                Connection conn = ConnectionProvider.getConnection()
        )
        {

            //Faire l'insert
            PreparedStatement stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

            //Valoriser les parametres
            stmt.setDate(1,Date.valueOf(enchere.getDateEnchere()));
            stmt.setInt(2,enchere.getMontantEnchere());
            stmt.setInt(3,enchere.getNoUtilisateur());
            stmt.setInt(4,enchere.getNoArticle());

            System.out.println("date enchere : " + enchere.getDateEnchere());
            System.out.println("montant enchere : " + enchere.getMontantEnchere());
            System.out.println("noArt enchere : " + enchere.getNoArticle());
            System.out.println("noUtil enchere : " + enchere.getNoUtilisateur());

            //Executer la requete
            stmt.executeQuery();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
                enchere.setNoEnchere(rs.getInt(1));
            }
        }
        catch (SQLException e) {
            throw new DALException("Erreur insert ", e);
        }
    }

    @Override
    public Enchere selectMaxEnchere(Integer no_article) throws DALException {

        Enchere ench = null;
        try(
                Connection conn = ConnectionProvider.getConnection()
        ) {

            PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID_LAST_ENCHERE);

            stmt.setInt(1,no_article);

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
    public Enchere selectByArticle(Integer id) throws DALException {

        Enchere ench = null;
        try(
                Connection conn = ConnectionProvider.getConnection()
        ) {

            PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ARTICLE);

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

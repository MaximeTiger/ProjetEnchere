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
            "ENCHERES.montant_enchere, ARTICLES_VENDUS.nom_article,UTILISATEURS.nom " +
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
                Enchere enchere = new Enchere(
                        rs.getInt("no_enchere"),
                        rs.getObject("date_enchere",LocalDate.class),
                        rs.getInt("montant_enchere"),
                        rs.getString("nom"),
                        rs.getString("nom_article")
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
            stmt.setString(2, String.valueOf(enchere.getMontantEnchere()));
            stmt.setString(3, String.valueOf(enchere.getArticle().getNoArticle()));
            stmt.setString(4, String.valueOf(enchere.getUtilisateurs().getNoUtilisateur()));

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
    public List<Enchere> selectByNomArticle(String nomArt) throws DALException {

        List<Enchere> listeEnchere = new ArrayList<>();

        try(
                Connection conn = ConnectionProvider.getConnection()
        ) {

            PreparedStatement stmt = conn.prepareStatement(SELECT_BY_NOM_ARTICLE);

            stmt.setString(1,nomArt);

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
}

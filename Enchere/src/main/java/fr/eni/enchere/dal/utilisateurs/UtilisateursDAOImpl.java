package fr.eni.enchere.dal.utilisateurs;

import fr.eni.enchere.bo.Utilisateurs;
import fr.eni.enchere.dal.ConnectionProvider;
import fr.eni.enchere.dal.DALException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class  UtilisateursDAOImpl implements UtilisateursDAO {

    private static final String SELECT_INFOS_USER = "SELECT * FROM UTILISATEURS WHERE pseudo = ? AND mot_de_passe = ?";
    private static final String SELECT_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";
    private static final String INSERT = "INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue," +
            "code_postal,ville,mot_de_passe,credit,administrateur)" +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

    private static final String UPDATE = "UPDATE UTILISATEURS" +
            "    SET pseudo = ?," +
            "    nom = ?, prenom = ?," +
            "    email = ?, telephone = ?," +
            "    rue = ?, code_postal = ?," +
            "    ville = ?, mot_de_passe = ?" +
            "    WHERE no_utilisateur = ?";


    //Verifier que le pseudo et le mot de passe sont correctes
    @Override
    public Utilisateurs selectInfosUser(String pseudo, String motdepasse) throws DALException {
        Utilisateurs user = null;
        try(Connection connection = ConnectionProvider.getConnection() ){
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_INFOS_USER);
            preparedStatement.setString(1,pseudo);
            preparedStatement.setString(2,motdepasse);
            preparedStatement.executeQuery();
            ResultSet rs = preparedStatement.getResultSet();
            if(rs.next()){
                user= new Utilisateurs(
                        rs.getInt("no_utilisateur"),
                        rs.getString("pseudo"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("telephone"),
                        rs.getString("rue"),
                        rs.getString("code_postal"),
                        rs.getString("ville"),
                        rs.getString("mot_de_passe"),
                        rs.getString("credit"),
                        rs.getBoolean("administrateur")
                );
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new DALException("Erreur select_infos");
        }
        return user;
    }

    public void inscription(Utilisateurs u) throws DALException{
        try(Connection conn = ConnectionProvider.getConnection()){

            //Faire l'insert
            PreparedStatement stmt = conn.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);

            //Valoriser les parametres
            stmt.setString(1,u.getPseudo());
            stmt.setString(2,u.getNom());
            stmt.setString(3,u.getPrenom());
            stmt.setString(4,u.getEmail());
            stmt.setString(5,u.getTelephone());
            stmt.setString(6,u.getRue());
            stmt.setString(7,u.getCodePostal());
            stmt.setString(8,u.getVille());
            stmt.setString(9,u.getMotDePasse());
            stmt.setString(10,"100");
            stmt.setBoolean(11,false);

            //Executer la requete
            stmt.executeQuery();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                u.setNoUtilisateur(rs.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }

    public void update(Utilisateurs util) throws DALException{


        try(Connection conn = ConnectionProvider.getConnection()) {

            PreparedStatement stmt = conn.prepareStatement(UPDATE);

            stmt.setString(1, util.getPseudo());
            stmt.setString(2,util.getNom());
            stmt.setString(3,util.getPrenom());
            stmt.setString(4,util.getEmail());
            stmt.setString(5,util.getTelephone());
            stmt.setString(6,util.getRue());
            stmt.setString(7,util.getCodePostal());
            stmt.setString(8,util.getVille());
            stmt.setString(9,util.getMotDePasse());
            stmt.setInt(10,util.getNoUtilisateur());

            stmt.executeUpdate();

            //message d'erreur si un problème est rencontré
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new DALException("Erreur a la modification d'un utilisateur");
        }
    }

    public Utilisateurs selectById(Integer id) throws DALException {
        Utilisateurs user = null;
        try(Connection conn = ConnectionProvider.getConnection()) {

            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1,id);
            preparedStatement.executeQuery();
            ResultSet rs = preparedStatement.getResultSet();
            if(rs.next()){
                user= new Utilisateurs(
                        rs.getInt("no_utilisateur"),
                        rs.getString("pseudo"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getString("email"),
                        rs.getString("telephone"),
                        rs.getString("rue"),
                        rs.getString("code_postal"),
                        rs.getString("ville"),
                        rs.getString("mot_de_passe"),
                        rs.getString("credit"),
                        rs.getBoolean("administrateur")
                );
            }
            return user;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new DALException("Erreur a la selection d'un utilisateur");
        }
    }
}

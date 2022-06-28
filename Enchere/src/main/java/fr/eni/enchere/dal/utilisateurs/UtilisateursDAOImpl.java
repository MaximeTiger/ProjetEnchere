package fr.eni.enchere.dal.utilisateurs;

import fr.eni.enchere.bo.Utilisateurs;
import fr.eni.enchere.dal.ConnectionProvider;
import fr.eni.enchere.dal.DALException;
import fr.eni.enchere.dal.utilisateurs.UtilisateursDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class  UtilisateursDAOImpl implements UtilisateursDAO {

    private static final String SELECT_INFOS_USER = "SELECT * FROM UTILISATEURS WHERE pseudo = ? AND mot_de_passe = ?";
    private static final String INSERT = "INSERT INTO UTILISATEURS (pseudo,nom,prenom,email,telephone,rue," +
            "code_postal,ville,mot_de_passe,credit,administrateur)" +
            "VALUES (?,?,?,?,?,?,?,?,?,?,?)";


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
}

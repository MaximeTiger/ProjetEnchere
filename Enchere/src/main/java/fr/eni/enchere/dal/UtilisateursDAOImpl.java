package fr.eni.enchere.dal;

import fr.eni.enchere.bo.Utilisateurs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateursDAOImpl implements UtilisateursDAO{

    private static final String SELECT_INFOS_USER = "SELECT pseudo,mot_de_passe FROM UTILISATEURS WHERE pseudo = ? AND mot_de_passe = ?";

    //Verifier que le pseudo et le mot de passe sont correctes
    @Override
    public Utilisateurs selectInfosUser(String pseudo, String motDePasse) throws DALException {
        Utilisateurs user = null;
        try(Connection connection = ConnectionProvider.getConnection() ){
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_INFOS_USER);
            preparedStatement.setString(1,pseudo);
            preparedStatement.setString(2,motDePasse);
            preparedStatement.executeQuery();
            ResultSet rs = preparedStatement.getResultSet();
            if(rs.next()){
                user= new Utilisateurs(rs.getString("pseudo"),rs.getString("mot_de_passe"));
            }
        }catch (SQLException e){
            e.printStackTrace();
            throw new DALException("Erreur select_infos");
        }
        return user;
    }





}

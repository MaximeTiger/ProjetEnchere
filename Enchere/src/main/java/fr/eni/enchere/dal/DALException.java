package fr.eni.enchere.dal;

public class DALException extends Exception {

    public DALException( ) {

    }

    public DALException(String message){
        super(message);
    }

    public DALException(String message, Throwable exc){
        super(message, exc);
    }

}
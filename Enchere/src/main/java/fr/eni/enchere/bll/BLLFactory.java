package fr.eni.enchere.bll;

public class BLLFactory {
    public static UtilisateursManager getUtilisateursManager() {return new UtilisateursManagerImpl();}

}

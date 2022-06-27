package fr.eni.enchere.bll;

import fr.eni.enchere.bll.utilisateurs.UtilisateursManager;
import fr.eni.enchere.bll.utilisateurs.UtilisateursManagerImpl;

public class BLLFactory {
    public static UtilisateursManager getUtilisateursManager() {return new UtilisateursManagerImpl();}

}

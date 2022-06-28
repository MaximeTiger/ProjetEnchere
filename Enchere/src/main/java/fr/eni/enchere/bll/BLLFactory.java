package fr.eni.enchere.bll;

import fr.eni.enchere.bll.enchere.EnchereManager;
import fr.eni.enchere.bll.enchere.EnchereManagerImpl;
import fr.eni.enchere.bll.utilisateurs.UtilisateursManager;
import fr.eni.enchere.bll.utilisateurs.UtilisateursManagerImpl;

public class BLLFactory {
    public static UtilisateursManager getUtilisateursManager() {return new UtilisateursManagerImpl();}

    public static EnchereManager getEnchereManager() {return new EnchereManagerImpl();}

}

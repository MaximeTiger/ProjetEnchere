package fr.eni.enchere.bll.retrait;

import fr.eni.enchere.bll.BLLException;
import fr.eni.enchere.bo.Retrait;

public interface RetraitManager {
    void ajouterRetrait(Retrait r) throws BLLException;
}

package fr.eni.enchere.bo;

import java.util.ArrayList;
import java.util.List;

public class Categorie {
    //attributs
    private int noCategorie;
    private String libelle;

    private List<Article> listeArticle;


    //constructeurs
    public Categorie(int noCategorie, String libelle) {
        this.noCategorie = noCategorie;
        this.libelle = libelle;
    }
    public Categorie(){
        this.listeArticle = new ArrayList<Article>();
    }
    public Categorie(int noCategorie, String libelle, List<Article> listeArticle) {
        this.noCategorie = noCategorie;
        this.libelle = libelle;
        this.listeArticle = listeArticle;
    }

    //accesseurs
    public Categorie(String libelle) {
        this.libelle = libelle;
    }

    //acesseurs

    public int getNoCategorie() {
        return noCategorie;
    }

    public void setNoCategorie(int noCategorie) {
        this.noCategorie = noCategorie;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public final List<Article> getListeaArticle(){
        return listeArticle;
    }

    //methode
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Categorie{");
        sb.append("noCategorie=").append(noCategorie);
        sb.append(", libelle='").append(libelle).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

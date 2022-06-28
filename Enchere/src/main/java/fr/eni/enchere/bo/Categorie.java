package fr.eni.enchere.bo;

public class Categorie {
    private int noCategorie;
    private String libelle;

    public Categorie(int noCategorie, String libelle) {
        this.noCategorie = noCategorie;
        this.libelle = libelle;
    }

    public Categorie(String libelle) {
        this.libelle = libelle;
    }

    public Categorie() {
    }

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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Categorie{");
        sb.append("noCategorie=").append(noCategorie);
        sb.append(", libelle='").append(libelle).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

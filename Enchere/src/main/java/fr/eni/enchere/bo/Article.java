package fr.eni.enchere.bo;

import java.sql.Date;
import java.time.LocalDate;

public class Article {
//attributs
    private int noArticle;
    private String nomArticle;
    private String description;
    private Date debutEncheres;
    private Date finEncheres;
    private int prixInitial;
    private int prixVente;
    private int noUtilisateur;
    private int noCategorie;

    //constructeurs
    public Article(int noArticle, String nomArticle, String description, Date debutEncheres, Date finEncheres, int prixInitial, int prixVente, int noUtilisateur, int noCategorie) {
        this.noArticle = noArticle;
        this.nomArticle = nomArticle;
        this.description = description;
        this.debutEncheres = debutEncheres;
        this.finEncheres = finEncheres;
        this.prixInitial = prixInitial;
        this.prixVente = prixVente;
        this.noUtilisateur = noUtilisateur;
        this.noCategorie = noCategorie;
    }

    public Article() {
        super();
    }

    //accesseurs
    public int getNoArticle() {
        return noArticle;
    }

    public void setNoArticle(int noArticle) {
        this.noArticle = noArticle;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDebutEncheres() {
        return debutEncheres;
    }

    public void setDebutEncheres(Date debutEncheres) {
        this.debutEncheres = debutEncheres;
    }

    public Date getFinEncheres() {
        return finEncheres;
    }

    public void setFinEncheres(Date finEncheres) {
        this.finEncheres = finEncheres;
    }

    public int getPrixInitial() {
        return prixInitial;
    }

    public void setPrixInitial(int prixInitial) {
        this.prixInitial = prixInitial;
    }

    public int getPrixVente() {
        return prixVente;
    }

    public void setPrixVente(int prixVente) {
        this.prixVente = prixVente;
    }

    public int getNoUtilisateur() {
        return noUtilisateur;
    }

    public void setNoUtilisateur(int noUtilisateur) {
        this.noUtilisateur = noUtilisateur;
    }

    public int getNoCategorie() {
        return noCategorie;
    }

    public void setNoCategorie(int noCategorie) {
        this.noCategorie = noCategorie;
    }
    //

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Article{");
        sb.append("noArticle=").append(noArticle);
        sb.append(", nomArticle='").append(nomArticle).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", debutEncheres=").append(debutEncheres);
        sb.append(", finEncheres=").append(finEncheres);
        sb.append(", prixInitial=").append(prixInitial);
        sb.append(", prixVente=").append(prixVente);
        sb.append(", noUtilisateur=").append(noUtilisateur);
        sb.append(", noCategorie=").append(noCategorie);
        sb.append('}');
        return sb.toString();
    }
}

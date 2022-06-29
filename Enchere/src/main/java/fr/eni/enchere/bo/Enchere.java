package fr.eni.enchere.bo;

import java.sql.Date;

public class Enchere {
    //attributs

    private String nomUtilisateur;

    private String nomArticle;
    private int noEnchere;
    private Date dateEnchere;
    private int montantEnchere;

    private Utilisateurs utilisateurs;

    private Article article;
//constructeurs

    public Enchere(int noEnchere, Date dateEnchere, int montantEnchere, String nomUtilisateur, String nomArticle) {
        this.noEnchere = noEnchere;
        this.dateEnchere = dateEnchere;
        this.montantEnchere = montantEnchere;
        this.nomUtilisateur = nomUtilisateur;
        this.nomArticle = nomArticle;
    }

    public Enchere(int noEnchere, Date dateEnchere, int montantEnchere) {
        this.noEnchere = noEnchere;
        this.dateEnchere = dateEnchere;
        this.montantEnchere = montantEnchere;
    }

    public Enchere(Date dateEnchere, int montantEnchere) {
        this.dateEnchere = dateEnchere;
        this.montantEnchere = montantEnchere;
    }

    public Enchere() {
    }
    //accesseurs
    public int getNoEnchere() {
        return noEnchere;
    }

    public void setNoEnchere(int noEnchere) {
        this.noEnchere = noEnchere;
    }

    public Date getDateEnchere() {
        return dateEnchere;
    }

    public void setDateEnchere(Date dateEnchere) {
        this.dateEnchere = dateEnchere;
    }

    public int getMontantEnchere() {
        return montantEnchere;
    }

    public void setMontantEnchere(int montantEnchere) {
        this.montantEnchere = montantEnchere;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getNomArticle() {
        return nomArticle;
    }

    public void setNomArticle(String nomArticle) {
        this.nomArticle = nomArticle;
    }

    public Utilisateurs getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Utilisateurs utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

//affichage
    @Override
    public String toString() {
        return "Enchere{" + "nomUtilisateur=" + nomUtilisateur +
                ", nomArticle=" + nomArticle +
                ", noEnchere=" + noEnchere +
                ", dateEnchere=" + dateEnchere +
                ", montantEnchere=" + montantEnchere +
                '}';
    }

}


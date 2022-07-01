package fr.eni.enchere.bo;

import java.sql.Date;
import java.time.LocalDate;

public class Enchere {
    //attributs

    private String nomUtilisateur;

    private String nomArticle;
    private int noEnchere;
    private LocalDate dateEnchere;
    private int montantEnchere;

    private Utilisateurs utilisateurs;

    private int noArticle;


    private Article article;
//constructeurs
public Enchere(int noEnchere, LocalDate dateEnchere, int montantEnchere, String nomUtilisateur, String nomArticle) {
    this.noEnchere = noEnchere;
    this.dateEnchere = dateEnchere;
    this.montantEnchere = montantEnchere;
    this.nomUtilisateur = nomUtilisateur;
    this.nomArticle = nomArticle;
}

    public Enchere(int noEnchere, LocalDate dateEnchere, int montantEnchere, String nomUtilisateur, String nomArticle, int noArticle) {
        this.noEnchere = noEnchere;
        this.dateEnchere = dateEnchere;
        this.montantEnchere = montantEnchere;
        this.nomUtilisateur = nomUtilisateur;
        this.nomArticle = nomArticle;
        this.noArticle = noArticle;
    }
    public Enchere(LocalDate dateEnchere, int montantEnchere, String nomUtilisateur, String nomArticle) {
        this.dateEnchere = dateEnchere;
        this.montantEnchere = montantEnchere;
        this.nomUtilisateur = nomUtilisateur;
        this.nomArticle = nomArticle;
    }

    public Enchere(int noEnchere, LocalDate dateEnchere, int montantEnchere) {
        this.noEnchere = noEnchere;
        this.dateEnchere = dateEnchere;
        this.montantEnchere = montantEnchere;
    }


    public Enchere(LocalDate dateEnchere, int montantEnchere) {
        this.dateEnchere = dateEnchere;
        this.montantEnchere = montantEnchere;
    }

    public Enchere() {
    }

    public Enchere(LocalDate dateEnchere, int montantEnchere, int noUtil, int noArt) {
        this.dateEnchere = dateEnchere;
        this.montantEnchere = montantEnchere;
        noUtil=utilisateurs.getNoUtilisateur();
        noArt=article.getNoArticle();
    }
    //accesseurs

    public int getNoArticle() {
        return noArticle;
    }

    public void setNoArticle(int noArticle) {
        this.noArticle = noArticle;
    }
    public int getNoEnchere() {
        return noEnchere;
    }

    public void setNoEnchere(int noEnchere) {
        this.noEnchere = noEnchere;
    }

    public LocalDate getDateEnchere() {
        return dateEnchere;
    }

    public void setDateEnchere(LocalDate dateEnchere) {
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
        this.nomUtilisateur = utilisateurs.getNom();
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
        return "nom Utilisateur = " + nomUtilisateur + "\n" +
                " nomArticle = " + nomArticle + "\n" +
                " noEnchere = " + noEnchere + "\n" +
                " dateEnchere = " + dateEnchere + "\n" +
                " montantEnchere = " + montantEnchere + "\n";
    }

}


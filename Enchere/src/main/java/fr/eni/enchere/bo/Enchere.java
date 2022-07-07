package fr.eni.enchere.bo;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

public class Enchere {
    //attributs

    private String nomUtilisateur;

    private String nomArticle;
    private int noEnchere;
    private LocalDate dateEnchere;
    private int montantEnchere;

    private Utilisateurs utilisateurs;

    private int noArticle;

    private int noUtilisateur;


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

    public Enchere(LocalDate dateEnchere, int montantEnchere, int noArticle, int noUtilisateur) {
        this.dateEnchere = dateEnchere;
        this.montantEnchere = montantEnchere;
        this.noArticle = noArticle;
        this.noUtilisateur = noUtilisateur;
    }

    public Enchere(int no_enchere, Date date_enchere, int montant_enchere, int no_article, int no_utilisateur) {
    this.noEnchere = no_enchere;
    this.dateEnchere = getLocalDateFromDate(date_enchere);
    this.montantEnchere = montant_enchere;
    this.noArticle = no_article;
    this.noUtilisateur = no_utilisateur;
    }

    //accesseurs

    public int getNoUtilisateur() {
        return noUtilisateur;
    }

    public void setNoUtilisateur(int noUtilisateur) {
        this.noUtilisateur = noUtilisateur;
    }

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

    public static LocalDate getLocalDateFromDate(Date date){
        return LocalDate.from(Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()));
    }

}


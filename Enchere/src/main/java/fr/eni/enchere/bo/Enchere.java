package fr.eni.enchere.bo;

import java.time.LocalDate;

public class Enchere {
    //attributs
    private int noEnchere;
    private LocalDate dateEnchere;
    private int montantEnchere;

    private int noArticle;

    private int noUtilisateur;
//constructeurs

    public Enchere(int noEnchere, LocalDate dateEnchere, int montantEnchere, int noArticle, int noUtilisateur) {
        this.noEnchere = noEnchere;
        this.dateEnchere = dateEnchere;
        this.montantEnchere = montantEnchere;
        this.noArticle = noArticle;
        this.noUtilisateur = noUtilisateur;
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
    //accesseurs

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

    public int getNoArticle() {
        return noArticle;
    }

    public void setNoArticle(int noArticle) {
        this.noArticle = noArticle;
    }

    public int getNoUtilisateur() {
        return noUtilisateur;
    }

    public void setNoUtilisateur(int noUtilisateur) {
        this.noUtilisateur = noUtilisateur;
    }

    //affichage

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Enchere{");
        sb.append("noEnchere=").append(noEnchere);
        sb.append(", dateEnchere=").append(dateEnchere);
        sb.append(", montantEnchere=").append(montantEnchere);
        sb.append(", noArticle=").append(noArticle);
        sb.append(", noUtilisateur=").append(noUtilisateur);
        sb.append('}');
        return sb.toString();
    }
}


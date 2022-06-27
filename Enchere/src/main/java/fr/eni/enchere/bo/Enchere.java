package fr.eni.enchere.bo;

import java.sql.Date;
import java.time.LocalDate;

public class Enchere {
    //attributs
    private int noEnchere;
    private Date dateEnchere;
    private int montantEnchere;

    private int noArticle;

    private int noUtilisateur;
//constructeurs

    public Enchere(int noEnchere, Date dateEnchere, int montantEnchere, int noArticle, int noUtilisateur) {
        this.noEnchere = noEnchere;
        this.dateEnchere = dateEnchere;
        this.montantEnchere = montantEnchere;
        this.noArticle = noArticle;
        this.noUtilisateur = noUtilisateur;
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


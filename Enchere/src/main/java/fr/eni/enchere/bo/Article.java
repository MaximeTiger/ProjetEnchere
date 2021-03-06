package fr.eni.enchere.bo;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class Article{
    //attributs
    private int noArticle;
    private String nomArticle;
    private String description;
    private LocalDate debutEncheres;
    private LocalDate finEncheres;
    private int prixInitial;
    private int prixVente;
    private int noCategorie;


    //association
    private Categorie categorie;

    private String libelle;

    private String pseudo;

    private Utilisateurs utilisateur;

    private int noUtilisateur;

    private Retrait retrait;

    private String rue;

    private String codePostale;

    private String ville;

    private List<Enchere> listEnchere;

    private int noEnchere;

    private LocalDate dateEnchere;
    private int montantEnchere;
    private int noArticleEnchere;
    private int noUtilisateurEnchere;


    //constructeurs
    public Article(String nomArticle, String description, LocalDate debutEncheres, LocalDate finEncheres, int prixInitial) {
        this.nomArticle = nomArticle;
        this.description = description;
        this.debutEncheres = debutEncheres;
        this.finEncheres = finEncheres;
        this.prixInitial = prixInitial;
    }

    public Article(int noArticle, String nomArticle, String description, LocalDate debutEncheres, LocalDate finEncheres, int prixInitial, int prixVente, int noUtilisateur, int noCategorie, Categorie categorie, String rue, String codePostale, String ville) {
        this.noArticle = noArticle;
        this.nomArticle = nomArticle;
        this.description = description;
        this.debutEncheres = debutEncheres;
        this.finEncheres = finEncheres;
        this.prixInitial = prixInitial;
        this.prixVente = prixVente;
        this.setRetrait(retrait);
        this.rue = retrait.getRue();
        this.codePostale = retrait.getCodePostal();
        this.ville = retrait.getVille();
        this.setCategorie(categorie);
        this.libelle=categorie.getLibelle();
        this.setUtilisateur(utilisateur);
        this.noUtilisateur = utilisateur.getNoUtilisateur();
    }

        public Article(String nomArticle, String description, LocalDate debutEncheres, LocalDate finEncheres, int prixInitial, String libelle, String rue, String codePostale, String ville) {
        this.nomArticle = nomArticle;
        this.description = description;
        this.debutEncheres = debutEncheres;
        this.finEncheres = finEncheres;
        this.prixInitial = prixInitial;
        this.libelle = libelle;
        this.rue = rue;
        this.codePostale = codePostale;
        this.ville = ville;
    }

    public Article(String nomArticle, String description, LocalDate debutEncheres, LocalDate finEncheres, int prixInitial, String rue, String codePostale, String ville) {
        this.nomArticle = nomArticle;
        this.description = description;
        this.debutEncheres = debutEncheres;
        this.finEncheres = finEncheres;
        this.prixInitial = prixInitial;
        this.rue = retrait.getRue();
        this.codePostale = retrait.getCodePostal();
        this.ville = retrait.getVille();
    }

    public Article(String nom_article, String description, String libelle, int prix_initial,Date date_fin_encheres, String rue, String code_postal, String ville, int no_utilisateur) {
        this.nomArticle = nom_article;
        this.description = description;
        this.libelle = libelle;
        this.prixInitial = prix_initial;
        this.finEncheres = getLocalDateFromDate(date_fin_encheres);
        this.rue = rue;
        this.codePostale = code_postal;
        this.ville = ville;
        this.noUtilisateur = no_utilisateur;
    }

    public Article(String nom_article, String description, String libelle, int prix_initial, Date date_fin_encheres, String rue, String code_postal, String ville, String pseudo) {
    this.nomArticle = nom_article;
    this.description = description;
    this.libelle = libelle;
    this.prixInitial = prix_initial;
    this.finEncheres = getLocalDateFromDate(date_fin_encheres);
    this.rue = rue;
    this.codePostale = code_postal;
    this.ville = ville;
    this.pseudo = pseudo;
    }

    public Article(String nomArticle, String description, LocalDate debutEncheres, LocalDate finEncheres, int prixInitial, int noCategorie, String rue, String codePostale, String ville, int noUtilisateurs) {
        this.nomArticle = nomArticle;
        this.description = description;
        this.debutEncheres = debutEncheres;
        this.finEncheres = finEncheres;
        this.prixInitial = prixInitial;
        this.noCategorie = noCategorie;
        this.rue = rue;
        this.codePostale = codePostale;
        this.ville = ville;
        this.noUtilisateur = noUtilisateurs;
    }

    public Article(int no_article, String nom_article, String description, Date date_debut_encheres, Date date_fin_encheres, int prix_initial, int prix_vente, int no_utilisateur, int no_categorie) {
        this.noArticle = no_article;
        this.nomArticle = nom_article;
        this.description = description;
        this.debutEncheres = getLocalDateFromDate(date_debut_encheres);
        this.finEncheres = getLocalDateFromDate(date_fin_encheres);
        this.prixInitial = prix_initial;
        this.prixVente = prix_vente;
        this.noUtilisateur = no_utilisateur;
        this.noCategorie = no_categorie;
    }

    public Article(int no_article, String nom_article, String description, Date date_debut_encheres, Date date_fin_encheres, int prix_initial, int prix_vente, int no_utilisateur, int no_categorie, int no_enchere, Date date_enchere, int montant_enchere, int no_article_enchere, int no_utilisateur_enchere) {
    this.noArticle = no_article;
    this.nomArticle = nom_article;
    this.description = description;
    this.debutEncheres = getLocalDateFromDate(date_debut_encheres);
    this.finEncheres = getLocalDateFromDate(date_fin_encheres);
    this.prixInitial = prix_initial;
    this.prixVente = prix_vente;
    this.noUtilisateur = no_utilisateur;
    this.noCategorie = no_categorie;
    this.noEnchere = no_enchere;
    this.dateEnchere = getLocalDateFromDate(date_enchere);
    this.montantEnchere = montant_enchere;
    this.noArticleEnchere = no_article_enchere;
    this.noUtilisateurEnchere = no_utilisateur_enchere;
    }

    public Article(int no_article) {
        this.noArticle = no_article;
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

    public LocalDate getDebutEncheres() {
        return debutEncheres;
    }

    public void setDebutEncheres(LocalDate debutEncheres) {
        this.debutEncheres = debutEncheres;
    }

    public LocalDate getFinEncheres() {
        return finEncheres;
    }

    public void setFinEncheres(LocalDate finEncheres) {
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

    public int getNoCategorie() {return noCategorie;}

    public void setNoCategorie(int noCategorie) {this.noCategorie = noCategorie;}

    //Accesseurs par association
    public String getLibelle() { return libelle; }


    public int getNoUtilisateur() { return noUtilisateur;}


    public void setLibelle(String libelle) { this.libelle = libelle; }


    public void setNoUtilisateur(int noUtilisateur) { this.noUtilisateur = noUtilisateur; }


    public Categorie getCategorie() { return categorie; }


    public Utilisateurs getUtilisateur() { return utilisateur; }


    public void setCategorie(Categorie categorie) { this.categorie = categorie; }


    public void setUtilisateur(Utilisateurs utilisateur) { this.utilisateur = utilisateur; }


    public Retrait getRetrait() { return retrait; }


    public String getRue() { return rue; }


    public String getCodePostale() { return codePostale; }


    public String getVille() { return ville; }


    public void setRetrait(Retrait retrait) { this.retrait = retrait; }


    public void setRue(String rue) { this.rue = rue; }


    public void setCodePostale(String codePostale) { this.codePostale = codePostale; }


    public void setVille(String ville) { this.ville = ville; }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public static LocalDate getLocalDateFromDate(Date date){
        return LocalDate.from(Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()));
    }
}

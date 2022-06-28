package fr.eni.enchere.bo;

public class Retrait {

    //attributs
    private String nomArticle;

    private Article article;
    private String rue;
    private String codePostal;
    private String ville;

    //constructeurs
    public Retrait(String nomArticle, String rue, String codePostal, String ville) {
        this.nomArticle = article.getNomArticle();
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    public Retrait(String rue, String codePostal, String ville) {
        this.rue = rue;
        this.codePostal = codePostal;
        this.ville = ville;
    }

    //accesseurs : getteurs
    public String getNoArticle() {
        return nomArticle;
    }
    public String getRue() {
        return rue;
    }
    public String getCodePostal() {
        return codePostal;
    }
    public String getVille() {
        return ville;
    }
    //accesseurs :setteurs
    public void setNoArticle(String noArticle) {
        this.nomArticle = nomArticle;
    }
    public void setRue(String rue) {
        this.rue = rue;
    }
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }

    @java.lang.Override
    public java.lang.String toString() {
        final java.lang.StringBuilder sb = new java.lang.StringBuilder("Retrait{");
        sb.append("noArticle='").append(nomArticle).append('\'');
        sb.append(", rue='").append(rue).append('\'');
        sb.append(", codePostal='").append(codePostal).append('\'');
        sb.append(", ville='").append(ville).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

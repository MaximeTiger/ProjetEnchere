package fr.eni.enchere.bo;

public class Retrait {

    //attributs
    private int noArticle;
    private Article article;
    private String rue;
    private String codePostal;
    private String ville;

    //constructeurs
    public Retrait(int noArticle, String rue, String codePostal, String ville) {
        this.noArticle = noArticle;
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


    public int getNoArticle() {
        return noArticle;
    }
    public void setNoArticle(int noArticle) {
        this.noArticle = noArticle;
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
    public void setRue(String rue) {
        this.rue = rue;
    }
    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }
    public void setVille(String ville) {
        this.ville = ville;
    }
    public Article getArticle() {
        return article;
    }
    public void setArticle(Article article) {
        this.article = article;
    }

    @java.lang.Override
    public java.lang.String toString() {
        final java.lang.StringBuilder sb = new java.lang.StringBuilder("Retrait{");
        sb.append("nomArticle='").append(noArticle).append('\'');
        sb.append(", rue='").append(rue).append('\'');
        sb.append(", codePostal='").append(codePostal).append('\'');
        sb.append(", ville='").append(ville).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

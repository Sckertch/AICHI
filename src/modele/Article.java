package modele;

public class Article {
    private int code;
    private String Designation;
    private int quantite;
    private double prixUnitaire;

    public Article(int code, String Designation, int quantite, double prixUnitaire) {
        this.code = code;
        this.Designation = Designation;
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
    }
    public Article() {

    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getDesignation() {
        return Designation;
    }
    public void setDesignation(String designation) {
        Designation = designation;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
    public double getPrixUnitaire() {
        return prixUnitaire;
    }
    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}

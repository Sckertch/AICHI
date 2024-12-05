package modele;

public class Article {
    private int idArt; // Remplacer code par idArt
    private String nomArt; // Remplacer Designation par nomArt
    private int quantite;
    private double prixUnitaire;

    // Constructeur avec paramètres
    public Article(int idArt, String nomArt, int quantite, double prixUnitaire) {
        this.idArt = idArt; // Mettre à jour la variable correspondante
        this.nomArt = nomArt; // Mettre à jour la variable correspondante
        this.quantite = quantite;
        this.prixUnitaire = prixUnitaire;
    }

    // Constructeur sans paramètres
    public Article() {

    }

    // Getter et setter pour idArt
    public int getIdArt() {
        return idArt;
    }

    public void setIdArt(int idArt) {
        this.idArt = idArt;
    }

    // Getter et setter pour nomArt
    public String getNomArt() {
        return nomArt;
    }

    public void setNomArt(String nomArt) {
        this.nomArt = nomArt;
    }

    // Getter et setter pour quantite
    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    // Getter et setter pour prixUnitaire
    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}

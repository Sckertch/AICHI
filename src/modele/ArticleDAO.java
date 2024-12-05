package modele;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {

    private final ConnexionDAO connexionDAO;

    // Constructeur pour initialiser ConnexionDAO
    public ArticleDAO() {
        this.connexionDAO = new ConnexionDAO();
    }

    // Méthode pour récupérer tous les articles
    public List<Article> getAllArticles() {
        List<Article> articles = new ArrayList<>();
        Connection connection = connexionDAO.getConnection();
        String query = "SELECT * FROM article";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Article article = new Article();
                article.setIdArt(rs.getInt("idArt")); // Correspond à la colonne idArt dans la DB
                article.setNomArt(rs.getString("nomArt")); // Correspond à la colonne nomArt dans la DB
                article.setQuantite(rs.getInt("quantite")); // Correspond à la colonne quantite dans la DB
                article.setPrixUnitaire(rs.getFloat("prixU")); // Correspond à la colonne prixU dans la DB
                articles.add(article); // Ajouter l'article à la liste
            }
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des articles");
            e.printStackTrace();
        }
        return articles;
    }

    // Méthode pour ajouter un article
    public void addArticle(Article article) {
        Connection connection = connexionDAO.getConnection();
        String query = "INSERT INTO article (nomArt, quantite, prixU) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, article.getNomArt());
            stmt.setInt(2, article.getQuantite());
            stmt.setDouble(3, article.getPrixUnitaire());
            stmt.executeUpdate();
            System.out.println("Article ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de l'article");
            e.printStackTrace();
        }
    }

    // Méthode pour mettre à jour un article
    public void updateArticle(Article article) {
        Connection connection = connexionDAO.getConnection();
        String query = "UPDATE article SET nomArt = ?, quantite = ?, prixU = ? WHERE idArt = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, article.getNomArt());
            stmt.setInt(2, article.getQuantite());
            stmt.setDouble(3, article.getPrixUnitaire());
            stmt.setInt(4, article.getIdArt());
            stmt.executeUpdate();
            System.out.println("Article mis à jour avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la mise à jour de l'article");
            e.printStackTrace();
        }
    }

    // Méthode pour supprimer un article
    public void deleteArticle(int idArt) {
        Connection connection = connexionDAO.getConnection();
        String query = "DELETE FROM article WHERE idArt = ?";

        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, idArt);
            stmt.executeUpdate();
            System.out.println("Article supprimé avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de l'article");
            e.printStackTrace();
        }
    }
}

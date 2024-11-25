package modele;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modele.ConnexionDAO;
import views.FArticlesView;


public class ArticleDAO {

    private ConnexionDAO connexion;


    public List<Article> getAllArticles(Connection connection ) {
        List<Article> articles = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM article");

            while (rs.next()) {
                Article article = new Article();
                article.setCode(rs.getInt("code"));
                article.setDesignation(rs.getString("designation"));
                article.setQuantite(rs.getInt("quantite"));
                article.setPrixUnitaire(rs.getFloat("prixUnitaire"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return articles;
    }

    public void addArticle(Article article, Connection connection) {
        try {
            String query = "INSERT INTO article (designation,quantite,prixunitaire) VALUES (?,?,?,?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, article.getDesignation());
            stmt.setInt(2, article.getQuantite());
            stmt.setDouble(3,article.getPrixUnitaire());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

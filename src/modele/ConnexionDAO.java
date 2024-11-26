package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionDAO {
    private Connection connection;

    // Constructeur
    public ConnexionDAO() {
        connection=getConnection();

    }

    // Méthode pour obtenir une connexion à la base de données
    public Connection getConnection() {
        if (connection == null) {
            try {
                // Informations de connexion à la base de données
                String url = "jdbc:mysql://mysql-sckertch.alwaysdata.net:3306/sckertch_aichi";
                String username = "sckertch_aichi_a";
                String password = "Graduate4-Footprint-Backslid";
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connexion réussie à la base de données");
            } catch (SQLException e) {
                System.out.println("Erreur lors de la connexion à la base de données");
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Méthode pour fermer la connexion
    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Connexion fermée");
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion");
                e.printStackTrace();
            }
        }
    }
}
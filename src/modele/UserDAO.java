package modele;

import java.sql.*;  
import java.util.ArrayList;  
import java.util.List; 

import modele.User;

public class UserDAO {
    private Connection connection;
    
    public UserDAO() {  
        try {  
            // Connection à MySQL 
            String url = "jdbc:mysql://mysql-sckertch.alwaysdata.net:3306/sckertch_aichi"; // Removed extra space
            String username = "sckertch";  
            String password = "Lavageauto";  
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            connection = DriverManager.getConnection(url, username, password);  
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();  
        } 
    }
    
    public boolean verifUser (User user) {
        String query = "SELECT id FROM user WHERE mail = ? AND motDePasse = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getMotDePasse());
            try (ResultSet rs = stmt.executeQuery()) {
                // Si un résultat est trouvé, récupérer l’ID et retourner true
                if (rs.next()) {
                    return true;  // Identifiants corrects
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;  // Identifiants incorrects
    }
    
    public void addUser (User user) {
        String query = "INSERT INTO user (nom, prenom, mail, motDePasse) VALUES (?,?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
        	System.out.println(user.getNom());
        	System.out.println(user.getPrenom());
        	System.out.println(user.getEmail());
        	System.out.println(user.getMotDePasse());
        	stmt.setString(1, user.getNom());
        	stmt.setString(2, user.getPrenom());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getMotDePasse());
            int rs = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }  // Identifiants incorrects
     }
    
    public List<User> getLsUsers() {
        List<User> lstUsers = new ArrayList<>(); 
        String query = "SELECT * FROM users";  // Vérifi que le nom de la table est correct
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                User user = new User();   
                user.setNom(rs.getString("nom"));  
                user.setEmail(rs.getString("email"));  
                lstUsers.add(user);   
            }
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return lstUsers; 
    }
    
    public List<String> getlsNomUsers() {
        List<String> lstUsers = new ArrayList<>(); 
        String query = "SELECT nom FROM user";  
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) { 
                lstUsers.add(rs.getString("nom"));   
            }
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return lstUsers; 
    }
}
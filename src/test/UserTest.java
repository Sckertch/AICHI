package test;

import modele.UserDAO;
import modele.User;

public class UserTest {
	 public UserTest( ) {
		 
	 }
	 
	 public static void testAddUser(String nom, String prenom, String mail, String motDePasse) {
		 User u = new User();
		 u.setNom(nom);
		 u.setPrenom(prenom);
		 u.setEmail(mail);
		 u.setMotDePasse(motDePasse);
		 System.out.println("Connexion réussie à la base de données 2 ");
		 
		 UserDAO conn = new UserDAO();
		 conn.addUser(u);
	 }
	 
	 public static void main(String[] args) {
		System.out.println("Connexion réussie à la base de données");
		testAddUser("cat","cat","cat","cat");
	}

}


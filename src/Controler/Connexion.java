package Controler;

import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener; 
import views.FConnexionView;
import modele.User;
import modele.UserDAO;

public class Connexion {
	private FConnexionView view;
	
	public Connexion (FConnexionView view, UserDAO userdao) {
		this.view = view;
	
				
		this.view.getBtnValider().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User newUser = new User();
				newUser.setEmail(view.getLogin());
				newUser.setMotDePasse(view.getMotDePasse());
				UserDAO c = new UserDAO();
				c.verifUser(newUser);
			
			}
		});	
	}	
}

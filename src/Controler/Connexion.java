package Controler;

import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener; 
import javax.swing.JOptionPane; // Importation de JOptionPane
import views.FConnexionView;
import modele.User;
import modele.UserDAO;

public class Connexion {
    private FConnexionView view;
    private UserDAO userdao;

    public Connexion(FConnexionView view, UserDAO userdao) {
        this.view = view;
        this.userdao = userdao;

        this.view.getBtnValider().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });    
    }

    private void handleLogin() {
        User newUser   = new User();
        newUser .setEmail(view.getLogin());
        newUser .setMotDePasse(view.getMotDePasse());

        try {
            boolean isValidUser  = userdao.verifUser (newUser );
            if (isValidUser ) {
                System.out.println("Connexion réussie");
                JOptionPane.showMessageDialog(view, "Connexion réussie", "Succès", JOptionPane.INFORMATION_MESSAGE);
                // Proceed with the application flow, e.g., open the main application window
            } else {
                System.out.println("Identifiants incorrects, veuillez réessayer.");
                JOptionPane.showMessageDialog(view, "Identifiants incorrects, veuillez réessayer.", "Erreur", JOptionPane.ERROR_MESSAGE);
                // Optionally, show a message dialog to the user
            }
        } catch (Exception e) {
            System.out.println("Erreur lors de la connexion : " + e.getMessage());
            JOptionPane.showMessageDialog(view, "Erreur lors de la connexion : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
            // Optionally, log the error or show a message dialog to the user
        }
    }
}
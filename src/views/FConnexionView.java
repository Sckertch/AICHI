package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class FConnexionView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField txtSaisieUtilisateur;
    private JPasswordField pwdMotDePasse;
    private JButton btnQuitter;
    private JButton btnValider;
    private JLabel lblTitre; 
    private JLabel lblUtilisateur; 
    private JLabel lblMotDePasse; 

    public FConnexionView() {
        // Configuration de base de la fenêtre
        setTitle("Aïchi Gestion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 550, 370);
        setLocationRelativeTo(null); // Centrer la fenêtre

        // Conteneur principal
        JPanel panelGlobal = new JPanel();
        panelGlobal.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelGlobal.setLayout(new BorderLayout());
        panelGlobal.setBackground(Color.WHITE);
        setContentPane(panelGlobal);

        // Panel du titre
        JPanel panelTitre = new JPanel();
        panelTitre.setBackground(Color.WHITE);
        panelTitre.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel lblIcon = new JLabel(new ImageIcon("icon.png")); // Remplacer "icon.png" par l'icône voulue
        JLabel lblTitre = new JLabel("Connexion");
        lblTitre.setFont(new Font("Arial", Font.BOLD, 18));
        panelTitre.add(lblIcon);
        panelTitre.add(lblTitre);
        panelGlobal.add(panelTitre, BorderLayout.NORTH);

        // Panel central pour les champs utilisateur et mot de passe
        JPanel panelCentre = new JPanel();
        panelCentre.setBackground(Color.WHITE);
        panelCentre.setBorder(new CompoundBorder(
                new LineBorder(new Color(0x33, 0xB5, 0xE5), 1, true),
                new EmptyBorder(15, 15, 15, 15)));
        panelGlobal.add(panelCentre, BorderLayout.CENTER);
        panelCentre.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Nom d'utilisateur
        JLabel lblUtilisateur = new JLabel("Nom d'utilisateur");
        lblUtilisateur.setIcon(new ImageIcon("user-icon.png")); // Remplacer par votre icône utilisateur
        lblUtilisateur.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 0;
        panelCentre.add(lblUtilisateur, gbc);

        txtSaisieUtilisateur = new JTextField();
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        panelCentre.add(txtSaisieUtilisateur, gbc);

        // Mot de passe
        JLabel lblMotDePasse = new JLabel("Mot de passe");
        lblMotDePasse.setIcon(new ImageIcon("password-icon.png")); // Remplacer par votre icône mot de passe
        lblMotDePasse.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0;
        panelCentre.add(lblMotDePasse, gbc);

        pwdMotDePasse = new JPasswordField();
        gbc.gridx = 1;
        gbc.weightx = 1.0;
        panelCentre.add(pwdMotDePasse, gbc);

        // Panel pour les actions (boutons)
        JPanel panelActions = new JPanel();
        panelActions.setBackground(Color.WHITE);
        panelActions.setLayout(new FlowLayout(FlowLayout.RIGHT));

        btnValider = new JButton("Valider");
        btnValider.setBackground(new Color(50, 205, 50)); // Vert
        btnValider.setForeground(Color.WHITE);
        btnValider.setFocusPainted(false);

        btnQuitter = new JButton("Quitter");
        btnQuitter.setBackground(new Color(255, 69, 0)); // Rouge
        btnQuitter.setForeground(Color.WHITE);
        btnQuitter.setFocusPainted(false);

        panelActions.add(btnValider);
        panelActions.add(btnQuitter);

        panelGlobal.add(panelActions, BorderLayout.SOUTH);

        // Afficher la fenêtre
        setVisible(true);
        }
    
    // Getters pour récupérer les champs et boutons
    public String getLogin() {
        return txtSaisieUtilisateur.getText();
    }

    public String getMotDePasse() {
        return new String(pwdMotDePasse.getPassword());
    }

    public void addValiderListener(ActionListener listener) {
        btnValider.addActionListener(listener);
    }

    public JButton getBtnValider() {
        return btnValider;
    }

    public void addQuitterListener(ActionListener listener) {
        btnQuitter.addActionListener(listener);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void fermerFenetre() {
        dispose();
    }
}
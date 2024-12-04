
package views;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.time.Instant;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import Controler.FAccueilController;


public class FClientsView extends JPanel {

    private static final long serialVersionUID = 1L;


    private JTable table;
    private JTextField txtCode;
    private JTextField txtDateCreation;
    private JTextField txtPrenom;
    private JTextField txtNom;
    private JTextField txtAdresse;
    private JTextField txtTelfixe;
    private JTextField txtMobile;
    private JTextField txtEmail;

    private JTextArea textArea;

    private JDialog fenetre;


    private JButton btnModifier;


    private JButton btnRechercher;


    private JButton btnAjouter;


    public FClientsView(FAccueilController connexionDAO) {
    	System.out.println("ckliennnnnnn");
        setBackground(new Color(0x33, 0xB5, 0xE5));
        setBorder(null);
        setLayout(new BorderLayout(0, 0));

        JPanel panel_menu = new JPanel();
        panel_menu.setBackground(new Color(0x00, 0x99, 0xCC));
        add(panel_menu, BorderLayout.WEST);
        panel_menu.setBorder(new CompoundBorder(null, new EmptyBorder(5, 5, 5,
                5)));
        GridBagLayout gbl_panel_menu = new GridBagLayout();
        gbl_panel_menu.columnWidths = new int[] { 0, 0 };
        gbl_panel_menu.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        gbl_panel_menu.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
        gbl_panel_menu.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        panel_menu.setLayout(gbl_panel_menu);

        JLabel lblTitre = new JLabel("Clients");
        GridBagConstraints gbc_lblTitre = new GridBagConstraints();
        gbc_lblTitre.insets = new Insets(0, 0, 15, 20);
        gbc_lblTitre.gridx = 0;
        gbc_lblTitre.gridy = 0;
        panel_menu.add(lblTitre, gbc_lblTitre);
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 25));

        btnAjouter = new JButton("Ajouter");
        btnAjouter.setForeground(Color.BLACK);
        btnAjouter.setHorizontalAlignment(SwingConstants.LEFT);

        GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
        gbc_btnAjouter.anchor = GridBagConstraints.LINE_START;
        gbc_btnAjouter.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnAjouter.insets = new Insets(0, 0, 5, 0);
        gbc_btnAjouter.gridx = 0;
        gbc_btnAjouter.gridy = 1;
        panel_menu.add(btnAjouter, gbc_btnAjouter);

        btnRechercher = new JButton("Rechercher");
        btnRechercher.setForeground(Color.BLACK);
        btnRechercher.setHorizontalAlignment(SwingConstants.LEFT);
        GridBagConstraints gbc_btnRechercher = new GridBagConstraints();
        gbc_btnRechercher.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnRechercher.anchor = GridBagConstraints.LINE_START;
        gbc_btnRechercher.insets = new Insets(0, 0, 5, 0);
        gbc_btnRechercher.gridx = 0;
        gbc_btnRechercher.gridy = 2;
        panel_menu.add(btnRechercher, gbc_btnRechercher);

        btnModifier = new JButton("Modifier");
        btnModifier.setForeground(Color.BLACK);
        btnModifier.setHorizontalAlignment(SwingConstants.LEFT);
        GridBagConstraints gbc_btnModifier = new GridBagConstraints();
        gbc_btnModifier.anchor = GridBagConstraints.LINE_START;
        gbc_btnModifier.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnModifier.insets = new Insets(0, 0, 5, 0);
        gbc_btnModifier.gridx = 0;
        gbc_btnModifier.gridy = 3;
        panel_menu.add(btnModifier, gbc_btnModifier);

        JButton btnSupprimer = new JButton("Supprimer");
        btnSupprimer.setForeground(Color.BLACK);
        btnSupprimer.setHorizontalAlignment(SwingConstants.LEFT);
        GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
        gbc_btnSupprimer.anchor = GridBagConstraints.LINE_START;
        gbc_btnSupprimer.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnSupprimer.insets = new Insets(0, 0, 5, 0);
        gbc_btnSupprimer.gridx = 0;
        gbc_btnSupprimer.gridy = 4;
        panel_menu.add(btnSupprimer, gbc_btnSupprimer);


        JButton btnAccueil = new JButton("Accueil");
        btnAccueil.setForeground(Color.BLACK);
        GridBagConstraints gbc_btnAccueil = new GridBagConstraints();
        gbc_btnAccueil.weighty = 1.0;
        gbc_btnAccueil.anchor = GridBagConstraints.SOUTHWEST;
        gbc_btnAccueil.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnAccueil.gridx = 0;
        gbc_btnAccueil.gridy = 8;
        panel_menu.add(btnAccueil, gbc_btnAccueil);

        JPanel panel_principal = new JPanel();
        panel_principal.setBackground(new Color(197, 234, 248));
        add(panel_principal, BorderLayout.CENTER);
        
        // Initialisation du tableau
        table = new JTable(new Object[][]{}, new String[]{"Colonne 1", "Colonne 2", "Colonne 3"});
        JScrollPane scrollPane = new JScrollPane(table);
        panel_principal.add(scrollPane, "cell 0 1 4 1,grow");
        scrollPane.setOpaque(false);

        // Assurez-vous que la table a un modèle avant d'accéder aux colonnes
        TableColumnModel modeleColonne = table.getColumnModel();
        TableColumn noms = modeleColonne.getColumn(0);
        TableColumn cartes = modeleColonne.getColumn(1);
        TableColumn dates = modeleColonne.getColumn(2);

        JPanel panel_formulaire = new JPanel();
        panel_formulaire.setOpaque(false);
        panel_formulaire.setBorder(new CompoundBorder(new LineBorder(new Color(
                0, 0, 0), 2, true), new EmptyBorder(5, 5, 5, 5)));
        panel_principal.add(panel_formulaire, "cell 0 0 4 1,grow");
        GridBagLayout gbl_panel_formulaire = new GridBagLayout();
        gbl_panel_formulaire.columnWidths = new int[] { 79, 182, 91, 182, 119 };
        gbl_panel_formulaire.rowHeights = new int[] { 26, 26, 26, 26, 0, 75 };
        gbl_panel_formulaire.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0,
                0.0 };
        gbl_panel_formulaire.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
                0.0, 1.0 };
        panel_formulaire.setLayout(gbl_panel_formulaire);

        JLabel lblCode = new JLabel("Code");
        GridBagConstraints gbc_lblCode = new GridBagConstraints();
        gbc_lblCode.anchor = GridBagConstraints.EAST;
        gbc_lblCode.insets = new Insets(0, 0, 5, 5);
        gbc_lblCode.gridx = 0;
        gbc_lblCode.gridy = 0;
        panel_formulaire.add(lblCode, gbc_lblCode);

        txtCode = new JTextField();
        lblCode.setLabelFor(txtCode);
        txtCode.setEditable(false);
        GridBagConstraints gbc_txtCode = new GridBagConstraints();
        gbc_txtCode.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtCode.insets = new Insets(0, 0, 5, 5);
        gbc_txtCode.gridx = 1;
        gbc_txtCode.gridy = 0;
        panel_formulaire.add(txtCode, gbc_txtCode);
        txtCode.setColumns(10);


        JLabel lblDatecreation = new JLabel("Créé le");
        GridBagConstraints gbc_lblDatecreation = new GridBagConstraints();
        gbc_lblDatecreation.anchor = GridBagConstraints.LINE_END;
        gbc_lblDatecreation.insets = new Insets(0, 0, 5, 5);
        gbc_lblDatecreation.gridx = 2;
        gbc_lblDatecreation.gridy = 0;
        panel_formulaire.add(lblDatecreation, gbc_lblDatecreation);

        txtDateCreation = new JTextField();
        lblDatecreation.setLabelFor(txtDateCreation);
        txtDateCreation.setEditable(false);
        GridBagConstraints gbc_txtDateCreation = new GridBagConstraints();
        gbc_txtDateCreation.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtDateCreation.insets = new Insets(0, 0, 5, 5);
        gbc_txtDateCreation.gridx = 3;
        gbc_txtDateCreation.gridy = 0;
        panel_formulaire.add(txtDateCreation, gbc_txtDateCreation);
        txtDateCreation.setColumns(10);

        JLabel lblPrenom = new JLabel("Prénom");
        GridBagConstraints gbc_lblPrenom = new GridBagConstraints();
        gbc_lblPrenom.anchor = GridBagConstraints.EAST;
        gbc_lblPrenom.insets = new Insets(0, 0, 5, 5);
        gbc_lblPrenom.gridx = 0;
        gbc_lblPrenom.gridy = 1;
        panel_formulaire.add(lblPrenom, gbc_lblPrenom);

        txtPrenom = new JTextField();
        lblPrenom.setLabelFor(txtPrenom);
        txtPrenom.setEditable(false);
        GridBagConstraints gbc_txtPrenom = new GridBagConstraints();
        gbc_txtPrenom.anchor = GridBagConstraints.NORTH;
        gbc_txtPrenom.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtPrenom.insets = new Insets(0, 0, 5, 5);
        gbc_txtPrenom.gridx = 1;
        gbc_txtPrenom.gridy = 1;
        panel_formulaire.add(txtPrenom, gbc_txtPrenom);
        txtPrenom.setColumns(10);

        JLabel lblNom = new JLabel("Nom");
        GridBagConstraints gbc_lblNom = new GridBagConstraints();
        gbc_lblNom.anchor = GridBagConstraints.EAST;
        gbc_lblNom.insets = new Insets(0, 0, 5, 5);
        gbc_lblNom.gridx = 2;
        gbc_lblNom.gridy = 1;
        panel_formulaire.add(lblNom, gbc_lblNom);

        txtNom = new JTextField();
        lblNom.setLabelFor(txtNom);
        txtNom.setEditable(false);
        GridBagConstraints gbc_txtNom = new GridBagConstraints();
        gbc_txtNom.anchor = GridBagConstraints.NORTH;
        gbc_txtNom.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtNom.insets = new Insets(0, 0, 5, 0);
        gbc_txtNom.gridwidth = 2;
        gbc_txtNom.gridx = 3;
        gbc_txtNom.gridy = 1;
        panel_formulaire.add(txtNom, gbc_txtNom);
        txtNom.setColumns(10);

        JLabel lblAdresse = new JLabel("Adresse");
        GridBagConstraints gbc_lblAdresse = new GridBagConstraints();
        gbc_lblAdresse.anchor = GridBagConstraints.EAST;
        gbc_lblAdresse.insets = new Insets(0, 0, 5, 5);
        gbc_lblAdresse.gridx = 0;
        gbc_lblAdresse.gridy = 2;
        panel_formulaire.add(lblAdresse, gbc_lblAdresse);

        txtAdresse = new JTextField();
        lblAdresse.setLabelFor(txtAdresse);
        txtAdresse.setEditable(false);
        GridBagConstraints gbc_txtAdresse = new GridBagConstraints();
        gbc_txtAdresse.anchor = GridBagConstraints.NORTH;
        gbc_txtAdresse.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtAdresse.insets = new Insets(0, 0, 5, 0);
        gbc_txtAdresse.gridwidth = 4;
        gbc_txtAdresse.gridx = 1;
        gbc_txtAdresse.gridy = 2;
        panel_formulaire.add(txtAdresse, gbc_txtAdresse);
        txtAdresse.setColumns(10);

        JLabel lblFixe = new JLabel("Fixe");
        GridBagConstraints gbc_lblFixe = new GridBagConstraints();
        gbc_lblFixe.anchor = GridBagConstraints.EAST;
        gbc_lblFixe.insets = new Insets(0, 0, 5, 5);
        gbc_lblFixe.gridx = 0;
        gbc_lblFixe.gridy = 3;
        panel_formulaire.add(lblFixe, gbc_lblFixe);

        txtTelfixe = new JTextField();
        lblFixe.setLabelFor(txtTelfixe);
        txtTelfixe.setEditable(false);
        GridBagConstraints gbc_txtTelfixe = new GridBagConstraints();
        gbc_txtTelfixe.anchor = GridBagConstraints.NORTH;
        gbc_txtTelfixe.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtTelfixe.insets = new Insets(0, 0, 5, 5);
        gbc_txtTelfixe.gridx = 1;
        gbc_txtTelfixe.gridy = 3;
        panel_formulaire.add(txtTelfixe, gbc_txtTelfixe);
        txtTelfixe.setColumns(10);

        JLabel lblMobile = new JLabel("Mobile");
        GridBagConstraints gbc_lblMobile = new GridBagConstraints();
        gbc_lblMobile.anchor = GridBagConstraints.EAST;
        gbc_lblMobile.insets = new Insets(0, 0, 5, 5);
        gbc_lblMobile.gridx = 2;
        gbc_lblMobile.gridy = 3;
        panel_formulaire.add(lblMobile, gbc_lblMobile);

        txtMobile = new JTextField();
        lblMobile.setLabelFor(txtMobile);
        txtMobile.setEditable(false);
        GridBagConstraints gbc_txtMobile = new GridBagConstraints();
        gbc_txtMobile.anchor = GridBagConstraints.NORTH;
        gbc_txtMobile.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtMobile.insets = new Insets(0, 0, 5, 0);
        gbc_txtMobile.gridwidth = 2;
        gbc_txtMobile.gridx = 3;
        gbc_txtMobile.gridy = 3;
        panel_formulaire.add(txtMobile, gbc_txtMobile);
        txtMobile.setColumns(10);

        JLabel lblEmail = new JLabel("Email");
        GridBagConstraints gbc_lblEmail = new GridBagConstraints();
        gbc_lblEmail.anchor = GridBagConstraints.EAST;
        gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
        gbc_lblEmail.gridx = 0;
        gbc_lblEmail.gridy = 4;
        panel_formulaire.add(lblEmail, gbc_lblEmail);

        txtEmail = new JTextField();
        lblEmail.setLabelFor(txtEmail);
        txtEmail.setEditable(false);
        GridBagConstraints gbc_txtEmail = new GridBagConstraints();
        gbc_txtEmail.anchor = GridBagConstraints.NORTH;
        gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtEmail.insets = new Insets(0, 0, 5, 0);
        gbc_txtEmail.gridwidth = 4;
        gbc_txtEmail.gridx = 1;
        gbc_txtEmail.gridy = 4;
        panel_formulaire.add(txtEmail, gbc_txtEmail);
        txtEmail.setColumns(10);
    }










}

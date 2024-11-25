package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;



public class FProduitsView extends JDialog {

    private static final long serialVersionUID = 1L;


    private JPanel contentPane;
    private JTable table;
    private JTextField txtCode;
    private JTextField txtCategorie;

    private JTextField txtRecherche;
    private JTextField txtDesignation;
    private JFormattedTextField txtPrixUnitaire;
    private JSlider sliderQuantite;
    private ButtonGroup buttonGroup;
    private JRadioButton rdbtnCategorie;
    private JRadioButton rdbtnCode;
    private JTextField txtQuantite;


    /**
     * Create the frame.
     *
     * @param parent
     */
    public FProduitsView(Window parent) {
        super(parent);


        setTitle("Gestion des Articles");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1000, 700);
        setLocationRelativeTo(null);

        createContents();
    }

    private void createContents() {
        contentPane = new JPanel();
        contentPane.setBackground(new Color(0x99, 0xCC, 0x00));
        contentPane.setBorder(null);
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel_menu = new JPanel();
        panel_menu.setBackground(new Color(0x66, 0x99, 0x00));
        contentPane.add(panel_menu, BorderLayout.WEST);
        panel_menu.setBorder(new CompoundBorder(null, new EmptyBorder(5, 5, 5,
                5)));
        GridBagLayout gbl_panel_menu = new GridBagLayout();
        gbl_panel_menu.columnWidths = new int[] { 0, 0 };
        gbl_panel_menu.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        gbl_panel_menu.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
        gbl_panel_menu.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
                0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        panel_menu.setLayout(gbl_panel_menu);

        JLabel lblTitre = new JLabel("Articles");
        GridBagConstraints gbc_lblTitre = new GridBagConstraints();
        gbc_lblTitre.insets = new Insets(0, 0, 15, 20);
        gbc_lblTitre.gridx = 0;
        gbc_lblTitre.gridy = 0;
        panel_menu.add(lblTitre, gbc_lblTitre);
        lblTitre.setFont(new Font("Tahoma", Font.BOLD, 25));

        JButton btnAccueil = new JButton("Accueil");
        btnAccueil.setForeground(Color.WHITE);
        GridBagConstraints gbc_btnAccueil = new GridBagConstraints();
        gbc_btnAccueil.weighty = 1.0;
        gbc_btnAccueil.anchor = GridBagConstraints.SOUTHWEST;
        gbc_btnAccueil.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnAccueil.gridx = 0;
        gbc_btnAccueil.gridy = 8;
        panel_menu.add(btnAccueil, gbc_btnAccueil);

        JPanel panel_principal = new JPanel();
        panel_principal.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel_principal.setBackground(new Color(0xE2, 0xF0, 0xB6));
        contentPane.add(panel_principal, BorderLayout.CENTER);
        GridBagLayout gbl_panel_principal = new GridBagLayout();
        gbl_panel_principal.columnWidths = new int[] { 0, 0, 0, 0 };
        gbl_panel_principal.rowHeights = new int[] { 0, 0, 0 };
        gbl_panel_principal.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0 };
        gbl_panel_principal.rowWeights = new double[] { 0.0, 0.0, 0.0 };
        panel_principal.setLayout(gbl_panel_principal);

        JPanel panel_formulaire = new JPanel();
        panel_formulaire.setOpaque(false);
        panel_formulaire.setBorder(new CompoundBorder(new LineBorder(new Color(
                0, 0, 0), 2, true), new EmptyBorder(5, 5, 5, 5)));
        GridBagConstraints gbc_panel_formulaire = new GridBagConstraints();
        gbc_panel_formulaire.weightx = 1.0;
        gbc_panel_formulaire.fill = GridBagConstraints.BOTH;
        gbc_panel_formulaire.insets = new Insets(0, 0, 5, 0);
        gbc_panel_formulaire.gridwidth = 5;
        gbc_panel_formulaire.gridx = 0;
        gbc_panel_formulaire.gridy = 0;
        panel_principal.add(panel_formulaire, gbc_panel_formulaire);
        GridBagLayout gbl_panel_formulaire = new GridBagLayout();
        gbl_panel_formulaire.columnWidths = new int[] { 0, 0, 0, 0, 0, 0 };
        gbl_panel_formulaire.rowHeights = new int[] { 0, 0, 0, 0, 0 };
        gbl_panel_formulaire.columnWeights = new double[] { 1.0, 1.0, 1.0, 0.0,
                1.0, 0.0 };
        gbl_panel_formulaire.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,
                1.0 };
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
        GridBagConstraints gbc_txtCode = new GridBagConstraints();
        gbc_txtCode.gridwidth = 2;
        gbc_txtCode.weightx = 1.0;
        gbc_txtCode.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtCode.insets = new Insets(0, 0, 5, 5);
        gbc_txtCode.gridx = 1;
        gbc_txtCode.gridy = 0;
        panel_formulaire.add(txtCode, gbc_txtCode);
        txtCode.setColumns(10);



        JLabel lblDesignation = new JLabel("Désignation");
        GridBagConstraints gbc_lblDesignation = new GridBagConstraints();
        gbc_lblDesignation.anchor = GridBagConstraints.EAST;
        gbc_lblDesignation.insets = new Insets(0, 0, 5, 5);
        gbc_lblDesignation.gridx = 0;
        gbc_lblDesignation.gridy = 1;
        panel_formulaire.add(lblDesignation, gbc_lblDesignation);

        txtDesignation = new JTextField();
        GridBagConstraints gbc_txtDesignation = new GridBagConstraints();
        gbc_txtDesignation.gridwidth = 5;
        gbc_txtDesignation.insets = new Insets(0, 0, 5, 0);
        gbc_txtDesignation.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtDesignation.gridx = 1;
        gbc_txtDesignation.gridy = 1;
        panel_formulaire.add(txtDesignation, gbc_txtDesignation);
        txtDesignation.setColumns(10);


        JLabel lblQuantite = new JLabel("Quantité");
        GridBagConstraints gbc_lblQuantite = new GridBagConstraints();
        gbc_lblQuantite.anchor = GridBagConstraints.EAST;
        gbc_lblQuantite.insets = new Insets(0, 0, 5, 5);
        gbc_lblQuantite.gridx = 0;
        gbc_lblQuantite.gridy = 2;
        panel_formulaire.add(lblQuantite, gbc_lblQuantite);

        sliderQuantite = new JSlider(1, 20, 5);
        sliderQuantite.setOpaque(false);
        GridBagConstraints gbc_slider_quantite = new GridBagConstraints();
        gbc_slider_quantite.fill = GridBagConstraints.HORIZONTAL;
        gbc_slider_quantite.insets = new Insets(0, 0, 5, 5);
        gbc_slider_quantite.gridx = 1;
        gbc_slider_quantite.gridy = 2;
        panel_formulaire.add(sliderQuantite, gbc_slider_quantite);

        txtQuantite = new JTextField();
        txtQuantite.setEditable(false);
        GridBagConstraints gbc_quantite = new GridBagConstraints();
        gbc_quantite.insets = new Insets(0, 0, 5, 5);
        gbc_quantite.fill = GridBagConstraints.HORIZONTAL;
        gbc_quantite.gridx = 2;
        gbc_quantite.gridy = 2;
        panel_formulaire.add(txtQuantite, gbc_quantite);
        txtQuantite.setColumns(2);

        JLabel lblPrixUnitaire = new JLabel("Prix Unitaire");
        GridBagConstraints gbc_lblPrixUnitaire = new GridBagConstraints();
        gbc_lblPrixUnitaire.anchor = GridBagConstraints.EAST;
        gbc_lblPrixUnitaire.insets = new Insets(0, 20, 5, 5);
        gbc_lblPrixUnitaire.gridx = 3;
        gbc_lblPrixUnitaire.gridy = 2;
        panel_formulaire.add(lblPrixUnitaire, gbc_lblPrixUnitaire);

        NumberFormat format = NumberFormat.getNumberInstance();
        format.setMaximumFractionDigits(2);
        txtPrixUnitaire = new JFormattedTextField(format);
        txtPrixUnitaire.setText("0,00");
        txtPrixUnitaire.setHorizontalAlignment(SwingConstants.RIGHT);
        GridBagConstraints gbc_spinner_prix = new GridBagConstraints();
        gbc_spinner_prix.weightx = 1.0;
        gbc_spinner_prix.fill = GridBagConstraints.HORIZONTAL;
        gbc_spinner_prix.insets = new Insets(0, 0, 5, 5);
        gbc_spinner_prix.gridx = 4;
        gbc_spinner_prix.gridy = 2;
        txtPrixUnitaire.setColumns(10);
        panel_formulaire.add(txtPrixUnitaire, gbc_spinner_prix);

        JLabel lblMoney = new JLabel("€");
        GridBagConstraints gbc_lblMoney = new GridBagConstraints();
        gbc_lblMoney.anchor = GridBagConstraints.LINE_START;
        gbc_lblMoney.insets = new Insets(0, 0, 5, 0);
        gbc_lblMoney.gridx = 5;
        gbc_lblMoney.gridy = 2;
        panel_formulaire.add(lblMoney, gbc_lblMoney);

        JToolBar toolBar = new JToolBar();
        toolBar.setOpaque(false);
        GridBagConstraints gbc_toolBar = new GridBagConstraints();
        gbc_toolBar.gridwidth = 6;
        gbc_toolBar.insets = new Insets(0, 0, 5, 5);
        gbc_toolBar.gridx = 0;
        gbc_toolBar.gridy = 3;
        panel_formulaire.add(toolBar, gbc_toolBar);

        JButton btnAjouter = new JButton("Ajouter");
        toolBar.add(btnAjouter);
        btnAjouter.setHorizontalAlignment(SwingConstants.LEFT);
        btnAjouter.setForeground(Color.BLACK);

        JButton btnModifier = new JButton("Modifier");
        toolBar.add(btnModifier);
        btnModifier.setHorizontalAlignment(SwingConstants.LEFT);
        btnModifier.setForeground(Color.BLACK);

        JButton btnSupprimer = new JButton("Supprimer");
        toolBar.add(btnSupprimer);
        btnSupprimer.setHorizontalAlignment(SwingConstants.LEFT);
        btnSupprimer.setForeground(Color.BLACK);

        JButton btnAnnuler = new JButton("Effacer");
        toolBar.add(btnAnnuler);
        btnAnnuler.setHorizontalAlignment(SwingConstants.LEFT);
        btnAnnuler.setForeground(Color.BLACK);

        JPanel panel = new JPanel();
        panel.setOpaque(false);
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.gridwidth = 6;
        gbc_panel.fill = GridBagConstraints.BOTH;
        gbc_panel.gridx = 0;
        gbc_panel.gridy = 4;
        panel_formulaire.add(panel, gbc_panel);

        table = new JTable();


        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(table);
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.weighty = 1.0;
        gbc_scrollPane.weightx = 1.0;
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
        gbc_scrollPane.gridwidth = 5;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 1;

        panel_principal.add(scrollPane, gbc_scrollPane);

        JLabel lblTri = new JLabel("Trier par");

        GridBagConstraints gbc_lblTri = new GridBagConstraints();
        gbc_lblTri.anchor = GridBagConstraints.EAST;
        gbc_lblTri.insets = new Insets(0, 0, 5, 5);
        gbc_lblTri.gridx = 0;
        gbc_lblTri.gridy = 2;
        panel_principal.add(lblTri, gbc_lblTri);

        rdbtnCode = new JRadioButton("Code");
        rdbtnCode.setOpaque(false);
        GridBagConstraints gbc_rdbtnCode = new GridBagConstraints();
        gbc_rdbtnCode.insets = new Insets(0, 0, 5, 5);
        gbc_rdbtnCode.gridx = 1;
        gbc_rdbtnCode.gridy = 2;
        panel_principal.add(rdbtnCode, gbc_rdbtnCode);

        rdbtnCategorie = new JRadioButton("Catégorie");
        rdbtnCategorie.setOpaque(false);
        GridBagConstraints gbc_rdbtnCatgorie = new GridBagConstraints();
        gbc_rdbtnCatgorie.insets = new Insets(0, 0, 5, 5);
        gbc_rdbtnCatgorie.gridx = 2;
        gbc_rdbtnCatgorie.gridy = 2;
        panel_principal.add(rdbtnCategorie, gbc_rdbtnCatgorie);

        JLabel lblRecherche = new JLabel("Recherche");
        GridBagConstraints gbc_lblRecherche = new GridBagConstraints();
        gbc_lblRecherche.anchor = GridBagConstraints.WEST;
        gbc_lblRecherche.insets = new Insets(0, 20, 5, 5);
        gbc_lblRecherche.gridx = 3;
        gbc_lblRecherche.gridy = 2;
        panel_principal.add(lblRecherche, gbc_lblRecherche);

        txtRecherche = new JTextField();
        txtRecherche.setText("");
        GridBagConstraints gbc_txtRecherche = new GridBagConstraints();
        gbc_txtRecherche.insets = new Insets(0, 0, 5, 0);
        gbc_txtRecherche.weightx = 5.0;
        gbc_txtRecherche.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtRecherche.gridx = 4;
        gbc_txtRecherche.gridy = 2;
        panel_principal.add(txtRecherche, gbc_txtRecherche);
        txtRecherche.setColumns(10);


        SwingUtilities.invokeLater(() -> btnAccueil.requestFocusInWindow());
    }



}
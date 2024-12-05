package views;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.util.List;
import modele.UserDAO;

public class FCommandeClientSelectionView extends JDialog{

	private static final long serialVersionUID = 1L;
	
	private JList<String> clientList; 
    private String selectedClient;
    
    public FCommandeClientSelectionView(Window parent, List<String> clients) { 
    	super(parent, "Sélectionner un client");
    	System.out.println("Les commandes");
    	
    	clientList = new JList<>(clients.toArray(new String[0])); 
    	JButton selectClientButton = new JButton("Sélectionner"); 
    	selectClientButton.addActionListener(new ActionListener() { 
    		public void actionPerformed(ActionEvent e) { 
    			selectedClient = clientList.getSelectedValue(); 
    			dispose(); 
    		} 
    	}); 
    	
    	setLayout(new BorderLayout()); 
    	add(new JScrollPane(clientList), BorderLayout.CENTER); 
    	add(selectClientButton, BorderLayout.SOUTH); setSize(300, 200); 
    	setLocationRelativeTo(parent); 
    } 
    
    public String getSelectedClient() { 
    	return selectedClient; 
    }
		
}


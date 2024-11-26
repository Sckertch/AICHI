package Controler;

import views.FAcceuilView;
import views.FArticlesView;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.event.*;

public class FAccueilController {
    private final FAcceuilView view;

    public FAccueilController(FAcceuilView view) {
        this.view = view;
        System.out.println("testaceuill");
        view.addQuitterListener(new QuitterListener());
        view.addArticlesListener(new ArticlesListener());
        view.addClientsListener(new ClientsListener());
        view.addCommandesListener(new CommandesListener());
        
    }

    static class QuitterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    class ArticlesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setInfoText("Affichage des Articles");
            System.out.println("Article");
            afficherArticles();
        }
    }


    class ClientsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setInfoText("Affichage des Clients");
        }
    }

    class CommandesListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.setInfoText("Affichage des Commandes");
        }
    }

    protected void afficherArticles() {
        FArticlesView laFenetre = new FArticlesView(this);
        laFenetre.setVisible(true);
    }
    /* //A implémenter par la suite
    protected void afficherCommandes() {
        FCommandesView laFenetreC = new FCommandesView(this);
        laFenetreC.setVisible(true);
    }

    */
}
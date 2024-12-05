package Controler;

import modele.Article;
import views.FArticlesView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FArticlesController {

    private final FArticlesView view;
    private final List<Article> articles; // Liste pour stocker les articles

    public FArticlesController(FArticlesView view) {
        this.view = view;
        this.articles = new ArrayList<>(); // Initialise la liste des articles

        // Initialiser les actions
        initListeners();
    }

    private void initListeners() {
        // Listener pour ajouter un article
        view.addAddArticleListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajouterArticle();
            }
        });

        // Listener pour modifier un article
        view.addModifyArticleListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifierArticle();
            }
        });

        // Listener pour supprimer un article
        view.addDeleteArticleListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supprimerArticle();
            }
        });

        // Listener pour effacer les champs
        view.addClearFieldsListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                effacerChamps();
            }
        });
    }

    private void ajouterArticle() {
        try {
            int code = Integer.parseInt(view.getTxtCode().getText());
            String designation = view.getTxtDesignation().getText();
            int quantite = view.getSliderQuantite().getValue();
            double prix = Double.parseDouble(view.getTxtPrixUnitaire().getText());

            Article article = new Article(code, designation, quantite, prix);
            articles.add(article);
            view.showSuccessMessage("Article ajouté avec succès !");
            mettreAJourTable();
        } catch (NumberFormatException e) {
            view.showErrorMessage("Erreur de format : Veuillez vérifier les champs.");
        }
    }

    private void modifierArticle() {
        int selectedRow = view.getSelectedTableRow();
        if (selectedRow >= 0 && selectedRow < articles.size()) {
            try {
                int code = Integer.parseInt(view.getTxtCode().getText());
                String designation = view.getTxtDesignation().getText();
                int quantite = view.getSliderQuantite().getValue();
                double prix = Double.parseDouble(view.getTxtPrixUnitaire().getText());

                Article article = articles.get(selectedRow);
                article.setCode(code);
                article.setDesignation(designation);
                article.setQuantite(quantite);
                article.setPrixUnitaire(prix);

                view.showSuccessMessage("Article modifié avec succès !");
                mettreAJourTable();
            } catch (NumberFormatException e) {
                view.showErrorMessage("Erreur de format : Veuillez vérifier les champs.");
            }
        } else {
            view.showErrorMessage("Veuillez sélectionner un article à modifier.");
        }
    }

    private void supprimerArticle() {
        int selectedRow = view.getSelectedTableRow();
        if (selectedRow >= 0 && selectedRow < articles.size()) {
            articles.remove(selectedRow);
            view.showSuccessMessage("Article supprimé avec succès !");
            mettreAJourTable();
        } else {
            view.showErrorMessage("Veuillez sélectionner un article à supprimer.");
        }
    }

    private void effacerChamps() {
        view.clearFields();
    }

    private void mettreAJourTable() {
        view.updateTable(articles);
    }
}

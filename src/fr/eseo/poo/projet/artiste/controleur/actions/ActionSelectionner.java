package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilSelectionner;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionSelectionner extends AbstractAction {

	public static final String NOM_ACTION = "Selectionner";
	public PanneauDessin panneauDessin = null;
	
	public ActionSelectionner(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		this.panneauDessin.associerOutil(new OutilSelectionner());
	}
}
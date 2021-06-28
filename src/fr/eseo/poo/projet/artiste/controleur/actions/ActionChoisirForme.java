package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionChoisirForme extends AbstractAction {

	public static final String NOM_ACTION_LIGNE = "Ligne";
	public static final String NOM_ACTION_ELLIPSE = "Ellipse";
	public static final String NOM_ACTION_CERCLE = "Cercle";
	
	private PanneauDessin panneauDessin = null;
	
	@SuppressWarnings("unused")
	private PanneauBarreOutils panneauOutils = null;
	private String action = null;
	
	public ActionChoisirForme(PanneauDessin panneauDessin, PanneauBarreOutils panneauOutils, String action) {
		super(action);
		this.panneauDessin = panneauDessin;
		this.panneauOutils = panneauOutils;
		this.action = action;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		switch (this.action) {
			case NOM_ACTION_LIGNE :
				this.panneauDessin.associerOutil(new OutilLigne());
				break;
			
			case NOM_ACTION_ELLIPSE :
				this.panneauDessin.associerOutil(new OutilEllipse());
				break;
				
			case NOM_ACTION_CERCLE :
				this.panneauDessin.associerOutil(new OutilCercle());
				break;
		}
	}
}
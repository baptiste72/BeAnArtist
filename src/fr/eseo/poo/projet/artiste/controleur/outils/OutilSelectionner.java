package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class OutilSelectionner extends Outil {
	
	@Override
	public void mouseClicked(MouseEvent event) {
		Forme formeSelectionnee = null;
		
		super.mouseClicked(event);
		
		formeSelectionnee = this.getFormeSelect();		
		
		if (formeSelectionnee != null) {
			JOptionPane.showConfirmDialog(getPanneauDessin(), formeSelectionnee.toString(), 
					ActionSelectionner.NOM_ACTION, JOptionPane.INFORMATION_MESSAGE);			
		}
	}
	
	private Forme getFormeSelect() {
		Forme forme = null;
		
		for (VueForme vueForme : getPanneauDessin().getVueFormes()) {
			if (vueForme.getForme().contient(getDebut()))
				forme = vueForme.getForme();
		}
		
		return forme;
	}
}
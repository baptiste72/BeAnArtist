package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionEffacer extends AbstractAction {
	
	public static final String NOM_ACTION = "Effacer Tout";
	private PanneauDessin panneauDessin = null;
	
	public ActionEffacer(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		String message = "Confirmer votre choix ?";
	    
		if (JOptionPane.showConfirmDialog(this.panneauDessin, message, NOM_ACTION, JOptionPane.YES_NO_OPTION) == 0) {
			this.panneauDessin.getVueFormes().clear();
			this.panneauDessin.repaint();
		}
	}
}
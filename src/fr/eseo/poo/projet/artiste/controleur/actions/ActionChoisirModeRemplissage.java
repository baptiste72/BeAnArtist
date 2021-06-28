package fr.eseo.poo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JCheckBox;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionChoisirModeRemplissage extends AbstractAction {

	public static final String NOM_ACTION = "Remplissage";
	private PanneauDessin panneauDessin = null;
	
	public ActionChoisirModeRemplissage(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		JCheckBox modeRemplissage = (JCheckBox) event.getSource();
        
		if (modeRemplissage.isSelected())
            this.panneauDessin.setModeRemplissage(true);
		
		else
			this.panneauDessin.setModeRemplissage(false);
	}
}
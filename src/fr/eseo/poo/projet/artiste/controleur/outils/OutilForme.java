package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public abstract class OutilForme extends Outil {
	
	@Override
	public void mouseClicked(MouseEvent event) {
		
		if (event.getClickCount() == 2 && getDebut().equals(getFin())) {
			setFin(new Coordonnees(event.getPoint().getX() + Forme.LARGEUR_PAR_DEFAUT,
					event.getPoint().getY() + Forme.HAUTEUR_PAR_DEFAUT));
			getPanneauDessin().ajouterVueForme(this.creerVueForme());
			//super.getPanneauDessin().repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		super.mouseReleased(event);
		
		if (!getDebut().equals(getFin())) {
			getPanneauDessin().ajouterVueForme(this.creerVueForme());
			//super.getPanneauDessin().repaint();
		}
	}
	
	protected abstract VueForme creerVueForme();
}
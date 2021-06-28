package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Graphics2D;

import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;

public class VueEllipse extends VueForme {

	public VueEllipse(Ellipse ellipse) {
		super(ellipse);
	}

	@Override
	public void affiche(Graphics2D g2d) {
		Ellipse ellipse = (Ellipse) getForme();
		g2d.setColor(ellipse.getCouleur());
	
		if (((Ellipse) this.getForme()).estRempli()) {
			g2d.fillOval((int) this.getForme().getPosition().getAbscisse(), 
					(int) this.getForme().getPosition().getOrdonnee(),
					(int) this.getForme().getLargeur(), 
					(int) this.getForme().getHauteur());
		}
			
		g2d.drawOval((int) Math.round(ellipse.getPosition().getAbscisse()),
				(int) Math.round(ellipse.getPosition().getOrdonnee()),
				(int) Math.round(ellipse.getLargeur()),
				(int) Math.round(ellipse.getHauteur()));
	}
}
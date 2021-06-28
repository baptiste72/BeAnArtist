package fr.eseo.poo.projet.artiste.vue.formes;

import java.awt.Graphics2D;

import fr.eseo.poo.projet.artiste.modele.formes.Ligne;

public class VueLigne extends VueForme {

	public VueLigne(Ligne ligne) {
		super(ligne);
	}

	@Override
	public void affiche(Graphics2D g2d) {
		Ligne ligne = (Ligne) getForme();
		g2d.setColor(ligne.getCouleur());
		
		g2d.drawLine((int) Math.round(ligne.getC1().getAbscisse()),
				(int) Math.round(ligne.getC1().getOrdonnee()),
				(int) Math.round(ligne.getC2().getAbscisse()),
				(int) Math.round(ligne.getC2().getOrdonnee()));
	}
}
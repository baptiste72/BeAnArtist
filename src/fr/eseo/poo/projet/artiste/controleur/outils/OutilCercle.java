package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.vue.formes.VueCercle;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class OutilCercle extends OutilForme {
	
	@Override
	protected VueForme creerVueForme() {
		double abscisse = 0, ordonnee = 0;
		double diametre =  Math.max(Math.abs(super.getFin().getAbscisse() - super.getDebut().getAbscisse()), 
				Math.abs(super.getFin().getOrdonnee() - super.getDebut().getOrdonnee()));
		
		if (super.getFin().getAbscisse() > super.getDebut().getAbscisse())
			abscisse = super.getDebut().getAbscisse();
		else
			abscisse = super.getDebut().getAbscisse() - diametre;
		
		if (super.getFin().getOrdonnee() > super.getDebut().getOrdonnee())
			ordonnee = super.getDebut().getOrdonnee();
		else
			ordonnee = super.getDebut().getOrdonnee() - diametre;
		
		Cercle cercle = new Cercle(new Coordonnees(abscisse, ordonnee), diametre);
		cercle.setCouleur(getPanneauDessin().getCouleurCourante());
		
		return new VueCercle(cercle);

	}

	@Override
	public void mouseClicked(MouseEvent event) {
		super.mouseClicked(event);
	}
}
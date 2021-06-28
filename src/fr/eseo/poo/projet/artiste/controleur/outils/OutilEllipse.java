package fr.eseo.poo.projet.artiste.controleur.outils;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.vue.formes.VueEllipse;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

public class OutilEllipse extends OutilForme {

	@Override
	protected VueForme creerVueForme() {
		Ellipse ellipse = new Ellipse(new Coordonnees(Math.min(super.getDebut().getAbscisse(), super.getFin().getAbscisse()),
				Math.min(super.getDebut().getOrdonnee(), super.getFin().getOrdonnee())), 
				Math.abs(super.getDebut().getAbscisse() - super.getFin().getAbscisse()), 
				Math.abs(super.getDebut().getOrdonnee() - super.getFin().getOrdonnee()));
		
		ellipse.setCouleur(getPanneauDessin().getCouleurCourante());
		ellipse.setRempli(this.getPanneauDessin().getModeRemplissage());
		return new VueEllipse(ellipse);
	}
}
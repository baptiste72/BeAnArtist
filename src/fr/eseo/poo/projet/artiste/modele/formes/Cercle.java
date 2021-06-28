package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class Cercle extends Ellipse {

	public Cercle() {
		super(LARGEUR_PAR_DEFAUT, LARGEUR_PAR_DEFAUT);
	}
	
	public Cercle(Coordonnees coordonnees) {
		super(coordonnees, LARGEUR_PAR_DEFAUT, LARGEUR_PAR_DEFAUT);
	}
	
	public Cercle(double taille) {
		super(taille, taille);
	}

	public Cercle(Coordonnees coordonnees, double taille) {
		super(coordonnees, taille, taille);
	}
	
	public void setLargeur(double largeur) {
		super.setLargeur(largeur);
		super.setHauteur(largeur);
	}
	
	public void setHauteur(double hauteur) {
		super.setHauteur(hauteur);
		super.setLargeur(hauteur);
	}

	@Override
	public double perimetre() {
		return 2 * Math.PI * super.getLargeur() / 2;
	}
	
	@Override
	public String toString() {
		// Feat Gabin
		DecimalFormat decimalFormat = new DecimalFormat("0.0#");
		String chaine = (Locale.getDefault().getLanguage() == "fr") ?
				" couleur = R" + getCouleur().getRed() + ",V" + getCouleur().getGreen() + ",B" + getCouleur().getBlue() :
				" couleur = R" + getCouleur().getRed() + ",G" + getCouleur().getGreen() + ",B" + getCouleur().getBlue();
		
		return (this.estRempli() ? "[Cercle-Rempli]" : "[Cercle]") + " : pos " +
			super.getPosition() + " dim " + decimalFormat.format(super.getLargeur()) + " x " + 
			decimalFormat.format(super.getHauteur()) + " périmètre : " + decimalFormat.format(this.perimetre()) + " aire : " +
			decimalFormat.format(this.aire()) + chaine;
	}
}
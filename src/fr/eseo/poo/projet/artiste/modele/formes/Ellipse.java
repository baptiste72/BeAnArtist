package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.Remplissable;

public class Ellipse extends Forme implements Remplissable {

	private boolean remplissage = false;
	
	public Ellipse() {
		this(new Coordonnees());
	}
	
	public Ellipse(Coordonnees position) {
		this(position, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}

	public Ellipse(double largeur, double hauteur) {
		this(new Coordonnees(), largeur, hauteur);
	}

	public Ellipse(Coordonnees position, double largeur, double hauteur) {
		super.setPosition(position);
		this.setLargeur(largeur);
		this.setHauteur(hauteur);
		this.setRempli(this.estRempli());
	}
	
	public void setLargeur(double largeur) {
		if (largeur < 0)
			throw new IllegalArgumentException("La largeur ne peut pas être négative !");
		else
			super.setLargeur(largeur);
	}
	
	public void setHauteur(double hauteur) {
		if (hauteur < 0)
			throw new IllegalArgumentException("La hauteur ne peut pas être négative !");
		else
			super.setHauteur(hauteur);
	}
	
	@Override
	public boolean contient(Coordonnees coordonnees) {
		double a = super.getHauteur() / 2;
		double b = super.getLargeur() / 2;
		Coordonnees centre = new Coordonnees(super.getCadreMinX() + b, super.getCadreMinY() + a);
		
		return Math.pow(coordonnees.getAbscisse() - centre.getAbscisse(), 2) / Math.pow(b, 2) + 
				Math.pow(coordonnees.getOrdonnee() - centre.getOrdonnee(), 2) / Math.pow(a, 2) <= 1;
	}

	@Override
	public double perimetre() {
		double a = super.getHauteur() / 2;
		double b = super.getLargeur() / 2;
		double h = Math.pow((a - b) / (a + b), 2);
		
		return Math.PI * (a + b) * (1 + (3 * h) / (10 + Math.sqrt(4 - 3 * h)));
	}

	@Override
	public double aire() {
		double a = super.getHauteur() / 2;
		double b = super.getLargeur() / 2;
		
		return Math.PI * a * b;
	}

	@Override
	public boolean estRempli() {
		return this.remplissage;
	}

	@Override
	public void setRempli(boolean modeRemplissage) {
		this.remplissage = modeRemplissage;
	}

	@Override
	public String toString() {
		DecimalFormat decimalFormat = new DecimalFormat("0.0#");
		String chaine = (Locale.getDefault().getLanguage() == "fr") ?
				" couleur = R" + getCouleur().getRed() + ",V" + getCouleur().getGreen() + ",B" + getCouleur().getBlue() :
				" couleur = R" + getCouleur().getRed() + ",G" + getCouleur().getGreen() + ",B" + getCouleur().getBlue();
		
		return (this.estRempli() ? "[Ellipse-Rempli]" : "[Ellipse]") + " : pos " +
			super.getPosition() + " dim " + decimalFormat.format(super.getLargeur()) + " x " + 
			decimalFormat.format(super.getHauteur()) + " périmètre : " + decimalFormat.format(this.perimetre()) + " aire : " +
			decimalFormat.format(this.aire()) + chaine;
	}
}
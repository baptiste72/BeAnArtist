package fr.eseo.poo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class Ligne extends Forme {
	
	public static final double EPSILON = 0.01;
	
	public Ligne() {
		super();
	}
	
	public Ligne(Coordonnees coordonnees) {
		super(coordonnees);
	}

	public Ligne(double largeur, double hauteur) {
		super(largeur, hauteur);
	}
	
	public Ligne(Coordonnees coordonnees, double largeur, double hauteur) {
		super(coordonnees, largeur, hauteur);
	}
	
	public Coordonnees getC1() {
		return super.getPosition();
	}
	
	public void setC1(Coordonnees coordonnees) {
		super.setLargeur(this.getC2().getAbscisse() - coordonnees.getAbscisse());
		super.setHauteur(this.getC2().getOrdonnee() - coordonnees.getOrdonnee());
		this.setPosition(coordonnees);
	}
	
	public Coordonnees getC2() {
		return new Coordonnees(this.getC1().getAbscisse() + super.getLargeur(), this.getC1().getOrdonnee() + 
				super.getHauteur());
	}
	
	public void setC2(Coordonnees coordonnees) {
		super.setLargeur(coordonnees.getAbscisse() - this.getC1().getAbscisse());
		super.setHauteur(coordonnees.getOrdonnee() - this.getC1().getOrdonnee());
	}
	
	@Override
	public void setPosition(Coordonnees coordonnees) {
		super.setPosition(coordonnees);
	}
	
	@Override
	public boolean contient(Coordonnees coordonnees) {
		return this.getC1().distanceVers(coordonnees) + this.getC2().distanceVers(coordonnees) - 
				this.getC1().distanceVers(this.getC2()) <= EPSILON;
	}
	
	@Override
	public double perimetre() {
		return Math.sqrt(Math.pow(super.getLargeur(), 2) + Math.pow(super.getHauteur(), 2));
	}
	
	@Override
	public double aire() {
		return 0;
	}
	
	@Override
	public String toString() {
		DecimalFormat decimalFormat = new DecimalFormat("0.0#");
		String chaine = (Locale.getDefault().getLanguage() == "fr") ?
				" couleur = R" + getCouleur().getRed() + ",V" + getCouleur().getGreen() + ",B" + getCouleur().getBlue() :
				" couleur = R" + getCouleur().getRed() + ",G" + getCouleur().getGreen() + ",B" + getCouleur().getBlue();
		
		double angle = this.getC1().angleVers(this.getC2());
		
		if (angle < 0)
			angle += 2 * Math.PI;
		
		return "[" + this.getClass().getSimpleName() + "] c1 : " + this.getC1() + " c2 : " + this.getC2() + 
				" longueur : " + decimalFormat.format(this.perimetre()) + " angle : " + 
				decimalFormat.format(Math.toDegrees(angle)) + "°" + chaine;
	}
}
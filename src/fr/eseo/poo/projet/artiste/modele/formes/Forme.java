package fr.eseo.poo.projet.artiste.modele.formes;

import java.awt.Color;

import javax.swing.UIManager;

import fr.eseo.poo.projet.artiste.modele.Coloriable;
import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public abstract class Forme implements Coloriable {
	
	public static final double LARGEUR_PAR_DEFAUT = 40, HAUTEUR_PAR_DEFAUT = 20;
	public static final Color COULEUR_PAR_DEFAUT = UIManager.getColor("Panel.foreground");
	private double largeur, hauteur;
	private Coordonnees position;
	private Color color;

	public Forme() {
		this(new Coordonnees());
	}
	
	public Forme(Coordonnees position) {
		this(position, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}
	
	public Forme(double largeur, double hauteur) {
		this(new Coordonnees(), largeur, hauteur);
	}
	
	public Forme(Coordonnees position, double largeur, double hauteur) {
		this.setPosition(position);
		this.setLargeur(largeur);
		this.setHauteur(hauteur);
		this.setCouleur(COULEUR_PAR_DEFAUT);
	}
	
	public Coordonnees getPosition() {
		return this.position;
	}
	
	public void setPosition(Coordonnees position) {
		this.position = position;
	}
	
	public double getLargeur() {
		return this.largeur;
	}
	
	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}
	
	public double getHauteur() {
		return this.hauteur;
	}
	
	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}
	
	public double getCadreMinX() {
		double minX = this.getPosition().getAbscisse();
		
		return (minX > minX + this.getLargeur()) ? minX + this.getLargeur() : minX;
	}
	
	public double getCadreMinY() {
		double minY = this.getPosition().getOrdonnee();
		
		return (minY > minY + this.getHauteur()) ? minY + this.getHauteur() : minY;
	}
	
	public double getCadreMaxX() {
		double maxX = this.getPosition().getAbscisse() + this.getLargeur();
		
		return (maxX < this.getPosition().getAbscisse()) ? this.getPosition().getAbscisse() : maxX;
	}
	
	public double getCadreMaxY() {
		double maxY = this.getPosition().getOrdonnee() + this.getHauteur();
		
		return (maxY < this.getPosition().getOrdonnee()) ? this.getPosition().getOrdonnee() : maxY;
	}
	
	public void deplacerDe(double deltaX, double deltaY) {
		this.getPosition().deplacerDe(deltaX, deltaY);
	}

	public void deplacerVers(double nouvelleAbscisse, double nouvelleOrdonnee) {
		this.getPosition().deplacerVers(nouvelleAbscisse, nouvelleOrdonnee);
	}
	
	@Override
	public Color getCouleur() {
		return this.color;
	}

	@Override
	public void setCouleur(Color color) {
		this.color = color;
	}
	
	public abstract boolean contient(Coordonnees coordonnees);
	
	public abstract double perimetre();
	
	public abstract double aire();
}
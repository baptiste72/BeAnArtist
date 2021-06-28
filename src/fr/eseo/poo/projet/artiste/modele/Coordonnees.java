package fr.eseo.poo.projet.artiste.modele;

import java.text.DecimalFormat;

public class Coordonnees {
	
	public static final double ABSCISSE_PAR_DEFAUT = 0, ORDONNEE_PAR_DEFAUT = 0;
	private double abscisse, ordonnee;
	
	public Coordonnees() {
		this(ABSCISSE_PAR_DEFAUT, ORDONNEE_PAR_DEFAUT);
	}
	
	public Coordonnees(double abscisse, double ordonnee) {
		this.setAbscisse(abscisse);
		this.setOrdonnee(ordonnee);
	}
	
	public double getAbscisse() {
		return this.abscisse;
	}
	
	public void setAbscisse(double abscisse) {
		this.abscisse = abscisse;
	}
	
	public double getOrdonnee() {
		return this.ordonnee;
	}
	
	public void setOrdonnee(double ordonnee) {
		this.ordonnee = ordonnee;
	}
	
	public void deplacerDe(double deltaX, double deltaY) {
		this.setAbscisse(this.getAbscisse() + deltaX);
		this.setOrdonnee(this.getOrdonnee() + deltaY);
	}
	
	public void deplacerVers(double nouvelleAbscisse, double nouvelleOrdonnee) {
		this.setAbscisse(nouvelleAbscisse);
		this.setOrdonnee(nouvelleOrdonnee);
	}
	
	public double distanceVers(Coordonnees autreCoordonnees) {
		return Math.sqrt(Math.pow(this.getAbscisse() - autreCoordonnees.getAbscisse(), 2) + Math.pow(this.getOrdonnee() - autreCoordonnees.getOrdonnee(), 2));
	}
	
	public double angleVers(Coordonnees autreCoordonnees) {
		double angle = Math.asin((autreCoordonnees.getOrdonnee() - this.getOrdonnee()) / this.distanceVers(autreCoordonnees));
		
		if (this.getAbscisse() > autreCoordonnees.getAbscisse())
			angle = (this.getOrdonnee() > autreCoordonnees.getOrdonnee()) ? -Math.PI - angle : Math.PI - angle;
		
		return angle;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Coordonnees)) {
			return false;
		}
		Coordonnees other = (Coordonnees) obj;
		if (Double.doubleToLongBits(abscisse) != Double.doubleToLongBits(other.abscisse)) {
			return false;
		}
		if (Double.doubleToLongBits(ordonnee) != Double.doubleToLongBits(other.ordonnee)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		DecimalFormat decimalFormat = new DecimalFormat("0.0#");
		
		return "(" + decimalFormat.format(this.getAbscisse()) + " , " + decimalFormat.format(this.getOrdonnee()) + ")";
	}
}
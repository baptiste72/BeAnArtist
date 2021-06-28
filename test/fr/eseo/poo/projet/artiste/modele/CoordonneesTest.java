package fr.eseo.poo.projet.artiste.modele;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CoordonneesTest {

	private static final double EPSILON = 0.01;
	
	// Couverture des instructions des constructeurs : 100% (14/14)
	
	@Test
	public void testConstructeurSansParam() {
		Coordonnees coordonnees = new Coordonnees();
		
		assertEquals("Abscisse incorrect : ", 0, coordonnees.getAbscisse(), EPSILON);
		assertEquals("Ordonnee incorrect : ", 0, coordonnees.getOrdonnee(), EPSILON);
	}
	
	@Test
	public void testConstructeurAvecParam() {
		Coordonnees coordonnees = new Coordonnees(2.3, -4.5);
		
		assertEquals("Abscisse incorrect : ", 2.3, coordonnees.getAbscisse(), EPSILON);
		assertEquals("Ordonnee incorrect : ", -4.5, coordonnees.getOrdonnee(), EPSILON);
	}
	
	// Converture des instructions de la méthode deplacerDe() : 100% (13/13)
	
	@Test
	public void testDeplacerDe() {
		Coordonnees coordonnees = new Coordonnees(2.3, -4.5);
		
		coordonnees.deplacerDe(-6.7, 8.9);
		
		assertEquals("Abscisse incorrect : ", -4.4, coordonnees.getAbscisse(), EPSILON);
		assertEquals("Ordonnee incorrect : ", 4.4, coordonnees.getOrdonnee(), EPSILON);
	}
	
	// Converture des instructions de la méthode deplacerVers() : 100% (7/7)
	
	@Test
	public void testDeplacerVers() {
		Coordonnees coordonnees = new Coordonnees(2.3, -4.5);
		
		coordonnees.deplacerVers(-6.7, 8.9);
		
		assertEquals("Abscisse incorrect : ", -6.7, coordonnees.getAbscisse(), EPSILON);
		assertEquals("Ordonnee incorrect : ", 8.9, coordonnees.getOrdonnee(), EPSILON);
	}
}
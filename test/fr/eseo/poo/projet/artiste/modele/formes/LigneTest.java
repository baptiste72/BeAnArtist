package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class LigneTest {

	private static final double EPSILON = 0.01;
	
	// Couverture des instructions des constructeurs : 100% (18/18)
	
	@Test
	public void testConstructeurSansParam() {
		Ligne ligne = new Ligne();
		
		assertEquals("Position incorrect : ", new Coordonnees(), ligne.getPosition());
		assertEquals("Largeur incorrect : ", 40, ligne.getLargeur(), EPSILON);
		assertEquals("Hauteur incorrect : ", 20, ligne.getHauteur(), EPSILON);
	}
	
	@Test
	public void testConstructeurAvecUnParam() {
		Ligne ligne = new Ligne(new Coordonnees(-10, 15));
		
		assertEquals("Position incorrect : ", new Coordonnees(-10, 15), ligne.getPosition());
		assertEquals("Largeur incorrect : ", 40, ligne.getLargeur(), EPSILON);
		assertEquals("Hauteur incorrect : ", 20, ligne.getHauteur(), EPSILON);
	}
	
	@Test
	public void testConstructeurAvecDeuxParam() {
		Ligne ligne = new Ligne(50, -30);
		
		assertEquals("Position incorrect : ", new Coordonnees(0, 0), ligne.getPosition());
		assertEquals("Largeur incorrect : ", 50, ligne.getLargeur(), EPSILON);
		assertEquals("Hauteur incorrect : ", -30, ligne.getHauteur(), EPSILON);
	}
	
	@Test
	public void testConstructeurAvecTroisParam() {
		Ligne ligne = new Ligne(new Coordonnees(10, -15), -50, 30);
		
		assertEquals("Position incorrect : ", new Coordonnees(10, -15), ligne.getPosition());
		assertEquals("Largeur incorrect : ", -50, ligne.getLargeur(), EPSILON);
		assertEquals("Hauteur incorrect : ", 30, ligne.getHauteur(), EPSILON);
	}
	
	// Couverture des instructions de la méthode deplacerDe() : 100% (6/6)
	
	@Test
	public void testDeplacerDe() {
		Ligne ligne = new Ligne(new Coordonnees(30, -20));
		
		ligne.deplacerDe(-10, 15);
		
		assertEquals("Position incorrect : ", new Coordonnees(20, -5), ligne.getPosition());
		assertEquals("Largeur incorrect : ", 40, ligne.getLargeur(), EPSILON);
		assertEquals("Hauteur incorrect : ", 20, ligne.getHauteur(), EPSILON);
	}
	
	// Couverture des instructions de la méhode deplacerVers() : 100% (6/6)
	
	@Test
	public void testDeplacerVers() {
		Ligne ligne = new Ligne(new Coordonnees(30, -20));
		
		ligne.deplacerVers(-10, 15);
		
		assertEquals("Position incorrect : ", new Coordonnees(-10, 15), ligne.getPosition());
		assertEquals("Largeur incorrect : ", 40, ligne.getLargeur(), EPSILON);
		assertEquals("Hauteur incorrect : ", 20, ligne.getHauteur(), EPSILON);
	}
	
	// Couverture des instructions de la méthode contient() : 100% (22/22)
	// Couverture des branches de la méthode contient() : 100% (2/2)
	
	@Test
	public void testContient() {
		assertTrue("La ligne ne contient pas cette coordonnée !", new Ligne().contient(new Coordonnees(20, 10)));
		assertFalse("La ligne contient cette coordonnée !", new Ligne().contient(new Coordonnees(20, 11)));
	}
	
	// Couverture des instructions de la méthode aire() : 100% (2/2)
	
	@Test
	public void testAire() {
		assertEquals("Aire incorrect : ", 0, new Ligne().aire(), EPSILON);
	}
	
	// Couverture des instructions de la méthode toString() : 100% (49/49)
	// Couverture des branches de la méthode toString() : 100% (2/2)
	
	@Test
	public void testToString() {
		assertEquals("Chaine incorrect : ", "[Ligne] c1 : (10,0 , 10,0) c2 : (5,0 , 30,0) longueur : 20,62 "
				+ "angle : 104,04° couleur = R51,V51,B51", new Ligne(new Coordonnees(10, 10), -5, 20).toString());
		assertEquals("Chaine incorrect : ", "[Ligne] c1 : (77,0 , 177,0) c2 : (233,0 , 77,0) longueur : 185,3 "
				+ "angle : 327,34° couleur = R51,V51,B51", new Ligne(new Coordonnees(77, 177), 156, -100).toString());
	}
}
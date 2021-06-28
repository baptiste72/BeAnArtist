package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class EllipseTest {

	private static final double EPSILON = 0.01;
	
	// Couverture des instructions des constructeurs : 100% (32/32)
	
	@Test
	public void testConstructeurSansParam() {
		Ellipse ellipse = new Ellipse();
		
		assertEquals("Position incorrect : ", new Coordonnees(), ellipse.getPosition());
		assertEquals("Largeur incorrect : ", 40, ellipse.getLargeur(), EPSILON);
		assertEquals("Hauteur incorrect : ", 20, ellipse.getHauteur(), EPSILON);
	}
	
	@Test
	public void testConstructeurAvecUnParam() {
		Ellipse ellipse = new Ellipse(new Coordonnees(-10, 15));
		
		assertEquals("Position incorrect : ", new Coordonnees(-10, 15), ellipse.getPosition());
		assertEquals("Largeur incorrect : ", 40, ellipse.getLargeur(), EPSILON);
		assertEquals("Hauteur incorrect : ", 20, ellipse.getHauteur(), EPSILON);
	}
	
	@Test
	public void testConstructeurAvecDeuxParam() {
		Ellipse ellipse = new Ellipse(50, 30);
		
		assertEquals("Position incorrect : ", new Coordonnees(0, 0), ellipse.getPosition());
		assertEquals("Largeur incorrect : ", 50, ellipse.getLargeur(), EPSILON);
		assertEquals("Hauteur incorrect : ", 30, ellipse.getHauteur(), EPSILON);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructeurAvecDeuxParamExeption() {
		Ellipse ellipse = new Ellipse(50, -30);
		
		assertEquals("Position incorrect : ", new Coordonnees(0, 0), ellipse.getPosition());
		assertEquals("Largeur incorrect : ", 50, ellipse.getLargeur(), EPSILON);
		assertEquals("Hauteur incorrect : ", null, ellipse.getHauteur());
	}
	
	@Test
	public void testConstructeurAvecTroisParam() {
		Ellipse ellipse = new Ellipse(new Coordonnees(10, -15), 50, 30);
		
		assertEquals("Position incorrect : ", new Coordonnees(10, -15), ellipse.getPosition());
		assertEquals("Largeur incorrect : ", 50, ellipse.getLargeur(), EPSILON);
		assertEquals("Hauteur incorrect : ", 30, ellipse.getHauteur(), EPSILON);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructeurAvecTroisParamExeption() {
		Ellipse ellipse = new Ellipse(new Coordonnees(10, -15), -50, 30);
		
		assertEquals("Position incorrect : ", new Coordonnees(10, -15), ellipse.getPosition());
		assertEquals("Largeur incorrect : ", null, ellipse.getLargeur());
		assertEquals("Hauteur incorrect : ", 30, ellipse.getHauteur(), EPSILON);
	}
	
	// Couverture des instructions de la méthode contient() : 100% (52/52)
	// Couverture des branches de la méthode contient() : 100% (2/2)
	
	@Test
	public void testContient() {
		Ellipse ellipse = new Ellipse();
		Ellipse autreEllipse = new Ellipse(new Coordonnees(), 20, 40);
		
		assertTrue("L'ellipse ne contient pas cette coordonnée !", ellipse.contient(new Coordonnees(30, 15)));
		assertFalse("L'ellipse contient cette coordonnée !", ellipse.contient(new Coordonnees(40, 20)));
		assertTrue("L'ellipse ne contient pas cette coordonnée !", autreEllipse.contient(new Coordonnees(5, 10)));
		assertFalse("L'ellipse contient cette coordonnée !", autreEllipse.contient(new Coordonnees(20, 10)));
	}
	
	// Couverture des instructions de la méthode toString() : 100% (48/48)
	
	@Test
	public void testToString() {
		assertEquals("Chaine incorrect : ", "[Ellipse] : pos (10,0 , 10,0) dim 25,0 x 15,0 périmètre : 63,82 aire : "
				+ "294,52 couleur = R51,V51,B51",
				new Ellipse(new Coordonnees(10, 10), 25, 15).toString());
		assertEquals("Chaine incorrect : ", "[Ellipse] : pos (2,0 , 200,0) dim 100,0 x 50,0 périmètre : 242,21 aire : "
				+ "3926,99 couleur = R51,V51,B51", 
				new Ellipse(new Coordonnees(2, 200), 100, 50).toString());
	}
}
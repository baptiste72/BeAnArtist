package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

public class CercleTest {

	private static final double EPSILON = 0.01;
	
	// Couverture des instructions des constructeurs : 100% (22/22)
	
	@Test
	public void testConstructeurSansParam() {
		Cercle cercle = new Cercle();
		
		assertEquals("Position incorrect : ", new Coordonnees(), cercle.getPosition());
		assertEquals("Largeur incorrect : ", 40, cercle.getLargeur(), EPSILON);
		assertEquals("Hauteur incorrect : ", 40, cercle.getHauteur(), EPSILON);
	}
	
	@Test
	public void testConstructeurAvecUnParam() {
		Cercle cercle = new Cercle(new Coordonnees(-10, 15));
		Cercle autreCercle = new Cercle(50);
		
		assertEquals("Position incorrect : ", new Coordonnees(-10, 15), cercle.getPosition());
		assertEquals("Largeur incorrect : ", 40, cercle.getLargeur(), EPSILON);
		assertEquals("Hauteur incorrect : ", 40, cercle.getHauteur(), EPSILON);
		
		assertEquals("Position incorrect : ", new Coordonnees(), autreCercle.getPosition());
		assertEquals("Largeur incorrect : ", 50, autreCercle.getLargeur(), EPSILON);
		assertEquals("Hauteur incorrect : ", 50, autreCercle.getHauteur(), EPSILON);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructeurAvecUnParamExeption() {
		Cercle cercle = new Cercle(new Coordonnees(-10, 15));
		Cercle autreCercle = new Cercle(-50);
		
		assertEquals("Position incorrect : ", new Coordonnees(-10, 15), cercle.getPosition());
		assertEquals("Largeur incorrect : ", 40, cercle.getLargeur(), EPSILON);
		assertEquals("Hauteur incorrect : ", 40, cercle.getHauteur(), EPSILON);
		
		assertEquals("Position incorrect : ", new Coordonnees(), autreCercle.getPosition());
		assertEquals("Largeur incorrect : ", null, autreCercle.getLargeur());
		assertEquals("Hauteur incorrect : ", null, autreCercle.getHauteur());
	}
	
	@Test
	public void testConstructeurAvecTroisParam() {
		Cercle cercle = new Cercle(new Coordonnees(10, -15), 30);
		
		assertEquals("Position incorrect : ", new Coordonnees(10, -15), cercle.getPosition());
		assertEquals("Largeur incorrect : ", 30, cercle.getLargeur(), EPSILON);
		assertEquals("Hauteur incorrect : ", 30, cercle.getHauteur(), EPSILON);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConstructeurAvecTroisParamExeption() {
		Cercle cercle = new Cercle(new Coordonnees(10, -15), -30);
		
		assertEquals("Position incorrect : ", new Coordonnees(10, -15), cercle.getPosition());
		assertEquals("Largeur incorrect : ", null, cercle.getLargeur());
		assertEquals("Hauteur incorrect : ", null, cercle.getHauteur());
	}
	
	@Test
	public void testToString() {
		assertEquals("Chaine incorrect : ", "[Cercle] : pos (10,0 , 10,0) dim 25,0 x 25,0 périmètre : 78,54 aire : "
				+ "490,87 couleur = R51,V51,B51", 
				new Cercle(new Coordonnees(10, 10), 25).toString());
	}
}
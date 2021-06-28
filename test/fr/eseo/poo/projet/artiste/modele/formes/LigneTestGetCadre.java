package fr.eseo.poo.projet.artiste.modele.formes;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;

@RunWith(Parameterized.class)
public class LigneTestGetCadre {
	
	private static final double EPSILON = 0.01;
	private Ligne ligne;
	private double minX, minY, maxX, maxY;

	public LigneTestGetCadre(Ligne ligne, double minX, double minY, double maxX, double maxY) {
		this.ligne = ligne;
		this.minX = minX;
		this.minY = minY;
		this.maxX = maxX;
		this.maxY = maxY;
	}
	
	@Parameters(name = "dt[{index}] : {0}, {1}, {2}, {3}, {4}") 
    public static Collection<Object[]> dt() {
        Object[][] data = new Object[][] {
        	// C1 est en haut à gauche et C2 est en bas à droite
        	{new Ligne(), 0, 0, 40, 20},
        	// C1 est en bas à droite et C2 est en haut à gauche
        	{new Ligne(new Coordonnees(40, 20), -40, -20), 0, 0, 40, 20},
        	// C1 est en bas à gauche et C2 est en haut à droite
        	{new Ligne(new Coordonnees(0, 20), 40, -20), 0, 0, 40, 20},
        	// C1 est en haut à droite et C2 est en bas à gauche
        	{new Ligne(new Coordonnees(40, 0), -40, 20), 0, 0, 40, 20}
        };
        
        return Arrays.asList(data);
    }
    
    // Couverture des instructions des méthodes getCadre() : 100% (74/74)
    // Couverture des branches des méthodes getCadre() : 100% (8/8)
    
    @Test
	public void testGetCadreMinX() {
		assertEquals("Position de minX incorrect : ", this.minX, this.ligne.getCadreMinX(), EPSILON);
	}
    
    @Test
	public void testGetCadreMinY() {
		assertEquals("Position de minY incorrect : ", this.minY, this.ligne.getCadreMinY(), EPSILON);
	}
    
    @Test
	public void testGetCadreMaxX() {
		assertEquals("Position de maxX incorrect : ", this.maxX, this.ligne.getCadreMaxX(), EPSILON);
	}
    
    @Test
	public void testGetCadreMaxY() {
		assertEquals("Position de maxY incorrect : ", this.maxY, this.ligne.getCadreMaxY(), EPSILON);
	}
}
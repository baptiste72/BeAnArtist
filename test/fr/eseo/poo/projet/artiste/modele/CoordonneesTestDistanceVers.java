package fr.eseo.poo.projet.artiste.modele;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CoordonneesTestDistanceVers {
	
	private static final double EPSILON = 0.01;
	private Coordonnees coordonnees, autreCoordonnees;
	private double distance;

	public CoordonneesTestDistanceVers(Coordonnees coordonnees, Coordonnees autreCoordonnees, double distance) {
		this.coordonnees = coordonnees;
		this.autreCoordonnees = autreCoordonnees;
		this.distance = distance;
	}
	
	@Parameters(name = "dt[{index}] : {0}, {1}, {2}") 
    public static Collection<Object[]> dt() {
        Object[][] data = new Object[][] {
        	// Test d'une distance en haut à droite
        	{new Coordonnees(), new Coordonnees(0.8, 2.4), 2.52},
        	// Test d'une distance en haut à gauche
        	{new Coordonnees(), new Coordonnees(-1.7, 1.2), 2.08},
        	// Test d'une distance en bas à droite
        	{new Coordonnees(), new Coordonnees(2.9, -1.2), 3.14},
        	// Test d'une distance en bas à gauche
        	{new Coordonnees(), new Coordonnees(-3.0, -3.2), 4.39}
        };
        
        return Arrays.asList(data);
    }
    
    // Converture des instructions pour la méthode distanceVers() : 100% (17/17)
    
    @Test
	public void testDistanceVers() {
		assertEquals("Distance incorrect : ", this.distance, this.coordonnees.distanceVers(this.autreCoordonnees), EPSILON);
	}
}
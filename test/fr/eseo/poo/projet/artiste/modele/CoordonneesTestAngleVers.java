package fr.eseo.poo.projet.artiste.modele;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CoordonneesTestAngleVers {
	
	private static final double EPSILON = 0.01;
	private Coordonnees coordonnees, autreCoordonnees;
	private double angle;

	public CoordonneesTestAngleVers(Coordonnees coordonnees, Coordonnees autreCoordonnees, double angle) {
		this.coordonnees = coordonnees;
		this.autreCoordonnees = autreCoordonnees;
		this.angle = angle;
	}
	
	@Parameters(name = "dt[{index}] : {0}, {1}, {2}") 
    public static Collection<Object[]> dt() {
        Object[][] data = new Object[][] {
        	// Test d'un angle compris dans l'intervalle [0;π/2]
        	{new Coordonnees(), new Coordonnees(0.8, 2.4), 1.25},
        	// Test d'un angle à la position (0;π/2)
        	{new Coordonnees(), new Coordonnees(0, Math.PI / 2), Math.PI / 2},
        	// Test d'un angle compris dans l'intervalle [π/2;π]
        	{new Coordonnees(), new Coordonnees(-1.7, 1.2), 2.53},
        	// Test d'un angle à la position (π;0)
        	{new Coordonnees(), new Coordonnees(Math.PI, 0), 0},
        	// Test d'un angle compris dans l'intervalle [0;-π/2]
        	{new Coordonnees(), new Coordonnees(2.9, -1.2), -0.39},
        	// Test d'un angle à la position (0;-π/2)
        	{new Coordonnees(), new Coordonnees(0, -Math.PI / 2), -Math.PI / 2},
        	// Test d'un angle compris dans l'intervalle [-π/2,-π]
        	{new Coordonnees(), new Coordonnees(-3.0, -3.2), -2.32},
        	// Test d'un angle à la position (-π;0)
        	{new Coordonnees(), new Coordonnees(-Math.PI, 0), Math.PI}
        };
        
        return Arrays.asList(data);
    }
    
    // Couverture des instructions de la méthode angleVers() : 100% (33/33)
    // Couverture des branches de la méthode angleVers() : 100% (4/4)
    
    @Test
	public void testAngleVers() {
		assertEquals("Angle incorrect : ", this.angle, this.coordonnees.angleVers(this.autreCoordonnees), EPSILON);
	}
}
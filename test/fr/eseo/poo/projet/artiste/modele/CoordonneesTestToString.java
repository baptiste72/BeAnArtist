package fr.eseo.poo.projet.artiste.modele;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CoordonneesTestToString {
	
	private Coordonnees coordonnees;
	private String chaine;

	public CoordonneesTestToString(Coordonnees coordonnees, String chaine) {
		this.coordonnees = coordonnees;
		this.chaine = chaine;
	}
	
	// Test de la méthode toString() pour différents types de formatage
	
	@Parameters(name = "dt[{index}] : {0}, {1}") 
    public static Collection<Object[]> dt() {
        Object[][] data = new Object[][] {
        	{new Coordonnees(0.8, 2.4), "(0,8 , 2,4)"},
        	{new Coordonnees(-1.789, 1.234), "(-1,79 , 1,23)"},
        	{new Coordonnees(0.029, 00.12), "(0,03 , 0,12)"},
        	{new Coordonnees(-3.00, -3.20), "(-3,0 , -3,2)"}
        };
        
        return Arrays.asList(data);
    }
    
    // Converture des instructions pour la méthode toString() : 100% (25/25)
    
    @Test
	public void testToString() {
		assertEquals("Chaine incorrect : ", this.chaine, this.coordonnees.toString());
	}
}
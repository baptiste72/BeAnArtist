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
public class LigneTestSetC1C2 {
	
	private Ligne ligne;
	private Coordonnees c1, c2, c1Attendues, c2Attendues;

	public LigneTestSetC1C2(Ligne ligne, Coordonnees c1, Coordonnees c2, Coordonnees c1Attendues, Coordonnees c2Attendues) {
		this.ligne = ligne;
		this.c1 = c1;
		this.c2 = c2;
		this.c1Attendues = c1Attendues;
		this.c2Attendues = c2Attendues;
	}
	
	@Parameters(name = "dt[{index}] : {0}, {1}, {2}, {3}, {4}") 
    public static Collection<Object[]> dt() {
        Object[][] data = new Object[][] {
        	// C1 et C2 ne sont pas modifiées
        	{new Ligne(), new Coordonnees(), new Coordonnees(40, 20), new Coordonnees(), new Coordonnees(40, 20)},
        	// C1 est décalée en haut à droite et C2 n'est pas modifiée
        	{new Ligne(), new Coordonnees(50, 10), new Coordonnees(40, 20), new Coordonnees(50, 10), new Coordonnees(40, 20)},
        	// C1 est décalée en bas à droite et C2 n'est pas modifiée
        	{new Ligne(), new Coordonnees(50, 30), new Coordonnees(40, 20), new Coordonnees(50, 30), new Coordonnees(40, 20)},
        	// C1 est décalée en bas à gauche et C2 n'est pas modifiée
        	{new Ligne(), new Coordonnees(0, 30), new Coordonnees(40, 20), new Coordonnees(0, 30), new Coordonnees(40, 20)},
        	// C2 est décalée en haut à droite et C1 n'est pas modifiée
        	{new Ligne(), new Coordonnees(), new Coordonnees(50, 10), new Coordonnees(), new Coordonnees(50, 10)},
        	// C2 est décalée en bas à droite et C1 n'est pas modifiée
        	{new Ligne(), new Coordonnees(), new Coordonnees(50, 30), new Coordonnees(), new Coordonnees(50, 30)},
        	// C2 est décalée en bas à gauche et C1 n'est pas modifiée
        	{new Ligne(), new Coordonnees(), new Coordonnees(0, 30), new Coordonnees(), new Coordonnees(0, 30)},
        	// C2 est décalée en haut à gauche et C1 n'est pas modifiée
        	{new Ligne(), new Coordonnees(), new Coordonnees(0, 0), new Coordonnees(), new Coordonnees(0, 0)},
        	// C1 est décalée en haut à droite et C2 est décalée en haut à gauche
        	{new Ligne(), new Coordonnees(50, 10), new Coordonnees(0, 10), new Coordonnees(50, 10), new Coordonnees(0, 10)},
        	// C1 est décalée en haut à gauche et C2 est décalée en bas à gauche
        	{new Ligne(), new Coordonnees(0, 10), new Coordonnees(0, 30), new Coordonnees(0, 10), new Coordonnees(0, 30)},
        	// C1 est décalée en bas à droite et C2 est décalée en haut à droite
        	{new Ligne(), new Coordonnees(50, 30), new Coordonnees(50, 10), new Coordonnees(50, 30), new Coordonnees(50, 10)},
        	// C1 est décalée en bas à gauche et C2 est décalée en bas à droite
        	{new Ligne(), new Coordonnees(0, 30), new Coordonnees(50, 30), new Coordonnees(0, 30), new Coordonnees(50, 30)}
        };
        
        return Arrays.asList(data);
    }
    
    // Couverture des instructions de la méthode setC1() : 100% (20/20)
    
    @Test
	public void testSetC1() {
    	this.ligne.setC1(this.c1);
    	
		assertEquals("Position de C1 incorrect : ", this.c1Attendues, this.ligne.getC1());
	}
    
    // Couverture des instructions de la méthode setC2() : 100% (17/17)
    
    @Test
	public void testSetC2() {
    	this.ligne.setC2(this.c2);
    	
		assertEquals("Position de C2 incorrect : ", this.c2Attendues, this.ligne.getC2());
	}
}
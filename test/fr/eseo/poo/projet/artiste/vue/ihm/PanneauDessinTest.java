package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class PanneauDessinTest {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new PanneauDessinTest();
			}
		});
	}
	
	public PanneauDessinTest() {
		this.testConstructeurParDefaut();
		this.testConstructeur();
	}
	
	private void testConstructeurParDefaut() {
		JFrame fenetre = new JFrame("Etre un Artiste");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.add(new PanneauDessin());
		fenetre.pack();
		fenetre.setVisible(true);
		fenetre.setLocationRelativeTo(null);
	}
	
	private void testConstructeur() {
		JFrame fenetre = new JFrame("Blues du Businessman");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.add(new PanneauDessin(600, 360, new Color(150, 255, 255)));
		fenetre.pack();
		fenetre.setVisible(true);
		fenetre.setLocationRelativeTo(null);
	}
}
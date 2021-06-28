package fr.eseo.poo.projet.artiste.vue.ihm;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilSelectionner;

public class PanneauBarreOutilsTest {
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new PanneauBarreOutilsTest();
			}
		});
	}

	public PanneauBarreOutilsTest() {
		JFrame fenetre = new JFrame("PanneauBarreOutilsTest");
		PanneauBarreOutils panneauBarreOutils;
		PanneauDessin panneauDessin = new PanneauDessin();
		
		panneauDessin.associerOutil(new OutilSelectionner());
		panneauBarreOutils = new PanneauBarreOutils(panneauDessin);

		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setContentPane(panneauBarreOutils);
		fenetre.pack();
		fenetre.setVisible(true);
		fenetre.setLocationRelativeTo(null);
	}
}
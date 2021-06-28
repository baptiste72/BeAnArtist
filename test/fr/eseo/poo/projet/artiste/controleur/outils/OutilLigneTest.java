package fr.eseo.poo.projet.artiste.controleur.outils;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilLigneTest {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new OutilLigneTest();
			}
		});
	}
	
	public OutilLigneTest() {
		JFrame fenetre = new JFrame("OutilLigneTest");
		PanneauDessin panneauDessin = new PanneauDessin();
		
		panneauDessin.associerOutil(new OutilLigne());

		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.add(panneauDessin);
		fenetre.pack();
		fenetre.setVisible(true);
		fenetre.setLocationRelativeTo(null);
	}
}
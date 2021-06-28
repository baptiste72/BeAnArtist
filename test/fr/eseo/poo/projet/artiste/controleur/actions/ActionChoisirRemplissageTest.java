package fr.eseo.poo.projet.artiste.controleur.actions;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionChoisirRemplissageTest {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new ActionChoisirRemplissageTest();
			}
		});
	}
	
	public ActionChoisirRemplissageTest() {
		JFrame fenetre = new JFrame("ActionChoisirRemplissageTest");
		PanneauDessin panneauDessin = new PanneauDessin();
		PanneauBarreOutils panneauBarreOutils;
		
		panneauDessin.associerOutil(new OutilLigne());
		panneauBarreOutils = new PanneauBarreOutils(panneauDessin);
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.add(panneauBarreOutils);
		fenetre.pack();
		fenetre.setVisible(true);
		fenetre.setLocationRelativeTo(null);
	}
}
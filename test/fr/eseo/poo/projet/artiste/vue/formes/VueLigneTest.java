package fr.eseo.poo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ligne;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueLigneTest {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new VueLigneTest();
			}
		});
	}
	
	public VueLigneTest() {
		JFrame fenetre = new JFrame("VueLigneTest");
		PanneauDessin panneauDessin = new PanneauDessin();
		
		panneauDessin.ajouterVueForme(new VueLigne(new Ligne()));
		panneauDessin.ajouterVueForme(new VueLigne(new Ligne(new Coordonnees(300, 200))));
		panneauDessin.ajouterVueForme(new VueLigne(new Ligne(150, 50)));
		panneauDessin.ajouterVueForme(new VueLigne(new Ligne(new Coordonnees(300, 200), 150, 50)));
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.add(panneauDessin);
		fenetre.pack();
		fenetre.setVisible(true);
		fenetre.setLocationRelativeTo(null);
	}
}
package fr.eseo.poo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Cercle;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueCercleTest {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new VueCercleTest();
			}
		});
	}
	
	public VueCercleTest() {
		JFrame fenetre = new JFrame("VueCercleTest");
		PanneauDessin panneauDessin = new PanneauDessin();
		
		panneauDessin.ajouterVueForme(new VueCercle(new Cercle()));
		panneauDessin.ajouterVueForme(new VueCercle(new Cercle(new Coordonnees(300, 200))));
		panneauDessin.ajouterVueForme(new VueCercle(new Cercle(150)));
		panneauDessin.ajouterVueForme(new VueCercle(new Cercle(new Coordonnees(300, 200), 50)));
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.add(panneauDessin);
		fenetre.pack();
		fenetre.setVisible(true);
		fenetre.setLocationRelativeTo(null);
	}
}
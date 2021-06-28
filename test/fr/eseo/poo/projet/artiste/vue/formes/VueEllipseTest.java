package fr.eseo.poo.projet.artiste.vue.formes;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public class VueEllipseTest {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new VueEllipseTest();
			}
		});
	}
	
	public VueEllipseTest() {
		JFrame fenetre = new JFrame("VueEllipseTest");
		PanneauDessin panneauDessin = new PanneauDessin();
		
		panneauDessin.ajouterVueForme(new VueEllipse(new Ellipse()));
		panneauDessin.ajouterVueForme(new VueEllipse(new Ellipse(new Coordonnees(300, 200))));
		panneauDessin.ajouterVueForme(new VueEllipse(new Ellipse(150, 50)));
		panneauDessin.ajouterVueForme(new VueEllipse(new Ellipse(new Coordonnees(300, 200), 150, 50)));
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.add(panneauDessin);
		fenetre.pack();
		fenetre.setVisible(true);
		fenetre.setLocationRelativeTo(null);
	}
}
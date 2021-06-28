package fr.eseo.poo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

import fr.eseo.poo.projet.artiste.modele.Coordonnees;
import fr.eseo.poo.projet.artiste.vue.ihm.PanneauDessin;

public abstract class Outil implements MouseInputListener {

	private PanneauDessin panneauDessin = null;
	private Coordonnees debut = null, fin = null;
	
	public Coordonnees getDebut() {
		return this.debut;
	}
	
	public void setDebut(Coordonnees debut) {
		this.debut = debut;
	}
	
	public Coordonnees getFin() {
		return this.fin;
	}
	
	public void setFin(Coordonnees fin) {
		this.fin = fin;
	}
	
	public PanneauDessin getPanneauDessin() {
		return this.panneauDessin;
	}
	
	public void setPanneauDessin(PanneauDessin panneau) {
		this.panneauDessin = panneau;
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {

	}

	@Override
	public void mousePressed(MouseEvent event) {
		this.setDebut(new Coordonnees(event.getPoint().getX(), event.getPoint().getY()));
	}

	@Override
	public void mouseReleased(MouseEvent event) {
		this.setFin(new Coordonnees(event.getPoint().getX(), event.getPoint().getY()));
	}

	@Override
	public void mouseEntered(MouseEvent event) {

	}

	@Override
	public void mouseExited(MouseEvent event) {

	}

	@Override
	public void mouseDragged(MouseEvent event) {

	}

	@Override
	public void mouseMoved(MouseEvent event) {
	
	}
}
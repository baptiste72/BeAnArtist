package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionChoisirModeRemplissage;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.poo.projet.artiste.controleur.actions.ActionSelectionner;

@SuppressWarnings("serial")
public class PanneauBarreOutils extends JPanel {
	
	public static final int LARGEUR_BOUTON_PAR_DEFAUT = 200;
	private PanneauDessin panneauDessin = null;
	
	public PanneauBarreOutils(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
		this.setPreferredSize(new Dimension(1000, 480));
		this.setLayout(new BorderLayout());
		this.initComponents();
	}
	
	public void initComponents() {
		JPanel menu = new JPanel();
		ButtonGroup boutonsFormes = new ButtonGroup();
		Dimension dimension = new Dimension(LARGEUR_BOUTON_PAR_DEFAUT, 30);
		
		menu.setLayout(new BoxLayout(menu, BoxLayout.PAGE_AXIS));
		
		JButton boutonEffacerTout = new JButton(new ActionEffacer(this.panneauDessin));
		boutonEffacerTout.setMaximumSize(dimension);
		boutonEffacerTout.setName(ActionEffacer.NOM_ACTION);
		menu.add(boutonEffacerTout);
		
		JToggleButton boutonLigne = new JToggleButton(new ActionChoisirForme(this.panneauDessin, this, 
				ActionChoisirForme.NOM_ACTION_LIGNE));
        boutonLigne.setMaximumSize(dimension);
        boutonLigne.setName(ActionChoisirForme.NOM_ACTION_LIGNE);
        boutonsFormes.add(boutonLigne);
        menu.add(boutonLigne);
		
		JToggleButton boutonEllipse = new JToggleButton(new ActionChoisirForme(this.panneauDessin, this, 
				ActionChoisirForme.NOM_ACTION_ELLIPSE));
		boutonEllipse.setMaximumSize(dimension);
        boutonEllipse.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);
        boutonsFormes.add(boutonEllipse);
        menu.add(boutonEllipse);
		
		JToggleButton boutonCercle = new JToggleButton(new ActionChoisirForme(this.panneauDessin, this, 
				ActionChoisirForme.NOM_ACTION_CERCLE));
		boutonCercle.setMaximumSize(dimension);
        boutonCercle.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
        boutonsFormes.add(boutonCercle);
        menu.add(boutonCercle);
        
        JToggleButton boutonSelectionner = new JToggleButton(new ActionSelectionner(this.panneauDessin));
		boutonSelectionner.setPreferredSize(dimension);
        boutonSelectionner.setName(ActionSelectionner.NOM_ACTION);
        boutonsFormes.add(boutonSelectionner);
        menu.add(boutonSelectionner);
        
        JButton boutonCouleur = new JButton(new ActionChoisirCouleur(panneauDessin));
		boutonCouleur.setMaximumSize(dimension);
        boutonCouleur.setName(ActionChoisirCouleur.NOM_ACTION);
        boutonCouleur.setBackground(panneauDessin.getCouleurCourante());
        menu.add(boutonCouleur);
        
        JCheckBox boutonRemplissage = new JCheckBox(new ActionChoisirModeRemplissage(this.panneauDessin));
		boutonRemplissage.setMaximumSize(new Dimension(LARGEUR_BOUTON_PAR_DEFAUT, 25));
		boutonRemplissage.setName(ActionChoisirModeRemplissage.NOM_ACTION);
		menu.add(boutonRemplissage);
        
        this.add(menu, BorderLayout.EAST);
        this.add(this.panneauDessin, BorderLayout.WEST);
	}
}
package fr.eseo.poo.projet.artiste.vue.ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import fr.eseo.poo.projet.artiste.controleur.outils.Outil;
import fr.eseo.poo.projet.artiste.modele.formes.Forme;
import fr.eseo.poo.projet.artiste.vue.formes.VueForme;

@SuppressWarnings("serial")
public class PanneauDessin extends JPanel {

	public static final int LARGEUR_PAR_DEFAUT = 800, HAUTEUR_PAR_DEFAUT = 480;
	public static final Color COULEUR_FOND_PAR_DEFAUT = Color.WHITE;

	private final List<VueForme> vueFormes = new ArrayList<VueForme>();
	private Outil outilCourant;
	private Color couleurCourante;
	private boolean modeRemplissage;
	
	public PanneauDessin() {
		this(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT, COULEUR_FOND_PAR_DEFAUT);
	}
	
	public PanneauDessin(int largeur, int hauteur, Color fond) {
		setPreferredSize(new Dimension(largeur, hauteur));
		setBackground(fond);
		this.setCouleurCourante(Forme.COULEUR_PAR_DEFAUT);
	}
	
	public List<VueForme> getVueFormes() {
		return this.vueFormes;
	}
	
	public void ajouterVueForme(VueForme vueForme) {
		vueFormes.add(vueForme);
		this.repaint();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2D = (Graphics2D) g;
		
		for (VueForme vueForme : this.getVueFormes())
			vueForme.affiche(g2D);
		
		g2D.dispose();
	}
	
	public Outil getOutilCourant() {
		return this.outilCourant;
	}
	
	private void setOutilCourant(Outil outil) {
		this.outilCourant = outil;
	}
	
	public void associerOutil(Outil outil) {
		if (outil != null) {
			if (this.getOutilCourant() != null)
				this.dissocierOutil();
				
			this.setOutilCourant(outil);
			this.getOutilCourant().setPanneauDessin(this);
			this.addMouseListener(this.getOutilCourant());
			this.addMouseMotionListener(this.getOutilCourant());
		}	
	}
	
	private void dissocierOutil() {
		this.getOutilCourant().setPanneauDessin(null);
		this.removeMouseListener(this.getOutilCourant());
		this.removeMouseMotionListener(this.getOutilCourant());
		this.setOutilCourant(null);
	}
	
	public Color getCouleurCourante() {
		return this.couleurCourante;
	}
	
	public void setCouleurCourante(Color couleurCourante) {
		this.couleurCourante = couleurCourante;
	}
	
	public boolean getModeRemplissage() {
		return this.modeRemplissage;
	}
	
	public void setModeRemplissage(boolean modeRemplissage) {
		this.modeRemplissage = modeRemplissage;
	}
}
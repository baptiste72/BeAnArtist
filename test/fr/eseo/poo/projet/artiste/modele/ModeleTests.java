package fr.eseo.poo.projet.artiste.modele;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import fr.eseo.poo.projet.artiste.modele.formes.CercleTest;
import fr.eseo.poo.projet.artiste.modele.formes.EllipseTest;
import fr.eseo.poo.projet.artiste.modele.formes.LigneTest;
import fr.eseo.poo.projet.artiste.modele.formes.LigneTestGetCadre;
import fr.eseo.poo.projet.artiste.modele.formes.LigneTestSetC1C2;

// Couverture des instructions sur le modele : 98,9% (715/723)
// Couverture des branches sur le modele : 86,7% (26/30)

@RunWith(Suite.class)
@SuiteClasses({ CoordonneesTest.class,  CoordonneesTestDistanceVers.class, CoordonneesTestAngleVers.class,
		CoordonneesTestToString.class, LigneTest.class, LigneTestGetCadre.class, LigneTestSetC1C2.class,
		EllipseTest.class, CercleTest.class})
public class ModeleTests {
}
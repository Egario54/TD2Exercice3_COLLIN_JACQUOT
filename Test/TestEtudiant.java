import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Classe de test de la classe Etudiant
 * Le choix de ne pas effectuer de BeforeEach est du au fait que les donnees avant le test ne sont pas les memes
 */
public class TestEtudiant {

    /**
     * Test comparant deux cas d'ajout de notes
     * Parametres:
     * etudiantcompare ajout manuel de notes, sert de comparant
     * etudiant ajout de notes avec la methode testee, sert de compare
     */
    @Test
    public void testAjouterNote() throws MatiereInexistanteException, CoefficientIncorrecteException {
        Identite i1 = new Identite("23", "Dupont", "Jean");
        Formation f1 = new Formation("DUT Informatique");
        f1.ajouterMatiere("Mathematiques",3);
        f1.ajouterMatiere("Physique",2);
        Etudiant e1 = new Etudiant(i1, f1);
        e1.ajouterNote("Mathematiques", 12);
        e1.ajouterNote("Physique", 15);

        assertEquals(e1.getNotes().get("Mathematiques").size(), 1);
        assertEquals(e1.getNotes().get("Physique").size(), 1);


    }
    /**
     * Test de la méthode de calcul de moyenne
     * compare le resultat prevu d'une moyenne au resultat de la methode
     */
    @Test
    public void testCalculerMoyenne() throws MatiereInexistanteException {
        //preparation donnees
        ArrayList <Double> noteMath = new ArrayList<>();
        noteMath.add(15.0);

        ArrayList <Double> noteFr = new ArrayList<>();
        noteFr.add(10.0);
        noteFr.add(12.0);

        HashMap <String, ArrayList<Double>> notes = new HashMap<>();
        notes.put("Maths",noteMath);
        notes.put("Francais", noteFr);
        Etudiant etudiant = new Etudiant(new Identite(), new Formation("Formation classique"),notes);
        //methode testee + tests
        assertEquals(11.0,etudiant.calculerMoyenne("Francais"));
    }

    /**
     * Methode qui permet de vérifier que le calcul de moyenne générale est correct
     * compare le resultat prevu d'une moyenne au resultat de la methode, un peu comme la methode d'avant
     */
    @Test
    public void testCalculerMoyenneGenerale() throws MatiereInexistanteException, CoefficientIncorrecteException {
        //preparation donnees
        ArrayList <Double> noteMath = new ArrayList<>();
        noteMath.add(15.0);

        ArrayList <Double> noteFr = new ArrayList<>();
        noteFr.add(10.0);
        noteFr.add(12.0);

        HashMap <String, ArrayList<Double>> notes = new HashMap<>();
        notes.put("Maths",noteMath);
        notes.put("Francais", noteFr);
        Formation form = new Formation("Formation classique");
        form.ajouterMatiere("Maths",2);
        form.ajouterMatiere("Francais",2);
        Etudiant etudiant = new Etudiant(new Identite(), form,notes);
        //methode testee + tests
        assertEquals(13.0,etudiant.calculerMoyenneGenerale());
    }
}

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * Classe de test utilisant les mêmes données de génération afin de comparer le bon fonctionnement des methodes
 */
public class TestEtudiant {

    /**
     * Test de la méthode de calcul de moyenne
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
     */
    @Test
    public void testCalculerMoyenneGenerale() throws MatiereInexistanteException {
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

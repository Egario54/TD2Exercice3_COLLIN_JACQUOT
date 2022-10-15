import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestFormation {

    @Test
    public void test_AjouterMatiere() throws CoefficientIncorrectException {
        Formation f = new Formation("L3");
        f.ajouterMatiere("Maths", 6);
        f.ajouterMatiere("Physique", 4);

        assertEquals(2, f.getMatieres().size());
    }

    @Test
    public void test_AjouterMatiere_CoefficientInferieurAZero(){
        Formation f = new Formation("L3");
        assertThrows(CoefficientIncorrectException.class, () -> f.ajouterMatiere("Maths", -6));
    }

    @Test
    public void test_SupprimerMatiere() throws MatiereInexistanteException, CoefficientIncorrectException {
        Formation f = new Formation("L3");
        f.ajouterMatiere("Maths", 6);
        f.ajouterMatiere("Physique", 4);

        f.supprimerMatiere("Maths");

        assertEquals(1, f.getMatieres().size());
    }

    @Test

    public void test_getCoefficient() throws MatiereInexistanteException, CoefficientIncorrectException {
        Formation f = new Formation("L3");
        f.ajouterMatiere("Maths", 6);
        f.ajouterMatiere("Physique", 4);

        assertEquals(6, f.getCoefficient("Maths"));
    }

    @Test
    public void test_getCoefficientMatiereInexistante() throws MatiereInexistanteException, CoefficientIncorrectException {
        Formation f = new Formation("L3");
        f.ajouterMatiere("Maths", 6);
        f.ajouterMatiere("Physique", 4);

        assertThrows(MatiereInexistanteException.class, () -> f.getCoefficient("Chimie"));
    }

    @Test
    public void test_supprimerMatiereInexistante() throws MatiereInexistanteException, CoefficientIncorrectException {
        Formation f = new Formation("L3");
        f.ajouterMatiere("Maths", 6);
        f.ajouterMatiere("Physique", 4);

        assertThrows(MatiereInexistanteException.class, () -> f.supprimerMatiere("Chimie"));
    }
}

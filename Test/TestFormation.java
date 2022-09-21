import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestFormation {

    @Test
    public void test_AjouterMatiere(){
        Formation f = new Formation("L3");
        f.ajouterMatiere("Maths", 6);
        f.ajouterMatiere("Physique", 4);

        assertEquals(2, f.getMatieres().size());
    }

    @Test
    public void test_SupprimerMatiere() throws MatiereInexistanteException {
        Formation f = new Formation("L3");
        f.ajouterMatiere("Maths", 6);
        f.ajouterMatiere("Physique", 4);

        f.supprimerMatiere("Maths");

        assertEquals(1, f.getMatieres().size());
    }

    @Test

    public void test_getCoefficient() throws MatiereInexistanteException {
        Formation f = new Formation("L3");
        f.ajouterMatiere("Maths", 6);
        f.ajouterMatiere("Physique", 4);

        assertEquals(6, f.getCoefficient("Maths"));
    }

    @Test
    public void test_getCoefficientMatiereInexistante() throws MatiereInexistanteException {
        Formation f = new Formation("L3");
        f.ajouterMatiere("Maths", 6);
        f.ajouterMatiere("Physique", 4);

        assertThrows(MatiereInexistanteException.class, () -> f.getCoefficient("Chimie"));
    }

    @Test
    public void test_supprimerMatiereInexistante() throws MatiereInexistanteException {
        Formation f = new Formation("L3");
        f.ajouterMatiere("Maths", 6);
        f.ajouterMatiere("Physique", 4);

        assertThrows(MatiereInexistanteException.class, () -> f.supprimerMatiere("Chimie"));
    }
}

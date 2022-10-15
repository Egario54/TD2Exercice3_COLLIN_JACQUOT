import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTri {

    @Test
    public void test_tri_alpha() throws MauvaiseFormation, CoefficientIncorrectException {
        Formation f = new Formation("L3");
        f.ajouterMatiere("Maths", 6);

        Groupe g = new Groupe(f);
        Identite i1 = new Identite("123", "zane", "John");
        Identite i2 = new Identite("456", "Afdf", "Jane");
        Identite i3 = new Identite("789", "Brade", "Jack");
        Etudiant e1 = new Etudiant(i1, f);
        Etudiant e2 = new Etudiant(i2, f);
        Etudiant e3 = new Etudiant(i3, f);
        g.ajouterEtudiant(e1);
        g.ajouterEtudiant(e2);
        g.ajouterEtudiant(e3);
        g.triAlpha();
        assertEquals(e2, g.getEtudiants().get(0));
        assertEquals(e3, g.getEtudiants().get(1));
        assertEquals(e1, g.getEtudiants().get(2));
    }

    @Test
    public void test_tri_anti_alpha() throws MauvaiseFormation, CoefficientIncorrectException {
        Formation f = new Formation("L3");
        f.ajouterMatiere("Maths", 6);

        Groupe g = new Groupe(f);
        Identite i1 = new Identite("123", "zane", "John");
        Identite i2 = new Identite("456", "Afdf", "Jane");
        Identite i3 = new Identite("789", "Brade", "Jack");
        Etudiant e1 = new Etudiant(i1, f);
        Etudiant e2 = new Etudiant(i2, f);
        Etudiant e3 = new Etudiant(i3, f);
        g.ajouterEtudiant(e1);
        g.ajouterEtudiant(e2);
        g.ajouterEtudiant(e3);
        g.triAntiAlpha();
        assertEquals(e1, g.getEtudiants().get(0));
        assertEquals(e3, g.getEtudiants().get(1));
        assertEquals(e2, g.getEtudiants().get(2));
    }

    @Test
    public void test_tri_par_merite() throws MauvaiseFormation, MatiereInexistanteException, CoefficientIncorrectException {
        Formation f = new Formation("L3");
        f.ajouterMatiere("Maths", 6);

        Groupe g = new Groupe(f);
        Identite i1 = new Identite("123", "zane", "John");
        Identite i2 = new Identite("456", "Afdf", "Jane");
        Identite i3 = new Identite("789", "Brade", "Jack");
        Etudiant e1 = new Etudiant(i1, f);
        Etudiant e2 = new Etudiant(i2, f);
        Etudiant e3 = new Etudiant(i3, f);
        g.ajouterEtudiant(e1);
        g.ajouterEtudiant(e2);
        g.ajouterEtudiant(e3);
        e1.ajouterNote("Maths", 10);
        e2.ajouterNote("Maths", 12);
        e3.ajouterNote("Maths", 8);
        g.triParMerite();
        assertEquals(e2, g.getEtudiants().get(0));
        assertEquals(e1, g.getEtudiants().get(1));
        assertEquals(e3, g.getEtudiants().get(2));
    }
}

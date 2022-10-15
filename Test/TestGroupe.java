import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestGroupe {
    /**
     * Test du fonctionnement normal de l'ajout d'un étudiant
     * @throws MauvaiseFormation
     */
    @Test
    public void test_ajouter_vrai_etudiant() throws MauvaiseFormation {
        Formation formation = new Formation("Java");
        Groupe groupe = new Groupe(formation);
        Identite i1 = new Identite("sls","Dupont", "Jean");
        Etudiant e1 = new Etudiant(i1, formation);
        Identite i2 = new Identite("sls","Mani", "Naps");
        Etudiant e2 = new Etudiant(i2, formation);
        groupe.ajouterEtudiant(e1);
        groupe.ajouterEtudiant(e2);
        assertEquals(2, groupe.getEtudiants().size());
    }

    /**
     * Vérifie la bonne levée de l'exception lorsqu'un étudiant "se trompe" de groupe
     * @throws MauvaiseFormation
     */
    @Test
    public void test_ajouter_faux_etudiant() throws MauvaiseFormation {
        Formation formation = new Formation("Java");
        Groupe groupe = new Groupe(formation);
        Identite i1 = new Identite("sls","Dupont", "Jean");
        Etudiant e1 = new Etudiant(i1, formation);
        Identite i2 = new Identite("sls","Mani", "Naps");
        Formation formation2 = new Formation("C++");
        Etudiant e2 = new Etudiant(i2, formation2);
        groupe.ajouterEtudiant(e1);
        assertThrows(MauvaiseFormation.class, () -> groupe.ajouterEtudiant(e2));
    }

    /**
     * Test du bon fonctionnement de la suppression d'un étudiant
     * @throws MauvaiseFormation
     * @throws EtudiantInexistant
     */
    @Test
    public void test_supprimer_vrai_etudiant() throws MauvaiseFormation, EtudiantInexistant {
        Formation formation = new Formation("Java");
        Groupe groupe = new Groupe(formation);
        Identite i1 = new Identite("sls","Dupont", "Jean");
        Etudiant e1 = new Etudiant(i1, formation);
        Identite i2 = new Identite("sls","Mani", "Naps");
        Etudiant e2 = new Etudiant(i2, formation);
        groupe.ajouterEtudiant(e1);
        groupe.ajouterEtudiant(e2);
        groupe.supprimerEtudiant(e1);
        assertEquals(1, groupe.getEtudiants().size());
    }

    /**
     * Vérifie qu'EtudiantInexistant est bien levé
     * @throws MauvaiseFormation
     * @throws EtudiantInexistant le but de ce test est de le lever
     */
    @Test
    public void test_supprimer_faux_etudiant() throws MauvaiseFormation, EtudiantInexistant {
        Formation formation = new Formation("Java");
        Groupe groupe = new Groupe(formation);
        Identite i1 = new Identite("sls","Dupont", "Jean");
        Etudiant e1 = new Etudiant(i1, formation);
        Identite i2 = new Identite("sls","Mani", "Naps");
        Etudiant e2 = new Etudiant(i2, formation);
        groupe.ajouterEtudiant(e1);
        assertThrows(EtudiantInexistant.class, () -> groupe.supprimerEtudiant(e2));
    }

}

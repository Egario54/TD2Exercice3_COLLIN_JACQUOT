import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMoyenneGroupe {

    @Test
    public void Calculer_moyenne_groupe() throws MatiereInexistanteException, MauvaiseFormation, CoefficientIncorrecteException {
        Formation f = new Formation("L3");
        f.ajouterMatiere("Maths", 6);
        f.ajouterMatiere("Physique", 4);
        f.ajouterMatiere("Chimie", 4);


        Groupe g = new Groupe(f);
        Identite id1 = new Identite("Dupont", "Jean", "1 rue de la paix");
        Identite id2 = new Identite("Durand", "Pierre", "2 rue de la paix");
        Identite id3 = new Identite("Martin", "Paul", "3 rue de la paix");
        g.ajouterEtudiant(new Etudiant(id1, f));
        g.ajouterEtudiant(new Etudiant(id2, f));
        g.ajouterEtudiant(new Etudiant(id3, f));

        g.getEtudiants().get(0).ajouterNote("Maths", 10);

        g.getEtudiants().get(1).ajouterNote("Maths", 16);

        g.getEtudiants().get(2).ajouterNote("Maths", 19);


        assertEquals(15, g.calculerMoyenneGroupe("Maths"));
    }

    @Test
    public void Calculer_moyenne_generale_groupe() throws MatiereInexistanteException, MauvaiseFormation, CoefficientIncorrecteException {
        Formation f = new Formation("L3");
        f.ajouterMatiere("Maths", 6);
        f.ajouterMatiere("Physique", 4);
        f.ajouterMatiere("Chimie", 4);


        Groupe g = new Groupe(f);
        Identite id1 = new Identite("Dupont", "Jean", "1 rue de la paix");
        Identite id2 = new Identite("Durand", "Pierre", "2 rue de la paix");
        Identite id3 = new Identite("Martin", "Paul", "3 rue de la paix");
        g.ajouterEtudiant(new Etudiant(id1, f));
        g.ajouterEtudiant(new Etudiant(id2, f));
        g.ajouterEtudiant(new Etudiant(id3, f));

        g.getEtudiants().get(0).ajouterNote("Maths", 10);
        g.getEtudiants().get(0).ajouterNote("Physique", 10);
        g.getEtudiants().get(0).ajouterNote("Chimie", 10);

        g.getEtudiants().get(1).ajouterNote("Maths", 16);
        g.getEtudiants().get(1).ajouterNote("Physique", 16);
        g.getEtudiants().get(1).ajouterNote("Chimie", 16);

        g.getEtudiants().get(2).ajouterNote("Maths", 19);
        g.getEtudiants().get(2).ajouterNote("Physique", 19);
        g.getEtudiants().get(2).ajouterNote("Chimie", 19);

        assertEquals(15, g.CalculerMoyenneGeneraleGroupe());
    }
}

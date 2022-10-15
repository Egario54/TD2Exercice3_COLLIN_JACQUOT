/**
 * Lors de l'ajout dans un groupe, si la formation de l'etudiant ne correspond pas au groupe cette exception est levée
 */
public class MauvaiseFormation extends Exception {
    public MauvaiseFormation() {
        super("L'étudiant n'est pas dans la bonne formation");
    }
}


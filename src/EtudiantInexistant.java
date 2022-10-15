/**
 * Exception utilisee lorsqu'un etudiant n'est pas détecté lors de sa suppression
 */
public class EtudiantInexistant extends Exception {
    public EtudiantInexistant() {
        super("L'étudiant n'est pas dans le groupe");
    }
}

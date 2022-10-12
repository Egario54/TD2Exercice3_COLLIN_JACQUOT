public class EtudiantInexistant extends Exception {
    public EtudiantInexistant() {
        super("L'étudiant n'est pas dans le groupe");
    }
}

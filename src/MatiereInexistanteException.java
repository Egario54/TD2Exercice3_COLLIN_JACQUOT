/**
 * Exception utilisee lorsqu'une matière n'est pas détectée lors d'une suppression par exemple
 */
public class MatiereInexistanteException extends Exception {

    public MatiereInexistanteException() {
        super("La matière n'existe pas");
    }
}


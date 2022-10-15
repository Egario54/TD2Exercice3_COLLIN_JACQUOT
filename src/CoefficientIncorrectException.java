/**
 * Exception utilisee lorsqu'un coefficient est negatif ou nul
 */
public class CoefficientIncorrectException extends Exception {
    public CoefficientIncorrectException(){
        super("Le coefficient doit être supérieur à 0");
    }
}


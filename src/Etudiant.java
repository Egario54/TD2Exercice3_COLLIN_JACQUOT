import java.util.ArrayList;
import java.util.HashMap;

/**
 * Classe décrivant un etudiant
 * Il contient une identite, une formation et des notes
 * Lors de la création d'un etudiant, il doit obligatoirement avoir une formation
 */
public class Etudiant {

    private Identite identite;
    private Formation formation;
    private HashMap<String, ArrayList<Double>> notes;

    /**
     * Constructeur créant un étudiant sans identité (triste), avec une formation, et une liste de notes vide
     * @param formation la formation attritrée a l'etudiant
     */
    public Etudiant(Formation formation) {
        this.identite = new Identite();
        this.formation = formation;
        this.notes = new HashMap<>();
    }

    /**
     * Constructeur créant un étudiant complet
     * @param identite l'identité de l'etudiant
     * @param formation la formation attritrée a l'etudiant
     * @param notes potentielles notes données
     */
    public Etudiant(Identite identite, Formation formation, HashMap<String, ArrayList<Double>> notes) {
        this.identite = identite;
        this.formation = formation;
        this.notes = notes;
    }

    /**
     * Constructeur créant un etudiant avec une liste de notes
     * @param identite identite de l'etudiant
     * @param formation la formation attritrée a l'etudiant
     */
    public Etudiant(Identite identite, Formation formation) {
        this.identite = identite;
        this.formation = formation;
        this.notes = new HashMap<>();
    }

    public Formation getFormation() {
        return formation;
    }

    public Identite getIdentite() {
        return identite;
    }

    public HashMap<String, ArrayList<Double>> getNotes() {
        return notes;
    }

    /**
     * Ajoute une note correspondant à une matière.
     * @param matière correspondant à la note
     * @param note
     * @throws MatiereInexistanteException si la matière n'existe pas.
     */
    public void ajouterNote(String matière, double note) throws MatiereInexistanteException {
        if (notes.containsKey(matière)) {
            notes.get(matière).add(note);
        } else {
            if (this.formation.getMatieres().contains(matière)){
                ArrayList<Double> list = new ArrayList<>();
                list.add(note);
                notes.put(matière, list);
            }
            else {
                throw new MatiereInexistanteException();
            }
        }
    }

    /**
     * Calcule la moyenne de l'étudiant sur une seule matière.
     * @param matière
     * @return un double, la moyenne de la matière
     * @throws MatiereInexistanteException dans le cas où la matière n'existe pas.
     */
    public double calculerMoyenne(String matière) throws MatiereInexistanteException {
        double moyenne = 0;
        if (notes.containsKey(matière)) {
            if (notes.get(matière).size() > 0) {
                for (Double note : notes.get(matière)) {
                    moyenne += note;
                }
                moyenne /= notes.get(matière).size();
            } else {
                return -1;
            }
        }else {
            throw new MatiereInexistanteException();
        }
        return moyenne;
    }

    /**
     * Calcule la moyenne générale de l'étudiant en parcourant chaque matière et son coefficient
     * @return double, la moyenne générale
     * @throws MatiereInexistanteException, en raison de l'utilisation de calculerMoyenne. Cette exception n'est pas relevée normalement
     */
    public double calculerMoyenneGenerale() throws MatiereInexistanteException {
        double moyenne = 0;
        int sommecoeff = 0;
        for (String matière : notes.keySet()) {
            if (calculerMoyenne(matière) != -1) {
                moyenne += calculerMoyenne(matière) * formation.getCoefficient(matière);
                sommecoeff += formation.getCoefficient(matière);
            }
        }
        moyenne /= sommecoeff;
        return moyenne;
    }

    /**
     * String élaboré qui retourne un étudiant avec ses matières et notes associées
     * @return String élaboré et magnifique
     */
    public String toString(){
        String s = "Etudiant" + identite.toString() + "\n" + formation.toString() + "\n";
        for(String matiere : notes.keySet()){
            s += " - " + matiere + " : ";
            for(Double note : notes.get(matiere)){
                s += note + " ,";
            }
        }
        return s;
    }
}

import java.util.ArrayList;
import java.util.HashMap;

public class Etudiant {

    private Identite identite;
    private Formation formation;
    private HashMap<String, ArrayList<Double>> notes;

    public Etudiant() {
        this.identite = new Identite();
        this.formation = new Formation();
        this.notes = new HashMap<>();
    }

    public Etudiant(Identite identite, Formation formation, HashMap<String, ArrayList<Double>> notes) {
        this.identite = identite;
        this.formation = formation;
        this.notes = notes;
    }

    public void ajouterNote(String matière, double note) {
        if (notes.containsKey(matière)) {
            notes.get(matière).add(note);
        } else {
            ArrayList<Double> list = new ArrayList<>();
            list.add(note);
            notes.put(matière, list);
        }
    }

    public double calculerMoyenne(String matière){
        double moyenne = 0;
        if (notes.containsKey(matière)) {
            for (Double note : notes.get(matière)) {
                moyenne += note;
            }
            moyenne /= notes.get(matière).size();
        }
        else {
            System.out.println("La matière n'existe pas");
        }
        return moyenne;
    }

    public double calculerMoyenneGenerale(){
        double moyenne = 0;
        for (String matière : notes.keySet()) {
            moyenne += calculerMoyenne(matière)*formation.getCoefficient(matière);
        }
        moyenne /= notes.size();
        return moyenne;
    }
}

import java.util.ArrayList;
import java.util.HashMap;

public class Etudiant {

    private Identite identite;
    private Formation formation;
    private HashMap<String, ArrayList<Double>> notes;

    public Etudiant(Formation formation) {
        this.identite = new Identite();
        this.formation = formation;
        this.notes = new HashMap<>();
    }

    public Etudiant(Identite identite, Formation formation, HashMap<String, ArrayList<Double>> notes) {
        this.identite = identite;
        this.formation = formation;
        this.notes = notes;
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

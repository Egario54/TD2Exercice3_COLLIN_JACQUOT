import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Formation {
    private String idformation;
    /**
     * Attribut matière contenant une matière et un coefficient
     */
    private HashMap<String, Integer> matieres;

    public Formation(String idform){
        this.idformation = idform;
        this.matieres = new HashMap<>();
    }
    public void ajouterMatiere(String mat, Integer coef){
        this.matieres.put(mat,coef);
    }
    public void supprimerMatiere(String mat) throws MatiereInexistanteException {
        if(matieres.containsKey(mat)){
            this.matieres.remove(mat);
        } else throw new MatiereInexistanteException();
    }

    public Set<String> getMatieres(){
        return this.matieres.keySet();
    }
    public Integer getCoefficient(String matiere) throws MatiereInexistanteException {
        if(matieres.containsKey(matiere)){
            return matieres.get(matiere);
        }
        else{
            throw new MatiereInexistanteException();
        }
    }

    public String toString(){
        String s = "Formation" + this.idformation + " : \n" + " Matières : \n";
        for(String matiere : this.matieres.keySet()){
            s += " - " + matiere + " : " + this.matieres.get(matiere) + "\n";
        }
        return s;

    }
}

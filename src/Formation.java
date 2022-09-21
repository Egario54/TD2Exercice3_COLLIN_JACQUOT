import java.util.HashMap;

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
    public void supprimerMatiere(String mat){
        this.matieres.remove(mat);
    }

    public Integer getCoefficient(String matiere) {
        if(matieres.containsKey(matiere)){
            return matieres.get(matiere);
        }
        else{
            return null;
        }
    }
}

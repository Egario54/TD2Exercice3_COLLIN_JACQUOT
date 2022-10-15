import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Cette classe définit une formation avec des matières.
 * Elle permet de bien définir des matières associés aux formations.
 */
public class Formation {
    private String idformation;
    /**
     * Attribut de type table contenant une matière et un coefficient à appliquer lors d'un calcul de moyenne générale.
     */
    private HashMap<String, Integer> matieres;

    /**
     * Constructeur unique avec un simple identifiant de formation.
     * @param idform
     */
    public Formation(String idform){
        this.idformation = idform;
        this.matieres = new HashMap<>();
    }

    public String getIdformation() {
        return idformation;
    }

    /**
     * Ajoute une matière à la formation
     * @param mat la matière à ajouter
     * @param coef
     * @throws CoefficientIncorrectException si le coefficient est nul ou négatif
     */
    public void ajouterMatiere(String mat, Integer coef) throws CoefficientIncorrectException {
        if (coef > 0){
            this.matieres.put(mat, coef);
        }else {
            throw new CoefficientIncorrectException();
        }
    }

    /**
     * Supprime une matière à la formation.
     * @param mat la matière à supprimer
     * @throws MatiereInexistanteException si la matière est introuvable dans la formation.
     */
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

    /**
     * toString amélioré renvoyant la formation et l'ensemble des matières
     * @return un string détaillé. Enfin, pas un beau string, plutôt une chaine de caractères.
     */
    public String toString(){
        String s = "Formation" + this.idformation + " : \n" + " Matières : \n";
        for(String matiere : this.matieres.keySet()){
            s += " - " + matiere + " : " + this.matieres.get(matiere) + "\n";
        }
        return s;

    }
}

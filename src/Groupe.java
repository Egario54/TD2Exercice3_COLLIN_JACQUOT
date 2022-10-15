import java.util.*;

/**
 * Classe définissant un groupe d'etudiants
 * Ils peuvent être classés !
 * Egalement, ils doivent tous avoir la meme formation.
 */
public class Groupe {

    private List<Etudiant> etudiants = new ArrayList<Etudiant>();

    private Formation formation;

    /**
     * Constructeur unique, qui associe une formation au groupe créé
     * @param formation formation du groupe d'étudiants
     */
    public Groupe(Formation formation) {
        this.formation = formation;
    }

    /**
     * Méthode qui ajoute un étudiant avec la même formation
     * @param etudiant étudiant venant probablement de Parcoursup, qui ne sait pas trop ce qu'il fait là et vient dans le groupe, un peu paumé
     * @throws MauvaiseFormation si la formation n'est pas la même
     */
    public void ajouterEtudiant(Etudiant etudiant) throws MauvaiseFormation {
        if (etudiant.getFormation() == this.formation) {
            etudiants.add(etudiant);
        }
        else {
            throw new MauvaiseFormation();
        }
    }

    /**
     * Enlève l'étudiant du groupe. Pratique quand y'a des problèmes dans le groupe.
     * @param etudiant étudiant présent
     * @throws EtudiantInexistant si l'étudiant spécifié est introuvable dans la liste.
     */
    public void supprimerEtudiant(Etudiant etudiant) throws EtudiantInexistant {
        if (etudiants.contains(etudiant)) {
            etudiants.remove(etudiant);
        }
        else {
            throw new EtudiantInexistant();
        }
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public Formation getFormation() {
        return formation;
    }

    /**
     * Calcule la moyenne du groupe, sur une matière.
     * @param matiere sur laquelle il faut faire la moyenne.
     * @return double, la moyenne des étudiants du groupe.
     * @throws MatiereInexistanteException si la matière spécifiée en paramètre ne correspond pas.
     */
    public double calculerMoyenneGroupe(String matiere) throws MatiereInexistanteException {
        double moyenne = 0;
        int nbEtudiants = 0;
        for (Etudiant etudiant : etudiants) {
            try {
                moyenne += etudiant.calculerMoyenne(matiere);
                nbEtudiants++;
            }
            catch (MatiereInexistanteException e) {
                throw e;
            }
        }
        return moyenne / nbEtudiants;
    }

    /**
     * Utilise la méthode de calcul de moyenne générale d'un étudiant, sur chaque étudiant pour avoir la moyenne générale du groupe.
     * @return double spécifiant la moyenne générale.
     * @throws MatiereInexistanteException
     */
    public double CalculerMoyenneGeneraleGroupe() throws MatiereInexistanteException {
        double moyenne = 0;
        int nbEtudiants = 0;
        for (Etudiant etudiant : etudiants) {
            moyenne += etudiant.calculerMoyenneGenerale();
            nbEtudiants++;
        }
        return moyenne / nbEtudiants;
    }

    /**
     * Ces 3 méthodes trient le groupe des étudiants selon l'ordre du comparateur choisi.
     * Les tris sont respectivement :
     * - de A à Z,
     * - de Z à A,
     * - selon la moyenne générale de l'étudiant.
     */
    public void triAlpha(){
        etudiants.sort(new ComparateurEtudiantsAlpha());
    }
    public void triAntiAlpha(){
        etudiants.sort(new ComparateurEtudiantsAntiAlpha());
    }

    public void triParMerite(){
        etudiants.sort(new ComparateurEtudiantsMerite());
    }
}

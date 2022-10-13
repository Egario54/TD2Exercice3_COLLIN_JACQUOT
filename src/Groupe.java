import java.util.*;

public class Groupe {

    private List<Etudiant> etudiants = new ArrayList<Etudiant>();

    private Formation formation;

    public Groupe(Formation formation) {
        this.formation = formation;
    }

    public void ajouterEtudiant(Etudiant etudiant) throws MauvaiseFormation {
        if (etudiant.getFormation() == this.formation) {
            etudiants.add(etudiant);
        }
        else {
            throw new MauvaiseFormation();
        }
    }

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

    public double CalculerMoyenneGeneraleGroupe() throws MatiereInexistanteException {
        double moyenne = 0;
        int nbEtudiants = 0;
        for (Etudiant etudiant : etudiants) {
            moyenne += etudiant.calculerMoyenneGenerale();
            nbEtudiants++;
        }
        return moyenne / nbEtudiants;
    }

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

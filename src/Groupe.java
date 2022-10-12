import java.util.ArrayList;
import java.util.List;

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
}
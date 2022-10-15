import java.util.Comparator;

/**
 * Comparateur qui permet de trier dans Groupe de A à Z
 */
public class ComparateurEtudiantsAlpha implements Comparator<Etudiant> {
    @Override
    public int compare(Etudiant o1, Etudiant o2) {
        String nom1 = o1.getIdentite().getNom();
        String nom2 = o2.getIdentite().getNom();
        if (nom1.compareTo(nom2) == 0) {
            String prenom1 = o1.getIdentite().getPrenom();
            String prenom2 = o2.getIdentite().getPrenom();
            return prenom1.compareTo(prenom2);
        }
        else {
            return nom1.compareTo(nom2);
        }
    }
}



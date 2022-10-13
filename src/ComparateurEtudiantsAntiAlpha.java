import java.util.Comparator;

public class ComparateurEtudiantsAntiAlpha implements Comparator<Etudiant> {
    @Override
    public int compare(Etudiant o1, Etudiant o2) {
        String nom1 = o1.getIdentite().getNom();
        String nom2 = o2.getIdentite().getNom();
        if (nom1.compareTo(nom2) == 0) {
            String prenom1 = o1.getIdentite().getPrenom();
            String prenom2 = o2.getIdentite().getPrenom();
            return prenom2.compareTo(prenom1);
        }
        else {
            return nom2.compareTo(nom1);
        }
    }
}

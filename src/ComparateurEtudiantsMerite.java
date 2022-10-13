import java.util.Comparator;

public class ComparateurEtudiantsMerite implements Comparator<Etudiant> {


    @Override
    public int compare(Etudiant o1, Etudiant o2) {
        try {
            if (o1.calculerMoyenneGenerale() > o2.calculerMoyenneGenerale()) {
                return -1;
            }
            else if (o1.calculerMoyenneGenerale() < o2.calculerMoyenneGenerale()) {
                return 1;
            }
            else {
                return 0;
            }
        } catch (MatiereInexistanteException e) {
            System.out.println("Une matière n'existe pas");
        }
        return 0;
    }
}

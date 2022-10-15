/**
 * Classe simple décrivant l'identite d'une personne
 */
public class Identite {

    //NIP est le Numéro d'Identification Personnelle
    private String NIP;
    private String nom;
    private String prenom;

    /**
     * 1er constructeur
     * Crée une identité... sans identité.
     */
    public Identite() {
        this.NIP = "";
        this.nom = "";
        this.prenom = "";
    }

    /**
     * 2nd constructeur, qui prend 3 strings en paramètres pour avoir un peu plus d'identité
     * @param NIP Numéro d'Identification Personnelle
     * @param nom
     * @param prenom
     */
    public Identite(String NIP, String nom, String prenom) {
        this.NIP = NIP;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Méthode toString assez basique
     * @return une identité
     */
    public String toString() {
        return "Identite{" + "NIP=" + NIP + ", nom=" + nom + ", prenom=" + prenom + '}';
    }
}

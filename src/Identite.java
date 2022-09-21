public class Identite {

    private String NIP;
    private String nom;
    private String prenom;

public Identite() {
        this.NIP = "";
        this.nom = "";
        this.prenom = "";
    }

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

    public String toString() {
        return "Identite{" + "NIP=" + NIP + ", nom=" + nom + ", prenom=" + prenom + '}';
    }
}

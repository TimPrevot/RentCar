package projet;

public class Agence {

    //Variables de classe
    private int ID;
    private static int count;
    private String nom;
    private String telephone;
    private String rue;
    private String ville;
    private String codePostal;
    private String coordonneesGPS;

    //Constructeur
    public Agence(String nom, String telephone, String rue, String ville, String codePostal, String coordonneesGPS) {
        this.ID = count++;
        this.nom = nom;
        this.telephone = telephone;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.coordonneesGPS = coordonneesGPS;
    }

    //Constructeur par défaut
    public Agence() {
        this.ID = count++;
    }

    //Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getCoordonneesGPS() {
        return coordonneesGPS;
    }

    public void setCoordonneesGPS(String coordonneesGPS) {
        this.coordonneesGPS = coordonneesGPS;
    }
}

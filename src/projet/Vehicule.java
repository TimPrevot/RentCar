package projet;

public class Vehicule {
    private int ID;
    private static int count;
    private String marque;
    private String modele;
    private int kilometrage;
    private boolean boiteAuto;
    private boolean climatisation;
    private int prixJour;
    private int caution;
    private boolean estLoue;
    private boolean aDeplacer;
    private Agence agenceActuelle;
    private Client clientActuel;
    private String carburant;
    private String categorie;
    private Agence nouvelleAgence;

    public Vehicule(String marque, String modele, int kilometrage, boolean boiteAuto, boolean climatisation, int prixJour, int caution, String carburant, String categorie) {
        this.ID = count ++;
        this.marque = marque;
        this.modele = modele;
        this.kilometrage = kilometrage;
        this.boiteAuto = boiteAuto;
        this.climatisation = climatisation;
        this.prixJour = prixJour;
        this.caution = caution;
        this.carburant = carburant;
        this.categorie = categorie;
    }

    public Vehicule() {
        this.ID = count++;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public boolean isBoiteAuto() {
        return boiteAuto;
    }

    public void setBoiteAuto(boolean boiteAuto) {
        this.boiteAuto = boiteAuto;
    }

    public boolean isClimatisation() {
        return climatisation;
    }

    public void setClimatisation(boolean climatisation) {
        this.climatisation = climatisation;
    }

    public int getPrixJour() {
        return prixJour;
    }

    public void setPrixJour(int prixJour) {
        this.prixJour = prixJour;
    }

    public int getCaution() {
        return caution;
    }

    public void setCaution(int caution) {
        this.caution = caution;
    }

    public boolean isEstLoue() {
        return estLoue;
    }

    public void setEstLoue(boolean estLoue) {
        this.estLoue = estLoue;
    }

    public boolean isaDeplacer() {
        return aDeplacer;
    }

    public void setaDeplacer(boolean aDeplacer) {
        this.aDeplacer = aDeplacer;
    }

    public Agence getAgenceActuelle() {
        return agenceActuelle;
    }

    public void setAgenceActuelle(Agence agenceActuelle) {
        this.agenceActuelle = agenceActuelle;
    }

    public Client getClientActuel() {
        return clientActuel;
    }

    public void setClientActuel(Client clientActuel) {
        this.clientActuel = clientActuel;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Agence getNouvelleAgence() {
        return nouvelleAgence;
    }

    public void setNouvelleAgence(Agence nouvelleAgence) {
        this.nouvelleAgence = nouvelleAgence;
    }
}

package projet;

public class Vehicule implements Cloneable{
    private int ID;
    private static int count;
    private String marque;
    private String modele;
    private int kilometrage;
    private boolean boiteAuto;
    private boolean climatisation;
    private boolean estLoue;
    private boolean aDeplacer;
    private Agence agenceActuelle;
    private Client clientActuel;
    private Carburant carburant;
    private Categorie categorie;
    private Agence nouvelleAgence;

    public Vehicule(String marque, String modele, int kilometrage, boolean boiteAuto, boolean climatisation, Carburant carburant, Categorie categorie) {
        this.ID = count ++;
        this.marque = marque;
        this.modele = modele;
        this.kilometrage = kilometrage;
        this.boiteAuto = boiteAuto;
        this.climatisation = climatisation;
        this.carburant = carburant;
        this.categorie = categorie;
    }

    public Vehicule() {
        this.ID = count++;
    }

    public int getID(){  return ID;  }

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

    public Carburant getCarburant() {
        return carburant;
    }

    public void setCarburant(Carburant carburant) {
        this.carburant = carburant;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Agence getNouvelleAgence() {
        return nouvelleAgence;
    }

    public void setNouvelleAgence(Agence nouvelleAgence) {
        this.nouvelleAgence = nouvelleAgence;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "ID=" + ID +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", kilometrage=" + kilometrage +
                ", boiteAuto=" + boiteAuto +
                ", climatisation=" + climatisation +
                ", estLoue=" + estLoue +
                ", aDeplacer=" + aDeplacer +
                ", carburant='" + carburant + '\'' +
                '}';
    }

    /**
     *
     * @return a clone of this instance.
     *
     * @see Cloneable
     */
    @Override
    public Vehicule clone() {
        Vehicule result = new Vehicule();
        result.setID(this.ID);
        result.setMarque(this.marque);
        result.setModele(this.modele);
        result.setKilometrage(this.kilometrage);
        result.setBoiteAuto(this.boiteAuto);
        result.setClimatisation(this.climatisation);
        result.setEstLoue(this.estLoue);
        result.setaDeplacer(this.aDeplacer);
        result.setAgenceActuelle(this.agenceActuelle.clone());
        result.setClientActuel(this.clientActuel.clone());
        result.setCarburant(this.carburant.clone());
        result.setCategorie(this.categorie.clone());
        result.setNouvelleAgence(this.nouvelleAgence.clone());
        return result;
    }

    public void louer(){
        estLoue = true;

    }
}

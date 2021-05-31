package projet;

import java.util.Date;
import java.time.LocalDate;

public class Client implements Cloneable{

    //Variables de classe
    private int ID;
    private boolean isConnected;
    private static int count;
    private String nom;
    private String prenom;
    private String email;
    private String rue;
    private String ville;
    private String codePostal;
    private String telephone;
    private boolean clientFidele;
    private LocalDate dateDebutFidele;
    private LocalDate dateFinFidele;
    private ProgrammeFidelite programmeSuivi;

    //Constructeur
    public Client(String nom, String prenom, String email, String rue, String ville, String codePostal, String telephone) {
        this.ID = count++;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.telephone = telephone;
        this.clientFidele = false;
    }

    //Constructeur par défaut
    public Client() {
        this.ID = count++;
    }

    //Getters et setters
    public int getID() {
        return ID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public boolean isClientFidele() {
        return clientFidele;
    }

    public void setClientFidele(boolean clientFidele) {
        this.clientFidele = clientFidele;
    }

    public LocalDate getDateDebutFidele() {
        return dateDebutFidele;
    }

    public void setDateDebutFidele(LocalDate dateDebutFidele) {
        this.dateDebutFidele = dateDebutFidele;
    }

    public LocalDate getDateFinFidele() {
        return dateFinFidele;
    }

    public void setDateFinFidele(LocalDate dateFinFidele) {
        this.dateFinFidele = dateFinFidele;
    }

    public ProgrammeFidelite getProgrammeSuivi() {
        return programmeSuivi;
    }

    public void setProgrammeSuivi(ProgrammeFidelite programme) { this.programmeSuivi = programme; }

    public void setStatus(boolean status){ this.isConnected = status; }

    public boolean getStatus() { return isConnected; }

    //Redéfinition de toString()
    @Override
    public String toString() {
        return "Client{" +
                "ID=" + ID +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

    /**
     * @return a clone of this instance.
     *
     * @see Cloneable
     */
    @Override
    public Client clone() {
        Client result = new Client();
        result.setNom(this.nom);
        result.setPrenom(this.prenom);
        result.setEmail(this.email);
        result.setRue(this.rue);
        result.setVille(this.ville);
        result.setCodePostal(this.codePostal);
        result.setTelephone(this.telephone);
        result.setClientFidele(this.clientFidele);
        result.setDateDebutFidele(this.dateDebutFidele);
        result.setDateFinFidele(this.dateFinFidele);
        result.setProgrammeSuivi(this.programmeSuivi);
        return result;
    }

    //Ajouter un programme de fidélité
    //TODO ProgrammeNotFoundException
    public void souscrireFidele(ProgrammeFidelite nouveauProgramme){
        this.programmeSuivi = nouveauProgramme;
        this.clientFidele = true;
        this.dateDebutFidele = java.time.LocalDate.now();
        this.dateFinFidele = java.time.LocalDate.now().plusYears(1);
    }

    //Renouveler le programme de fidélité actuel
    //TODO NoFideleException
    public void prolongerFidele(int duree){
        this.dateFinFidele.plusYears(duree);
    }
}

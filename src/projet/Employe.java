package projet;

import java.util.List;

public class Employe {
    private int ID;
    private static int count;
    private String nom;
    private String prenom;
    private String email;
    private String rue;
    private String ville;
    private String codePostal;
    private String telephone;
    private String login;
    private String password;
    private boolean estChauffeur;
    private List<Agence> circuit;

    public Employe(String nom, String prenom, String email, String rue, String ville, String codePostal, String telephone) {
        this.ID = count++;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.rue = rue;
        this.ville = ville;
        this.codePostal = codePostal;
        this.telephone = telephone;
    }

    public Employe() {
        this.ID = count++;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEstChauffeur() {
        return estChauffeur;
    }

    public void setEstChauffeur(boolean estChauffeur) {
        this.estChauffeur = estChauffeur;
    }
}

package projet;

import java.time.LocalDate;
import java.util.Date;

public class Devis {
    private Client client;
    private Vehicule vehiculeLoue;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private long dureeJours;
    private int montantReduction;
    private boolean assurance;
    private int prixFinal;

    public Devis() {}

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Vehicule getVehiculeLoue() {
        return vehiculeLoue;
    }

    public void setVehiculeLoue(Vehicule vehiculeLoue) {
        this.vehiculeLoue = vehiculeLoue;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public long getDureeJours() {
        return dureeJours;
    }

    public void setDureeJours(long dureeJours) {
        this.dureeJours = dureeJours;
    }

    public int getMontantReduction() {
        return montantReduction;
    }

    public void setMontantReduction(int montantReduction) {
        this.montantReduction = montantReduction;
    }

    public boolean isAssurance() {
        return assurance;
    }

    public void setAssurance(boolean assurance) {
        this.assurance = assurance;
    }

    public int getPrixFinal() {
        return prixFinal;
    }

    public void setPrixFinal(int prixFinal) {
        this.prixFinal = prixFinal;
    }
}

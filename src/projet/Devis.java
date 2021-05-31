package projet;

import connect_db.ConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Vector;

public class Devis {
    private int ID;
    private Client client;
    private Vehicule vehiculeLoue;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private long dureeJours;
    private int montantReduction;
    private boolean assurance;
    private int prixFinal;

    public Devis() {}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

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

    public void setClientInt(int clientID) throws SQLException {
        String query = "SELECT * FROM Clients WHERE client_ID='" + clientID + "'";
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        ConnectDB connectDB = new ConnectDB();
        connection = connectDB.get_Connection();

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            Client client = new Client();

            client.setID(rs.getInt("agence_ID"));
            client.setNom(rs.getString("nom"));
            client.setEmail(rs.getString("email"));
            client.setRue(rs.getString("rue"));
            client.setVille(rs.getString("ville"));
            client.setCodePostal(rs.getString("codePostal"));
            client.setTelephone(rs.getString("telephone"));
            client.setClientFidele(rs.getBoolean("clientFidele"));
            client.setDateDebutFidele(this.dateToLocalDateConverter(rs.getDate("dateDebutFidele")));
            client.setDateFinFidele(this.dateToLocalDateConverter(rs.getDate("dateFinFidele")));
            client.setProgrammeSuiviInt(rs.getInt("programmeSuivi"));

            this.setClient(client.clone());


        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public void setVehiculeInt(int vehiculeID) {
        String query = "SELECT * FROM Vehicules WHERE vehicule_ID='" + vehiculeID + "'";
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        ConnectDB connectDB = new ConnectDB();
        connection = connectDB.get_Connection();
        Vector<Vehicule> listeVehicules;

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            Vehicule vehicule = new Vehicule();
            vehicule.setID(rs.getInt("vehicule_ID"));
            vehicule.setMarque(rs.getString("marque"));
            vehicule.setModele(rs.getString("modele"));
            vehicule.setKilometrage(rs.getInt("kilometrage"));
            vehicule.setBoiteAuto(rs.getBoolean("boiteAuto"));
            vehicule.setClimatisation(rs.getBoolean("climatisation"));
            vehicule.setEstLoue(rs.getBoolean("estLoue"));
            vehicule.setaDeplacer(rs.getBoolean("aDeplacer"));
            vehicule.setAgenceActuelleInt(rs.getInt("agenceActuelle"));
            vehicule.setClientActuelInt(rs.getInt("clientActuel"));
            vehicule.setCarburantInt(rs.getInt("carburantID"));
            vehicule.setCategorieInt(rs.getInt("categorie"));
            vehicule.setNouvelleAgenceInt(rs.getInt("nouvelleAgence"));
            this.setVehiculeLoue(vehicule.clone());

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public LocalDate dateToLocalDateConverter(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public Date localDateToDateConverter(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }
}

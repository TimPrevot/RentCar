package projet;

import connect_db.ConnectDB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Vehicule implements Cloneable {
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
        this.ID = count++;
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

    public int getID() {
        return ID;
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

    public void setAgenceActuelleInt(int agenceID) throws SQLException {
        String query = "SELECT * FROM Agences WHERE agence_ID='" + agenceID + "'";
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        ConnectDB connectDB = new ConnectDB();
        connection = connectDB.get_Connection();

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            Agence agenceActuelle = new Agence();
            agenceActuelle.setID(rs.getInt("agence_ID"));
            agenceActuelle.setNom(rs.getString("nom"));
            agenceActuelle.setTelephone(rs.getString("telephone"));
            agenceActuelle.setRue(rs.getString("rue"));
            agenceActuelle.setVille(rs.getString("ville"));
            agenceActuelle.setCodePostal(rs.getString("codePostal"));
            agenceActuelle.setCoordonneesGPS(rs.getString("coordonneesGPS"));

            this.setAgenceActuelle(agenceActuelle.clone());

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

    }

    public Client getClientActuel() {
        return clientActuel;
    }

    public void setClientActuel(Client clientActuel) {
        this.clientActuel = clientActuel;
    }

    public void setClientActuelInt(int clientID) throws SQLException {
        String query = "SELECT * FROM Clients WHERE client_ID='" + clientID + "'";
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        ConnectDB connectDB = new ConnectDB();
        connection = connectDB.get_Connection();

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            Client clientActuel = new Client();

            clientActuel.setID(rs.getInt("agence_ID"));
            clientActuel.setNom(rs.getString("nom"));
            clientActuel.setEmail(rs.getString("email"));
            clientActuel.setRue(rs.getString("rue"));
            clientActuel.setVille(rs.getString("ville"));
            clientActuel.setCodePostal(rs.getString("codePostal"));
            clientActuel.setTelephone(rs.getString("telephone"));
            clientActuel.setClientFidele(rs.getBoolean("clientFidele"));
            clientActuel.setDateDebutFidele(this.dateToLocalDateConverter(rs.getDate("dateDebutFidele")));
            clientActuel.setDateFinFidele(this.dateToLocalDateConverter(rs.getDate("dateFinFidele")));
            clientActuel.setProgrammeSuiviInt(rs.getInt("programmeSuivi"));

            this.setClientActuel(clientActuel.clone());


        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public Carburant getCarburant() {
        return carburant;
    }

    public void setCarburant(Carburant carburant) {
        this.carburant = carburant;
    }

    public void setCarburantInt(int carburant_ID) {
        String query = "SELECT * FROM Carburants WHERE carburant_ID='" + carburant_ID + "'";
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        ConnectDB connectDB = new ConnectDB();
        connection = connectDB.get_Connection();

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            Carburant carburant = new Carburant();

            carburant.setID(rs.getInt("carburant_ID"));
            carburant.setNom(rs.getString("nom"));
            this.setCarburant(carburant.clone());

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public void setCategorieInt(int categorieID) {
        String query = "SELECT * FROM Carburants WHERE categorie_ID='" + categorieID + "'";
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        ConnectDB connectDB = new ConnectDB();
        connection = connectDB.get_Connection();

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            Categorie categorie = new Categorie();

            categorie.setID(rs.getInt("categorie_ID"));
            categorie.setNom(rs.getString("nom"));
            categorie.setPrixJour(rs.getInt("prixJour"));
            categorie.setCaution(rs.getInt("caution"));
            this.setCategorie(categorie.clone());

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }

    public Agence getNouvelleAgence() {
        return nouvelleAgence;
    }

    public void setNouvelleAgence(Agence nouvelleAgence) {
        this.nouvelleAgence = nouvelleAgence;
    }

    public void setNouvelleAgenceInt(int agenceID) throws SQLException {
        String query = "SELECT * FROM Agences WHERE agence_ID='" + agenceID + "'";
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        ConnectDB connectDB = new ConnectDB();
        connection = connectDB.get_Connection();

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            Agence nouvelleAgence = new Agence();
            nouvelleAgence.setID(rs.getInt("agence_ID"));
            nouvelleAgence.setNom(rs.getString("nom"));
            nouvelleAgence.setTelephone(rs.getString("telephone"));
            nouvelleAgence.setRue(rs.getString("rue"));
            nouvelleAgence.setVille(rs.getString("ville"));
            nouvelleAgence.setCodePostal(rs.getString("codePostal"));
            nouvelleAgence.setCoordonneesGPS(rs.getString("coordonneesGPS"));

            this.setNouvelleAgence(nouvelleAgence.clone());

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

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
     * @return a clone of this instance.
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

    public void louer() {
        estLoue = true;

    }

    public LocalDate dateToLocalDateConverter(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public Date localDateToDateConverter(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }
}

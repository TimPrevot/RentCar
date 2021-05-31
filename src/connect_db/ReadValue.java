package connect_db;

import projet.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class ReadValue {

    public static void main(String[] args) {
        ReadValue reader = new ReadValue();
        reader.readValues("SELECT * FROM employee");
    }

    public void readValues(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        ConnectDB obj_ConnectDB = new ConnectDB();
        connection = obj_ConnectDB.get_Connection();

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                System.out.print(rs.getString("sl_no"));
                System.out.print(rs.getString("name"));
                System.out.println(rs.getString("address"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //WIP
    public Vector<Vehicule> readVehicules(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        ConnectDB connectDB = new ConnectDB();
        connection = connectDB.get_Connection();
        Vector<Vehicule> listeVehicules = new Vector<>();

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                Vehicule vehicule = new Vehicule();
                vehicule.setMarque(rs.getString("marque"));
                vehicule.setModele(rs.getString("modele"));
                vehicule.setKilometrage(rs.getInt("kilometrage"));
                vehicule.setBoiteAuto(rs.getBoolean("boiteAuto"));
                vehicule.setClimatisation(rs.getBoolean("climatisation"));
                vehicule.setEstLoue(rs.getBoolean("estLoue"));
                vehicule.setaDeplacer(rs.getBoolean("aDeplacer"));
                vehicule.setAgenceActuelleInt(rs.getInt("agenceActuelle"));
                vehicule.setClientActuelInt(rs.getInt("clientActuel"));
                vehicule.setCarburantInt(rs.getInt("typeCarburant"));
                vehicule.setCategorieInt(rs.getInt("categorie"));
                vehicule.setNouvelleAgenceInt(rs.getInt("nouvelleAgence"));
                listeVehicules.add(vehicule);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return listeVehicules;
    }

    public Vector<Categorie> readCategories(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        ConnectDB connectDB = new ConnectDB();
        connection = connectDB.get_Connection();
        Vector<Categorie> listeCategories = new Vector<>();

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                Categorie categorie = new Categorie();
                categorie.setID(rs.getInt("categorie_ID"));
                categorie.setNom(rs.getString("nom"));
                categorie.setPrixJour(rs.getInt("prixJour"));
                categorie.setCaution(rs.getInt("caution"));
                listeCategories.add(categorie);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return listeCategories;
    }

    public Vector<Agence> readAgences(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        ConnectDB connectDB = new ConnectDB();
        connection = connectDB.get_Connection();
        Vector<Agence> listeAgences = new Vector<>();

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                Agence agence = new Agence();
                agence.setNom(rs.getString("nom"));
                agence.setTelephone(rs.getString("telephone"));
                agence.setRue(rs.getString("rue"));
                agence.setVille(rs.getString("ville"));
                agence.setCodePostal(rs.getString("codePostal"));
                agence.setCoordonneesGPS(rs.getString("coordonneesGPS"));
                listeAgences.add(agence);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return listeAgences;
    }

    public Vector<Employe> readEmployes(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        ConnectDB connectDB = new ConnectDB();
        connection = connectDB.get_Connection();
        Vector<Employe> listeEmployes = new Vector<>();

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                Employe employe = new Employe();
                employe.setNom(rs.getString("nom"));
                employe.setPrenom(rs.getString("prenom"));
                employe.setEmail(rs.getString("email"));
                employe.setRue(rs.getString("rue"));
                employe.setVille(rs.getString("ville"));
                employe.setCodePostal(rs.getString("codePostal"));
                employe.setTelephone(rs.getString("telephone"));
                employe.setLogin(rs.getString("login"));
                employe.setPassword(rs.getString("password"));
                employe.setEstChauffeur(rs.getBoolean("estChauffeur"));
                listeEmployes.add(employe);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return listeEmployes;
    }

    public Vector<Client> readClient(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        ConnectDB connectDB = new ConnectDB();
        connection = connectDB.get_Connection();
        Vector<Client> listeClients = new Vector<>();

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                Client client = new Client();
                client.setNom(rs.getString("nom"));
                client.setPrenom(rs.getString("prenom"));
                client.setEmail(rs.getString("email"));
                client.setRue(rs.getString("rue"));
                client.setVille(rs.getString("ville"));
                client.setCodePostal(rs.getString("codePostal"));
                client.setTelephone(rs.getString("telephone"));
                client.setClientFidele(rs.getBoolean("clientFidele"));
                client.setDateDebutFidele(dateToLocalDateConverter(rs.getDate("dateDebutFidele")));
                client.setDateFinFidele(dateToLocalDateConverter(rs.getDate("dateFinFidele")));
                client.setProgrammeSuiviInt(rs.getInt("programmeSuivi"));
                listeClients.add(client);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return listeClients;
    }

    public Vector<Carburant> readCarburants(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        ConnectDB connectDB = new ConnectDB();
        connection = connectDB.get_Connection();
        Vector<Carburant> listeCarburants = new Vector<>();

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                Carburant carburant = new Carburant();
                carburant.setID(rs.getInt("carburant_ID"));
                carburant.setNom(rs.getString("nom"));
                listeCarburants.add(carburant);
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return listeCarburants;
    }

    public Vector<ProgrammeFidelite> readProgrammes(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        ConnectDB connectDB = new ConnectDB();
        connection = connectDB.get_Connection();
        Vector<ProgrammeFidelite> listeProgrammes = new Vector<>();

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()){
                ProgrammeFidelite programme = new ProgrammeFidelite();
                programme.setID(rs.getInt("programme_ID"));
                programme.setDescription(rs.getString("description"));
                programme.setPrix(rs.getInt("prix"));
                programme.setReduction(rs.getInt("reduction"));
                listeProgrammes.add(programme);
            }

        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return listeProgrammes;
    }

    public Vector<Devis> readDevis(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        ConnectDB connectDB = new ConnectDB();
        connection = connectDB.get_Connection();
        Vector<Devis> listeDevis = new Vector<>();

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
             while (rs.next()){
                 Devis devis = new Devis();
                 devis.setID(rs.getInt("devis_ID"));
                 devis.setClientInt(rs.getInt("client"));
                 devis.setVehiculeInt(rs.getInt("vehicule"));
                 devis.setDateDebut(dateToLocalDateConverter(rs.getDate("dateDebut")));
                 devis.setDateFin(dateToLocalDateConverter(rs.getDate("dateFin")));
                 devis.setDureeJours(rs.getInt("dureeJours"));
                 devis.setMontantReduction(rs.getInt("montantReduction"));
                 devis.setAssurance(rs.getBoolean("assurance"));
                 devis.setPrixFinal(rs.getInt("prixFinal"));
                 listeDevis.add(devis);
             }

        } catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return listeDevis;
    }

    public LocalDate dateToLocalDateConverter(Date dateToConvert) {
        return Instant.ofEpochMilli(dateToConvert.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public Date localDateToDateConverter(LocalDate dateToConvert) {
        return java.sql.Date.valueOf(dateToConvert);
    }
}

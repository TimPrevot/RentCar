package connect_db;

import projet.Categorie;
import projet.Vehicule;
import projet.Magasin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ReadValue {

    public static void main(String[] args) {
        ReadValue reader = new ReadValue();
        reader.readValues("SELECT * FROM employee");
    }

    public void readValues(String query){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        ConnectDB obj_ConnectDB = new ConnectDB();
        connection = obj_ConnectDB.get_Connection();

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while(rs.next()){
                System.out.print(rs.getString("sl_no"));
                System.out.print(rs.getString("name"));
                System.out.println(rs.getString("address"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    //WIP
    public List<Vehicule> readVehicules(String query){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        ConnectDB connectDB = new ConnectDB();
        connection = connectDB.get_Connection();
        Vector<Vehicule> listeVehicules = new Vector<>();

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()){
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
                vehicule.setCarburantInt(rs.getInt("carburantID"));
                vehicule.setCategorieInt(rs.getInt("categorie"));
                vehicule.setNouvelleAgenceInt(rs.getInt("nouvelleAgence"));
                listeVehicules.add(vehicule);
            }
        } catch (SQLException sqle){
            sqle.printStackTrace();
        }
        return listeVehicules;
    }

    public List<Categorie> readCategories(String query){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;

        ConnectDB connectDB = new ConnectDB();
        connection = connectDB.get_Connection();
        Vector<Categorie> listeCategories = new Vector<>();

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()){
                Categorie categorie = new Categorie();
                categorie.setNom(rs.getString("nom"));
                categorie.setPrixJour(rs.getInt("prixJour"));
                categorie.setCaution(rs.getInt("caution"));
                listeCategories.add(categorie);
            }
            return(Vector<Categorie>);
        } catch (SQLException sqle){
            sqle.printStackTrace();
        }
    }
}

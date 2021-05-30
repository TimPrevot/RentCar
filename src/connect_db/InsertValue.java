package connect_db;

import java.sql.Connection;
import java.sql.Statement;

public class InsertValue {

    public void main(String[] args){
        InsertValue adder = new InsertValue();
        adder.insertValue("maTable", "colonne", "valeurs");
    }

    public void insertValue (String table, String columns, String values) {
        Connection connection = null;
        Statement statement = null;

        ConnectDB obj_ConnectDB = new ConnectDB();
        connection = obj_ConnectDB.get_Connection();

        try {
            String query = "insert into bdd1."+table+"("+columns+") values("+values+")";
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Values inserted successfully");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

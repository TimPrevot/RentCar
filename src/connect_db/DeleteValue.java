package connect_db;

import java.sql.Connection;
import java.sql.Statement;

public class DeleteValue {

    public static void main(String[] args) {
        DeleteValue eraser = new DeleteValue();
        eraser.deleteValue("employee", "sl_no='2'");
    }

    public void deleteValue(String table, String condition) {
        Connection connection = null;
        Statement statement = null;

        ConnectDB obj_ConnectDB = new ConnectDB();
        connection = obj_ConnectDB.get_Connection();

        try {
            String query = "delete from bdd1."+table+ " where "+condition;
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Values deleted successfully");

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

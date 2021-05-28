package connect_db;

import java.sql.Connection;
import java.sql.Statement;

public class EditValue {
    public static void main(String[] args) {
        EditValue editor = new EditValue();
        editor.updateValues("employee", "name", "Jean", "sl_no='1'");
    }

    public void updateValues(String table, String column, String newValue, String condition) {
        Connection connection = null;
        Statement statement = null;

        ConnectDB obj_ConnectDB = new ConnectDB();
        connection = obj_ConnectDB.get_Connection();

        try {
            String query = "update bdd1."+table+" set "+column+"='"+newValue+"' where "+condition;
            System.out.println(query);
            statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Update executed successfully");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

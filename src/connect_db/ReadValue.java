package connect_db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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
}

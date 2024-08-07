package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
    public static Connection con = null;

    public static Connection dbConnection() {
        if (con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/movieticket_booking",
                        "root", "Achielles@20");
            } catch (Exception e) {
                System.err.println("Error--->" + e);
            }
        }
        return con;
    }

}

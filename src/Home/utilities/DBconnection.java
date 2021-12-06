package Home.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection
{
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url ="jdbc:mysql://localhost/hospital system";
    private static String username = "root";
    private static   String password = "";
    private static Connection con;

    public static Connection connect(){
        try {
            //Regisgter Driver
            Class.forName(driver);
            //Establish the connection
            con = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}

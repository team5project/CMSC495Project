package testgui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AWSConnection {
    String url = "jdbc:mysql://mysqlinstance.cmlrtubxh7mp.us-east-2.rds.amazonaws.com:3306/Team5DB";
    String user = "admin";
    String password = "Skating1";
    Connection conn = null;

    public Connection dbConnection() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Database Connected");
        } catch (SQLException e) {
            e.getMessage();
            System.out.println("Connection Failed " + e.getLocalizedMessage());
        }
        return conn;
    }
}

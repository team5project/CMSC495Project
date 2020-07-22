package testgui;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userCheck {
    boolean userCheck = false;
    AWSConnection conn = new AWSConnection();
    PreparedStatement ps;
    ResultSet rs;

    boolean checkUserName(String username){
        try {
            ps = conn.dbConnection().prepareStatement("SELECT * FROM user_login WHERE username = ?");
            ps.setString(1,username);
            rs = ps.executeQuery();
            if (rs.next()){
                userCheck = true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userCheck;
    }
}

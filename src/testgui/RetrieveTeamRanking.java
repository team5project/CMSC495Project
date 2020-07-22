package testgui;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class RetrieveTeamRanking {
    PreparedStatement ps;
    ResultSet rs;
    AWSConnection conn = new AWSConnection();

    void getTeamRanking() throws SQLException {
        ps = conn.dbConnection().prepareStatement("SELECT * FROM team_ranking");
        ResultSetMetaData rsmd = rs.getMetaData();

    }

}

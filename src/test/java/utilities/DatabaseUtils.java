package utilities;

import java.sql.*;

public class DatabaseUtils {
    public static Connection connectingDB(){
        Connection connection= null;
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://managementonschools.com:5432/school_management","select_user","43w5ijfso");
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }
        return connection;
    }
    public static Statement statementDB(){
        Statement statement=null;
        try {
            statement = connectingDB().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return    statement;
    }


    public static ResultSet getResultSet(String query) {

        try {
            return statementDB().executeQuery(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
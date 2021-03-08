package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ResultSet rs=null;
        Statement stmt=null;
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection con = databaseConnection.getConnection();
        try{
            stmt = con.createStatement();
            rs=stmt.executeQuery("select * from employees");
            while(rs.next()){
                System.out.println(rs.getString(2));
            }
            stmt.close();
            con.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

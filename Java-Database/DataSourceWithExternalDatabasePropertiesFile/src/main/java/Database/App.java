package Database;

import com.mysql.cj.jdbc.JdbcPropertySetImpl;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;
//import com.sun.rowset.JdbcRowSetImpl;



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
            RowSetFactory rowSetFactory = RowSetProvider.newFactory();
            JdbcRowSet rowSet = rowSetFactory.createJdbcRowSet();
            rowSet.setUrl("jdbc:mysql://localhost:3306/schema");
            rowSet.setUsername("root");
            rowSet.setPassword("123");
            rowSet.setCommand("select * from employee");
            rowSet.execute();
            while(rowSet.next()){
                System.out.println(rowSet.getString(2)+" "+rowSet.getString(3)+" " +
                        ""+rowSet.getString(4)+" "+rowSet.getString(6)+"\n");
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
//        catch (ClassNotFoundException e) {
//
//            e.printStackTrace();
//        }
    }
}

package Database;

import com.mysql.cj.jdbc.JdbcPropertySetImpl;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import java.sql.*;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try{
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection con = databaseConnection.getConnection();
            con.setAutoCommit(false);
            RowSetFactory rowSetFactory = RowSetProvider.newFactory();
            CachedRowSet rowSet = rowSetFactory.createCachedRowSet();
            rowSet.setUrl("jdbc:mysql://localhost:3306/schema");
            rowSet.setType(ResultSet.TYPE_SCROLL_SENSITIVE);
            rowSet.setConcurrency(ResultSet.CONCUR_UPDATABLE);
            rowSet.setUsername("root");
            rowSet.setPassword("123");
            rowSet.setCommand("select * from employee");
            rowSet.setKeyColumns(new int []{1});
            rowSet.execute(con);
            while(rowSet.next()){
                System.out.println(rowSet.getString(2)+" "+rowSet.getString(3)+" " +
                        ""+rowSet.getString(4)+" "+rowSet.getString(6)+"\n");
            }
            System.out.println("-------------------------------------------------------------------------------");
            rowSet.first();
            rowSet.updateInt("age",10);
            rowSet.updateRow();

            rowSet.next();
            rowSet.setShowDeleted(false);
            rowSet.deleteRow();
            rowSet.acceptChanges();
            //rowSet.acceptChanges();
            rowSet.beforeFirst();
            while(rowSet.next()){
                System.out.println(rowSet.getString(2)+" "+rowSet.getString(3)+" " +
                        ""+rowSet.getString(4)+" "+rowSet.getString(6)+"\n");
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

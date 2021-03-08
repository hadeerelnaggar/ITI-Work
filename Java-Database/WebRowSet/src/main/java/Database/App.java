package Database;

//import com.mysql.cj.jdbc.JdbcPropertySetImpl;

import javax.sql.rowset.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
            RowSetFactory rowSetFactory = RowSetProvider.newFactory();
            WebRowSet webRowSet = rowSetFactory.createWebRowSet();
            webRowSet.setUrl("jdbc:mysql://localhost:3306/schema");
            webRowSet.setType(ResultSet.TYPE_SCROLL_SENSITIVE);
            webRowSet.setConcurrency(ResultSet.CONCUR_UPDATABLE);
            webRowSet.setUsername("root");
            webRowSet.setPassword("123");
            webRowSet.setCommand("select * from employee");
            webRowSet.execute();
            while(webRowSet.next()){
                System.out.println(webRowSet.getString("f_name")+" "+webRowSet.getString("l_name")+" " +
                        ""+webRowSet.getString("Sex")+" "+webRowSet.getInt("Age")+"\n");
            }
            FileOutputStream fileOutputStream = new FileOutputStream("employees.xml");
            webRowSet.writeXml(fileOutputStream);
        }
        catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

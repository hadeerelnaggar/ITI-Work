package Database;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myschema","root","123");
            Statement statement = connection.createStatement();
            String query = "select * from employees";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                System.out.println("Fields: "+ rs.getInt(1)+rs.getString(2));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

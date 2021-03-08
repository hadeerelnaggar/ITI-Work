package useredit.server.daos;

import useredit.common.CommonUser;
import useredit.utilities.DatabaseConnection;

import java.sql.*;

public class UserDao {
    Statement stmt;
    Connection con;
    ResultSet rs;
    private static UserDao userDao=null;
    private UserDao(){
        connect();
        getAllUsers();
    }
    public static synchronized UserDao getInstance(){
        if(userDao==null)
            userDao=new UserDao();
        return userDao;
    }

    public void getAllUsers(){
        try {
            stmt=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs=stmt.executeQuery("select * from users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addUser(CommonUser user){
        try {
            int id = getLast()==null? 1 : Integer.parseInt(getLast().getId())+1;
            PreparedStatement preparedStatement = con.prepareStatement("insert into users values (?,?,?,?,?,?)");
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,user.getFirstName());
            preparedStatement.setString(3,user.getMiddleName());
            preparedStatement.setString(4,user.getLastName());
            preparedStatement.setString(5,user.getEmail());
            preparedStatement.setString(6,user.getPhone());
            preparedStatement.executeUpdate();
            getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateUser(CommonUser user){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("update users set firstname = ? , middlename = ? , lastName = ? , " +
                    "email = ? , phone = ? where id = ? ");
            preparedStatement.setString(1,user.getFirstName());
            preparedStatement.setString(2,user.getMiddleName());
            preparedStatement.setString(3,user.getLastName());
            preparedStatement.setString(4,user.getEmail());
            preparedStatement.setString(5,user.getPhone());
            preparedStatement.setInt(6,Integer.parseInt(user.getId()));
            preparedStatement.executeUpdate();
            getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteUser(CommonUser user){
        try {
            PreparedStatement preparedStatement = con.prepareStatement("delete from users where id = ?");
            preparedStatement.setString(1,user.getId());
            preparedStatement.executeUpdate();
            getAllUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean hasnext(){
        boolean bool=false;
        try{
        bool = rs.next();
        rs.previous();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return bool;
    }
    public boolean hasprev(){
        boolean bool=false;
        try{
            bool = rs.previous();
            rs.next();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return bool;
    }
    public CommonUser getFirst(){
        try {
            rs.beforeFirst();
            if(rs.next()){
                return new CommonUser(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public CommonUser getNext(){
        try {
            if(rs.next()){
                return new CommonUser(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public CommonUser getPrevious(){
        try {
            if(rs.previous()){
                return new CommonUser(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public CommonUser getLast(){
        try {
            rs.afterLast();
            if(rs.previous()){
                return new CommonUser(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void connect(){
        DatabaseConnection databaseConnection = new DatabaseConnection();
        con = databaseConnection.getConnection();
    }
    public void closeDao(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}

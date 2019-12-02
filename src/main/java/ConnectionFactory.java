import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/jdbccrudlab"; // jdbc:mysql://localhost:3306/dbname
    public static final String USER = "root";
    public static final String PASS = "zipcode78";

    /**
     * Get a connection to database
     *
     * @return Connection object
     */

//    public static Connection getConnection() {
//        try {
//            DriverManager.registerDriver(new Driver());
//            return DriverManager.getConnection(URL, USER, PASS);
//        } catch (SQLException ex) {
//            throw new RuntimeException("Error connecting to the database", ex);
//        }
//    }

    /**
     * Test ConnectionCo
     */

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;
    public static void main(String[] args) {
//        Connection connection = ConnectionFactory.getConnection();
        String query = "select count(*) from Vegetables";

        try{
            con = DriverManager.getConnection(URL,USER,PASS);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            while(rs.next()){
                int count =rs.getInt(1);
                System.out.println("Total veggies in tables : " + count);
            }
        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }finally {
            try{con.close();} catch(SQLException se){}
            try{stmt.close();}catch (SQLException se){}
            try{rs.close();} catch(SQLException se) {}
            }
        }
    }


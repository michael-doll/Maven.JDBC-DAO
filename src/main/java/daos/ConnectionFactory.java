package daos;

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
     * Test ConnectionCo
     */

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void main(String[] args) {


    }

    public static Connection getConnection(){
//        String query = "select count(*) from Vegetables";
        try{
            con = DriverManager.getConnection(URL,USER,PASS);
//            stmt = con.createStatement();
//            rs = stmt.executeQuery(query); // Query
//
//            while(rs.next()){
//                int count =rs.getInt(1);
//                System.out.println("Total veggies in tables : " + count);

//            }
        }catch (SQLException sqlEx){
            sqlEx.printStackTrace();
        }
        return null ;
    }
}


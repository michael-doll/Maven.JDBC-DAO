package daos;

import com.sun.jdi.connect.Connector;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO implements DAOInterface {

    private List<Vegetables> veggiesList = new ArrayList<Vegetables>();
    Connection connection = ConnectionFactory.getConnection();


    @Override
    public Vegetables findById(Integer id) {
        // Should follow this example
        //private User extractUserFromResultSet(ResultSet rs) throws SQLException {
        //    User user = new User();
        //    user.setId( rs.getInt("id") );
        //    user.setName( rs.getString("name") );
        //    user.setPass( rs.getString("pass") );
        //    user.setAge( rs.getInt("age") );
        //    return user;
        //}
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Vegetables WHERE vegetableId=" + id);
            if(resultSet.next()) {
                Vegetables veg = new Vegetables();
                veg.setVegetableId(id);
                veg.setVegetableName(resultSet.getString("vegetableName"));
                return veg;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            try{connection.close();} catch(SQLException se){}
//
//        }
        return null;
    }

    @Override
    public List<Vegetables> findAll() {
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Vegetables");
            while(resultSet.next()){
                Vegetables veg = new Vegetables();
                veg.setVegetableName(resultSet.getString("vegetableName"));
                System.out.println(veg.getVegetableName()); // Test
                veggiesList.add(veg);
            }
            return veggiesList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean update(Vegetables dto) {

        try {
            PreparedStatement ps = createStatement(statementType.UPDATE,connection,dto);
            assert ps != null;
            int c = ps.executeUpdate();
            if(c == 1){
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
//        finally {
//            try{connection.close();}
//            catch(SQLException se) {
//                se.printStackTrace();
//                }
//        }
        return false;
    }

    @Override
    public Boolean create(Vegetables dto) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }

    private PreparedStatement createStatement(statementType stmnt, Connection connection, Vegetables veg) throws SQLException {
        PreparedStatement ps;
    if(stmnt.getStatementType().equals("Insert")){
        ps = connection.prepareStatement("INSERT INTO vegetables VALUES (NULL,?,?,?,?)");
        ps.setString(1, veg.getVegetableName());
        ps.setString(2, veg.getVegetableColor());
        ps.setString(3, veg.getVegetableTexture());
        ps.setString(4, veg.getVegetableWeight());
        return ps;
    }
        if(stmnt.getStatementType().equals("Update")){
            ps = connection.prepareStatement("UPDATE vegetables SET vegetableName=?,vegetableColor=?,vegetableTexture=? WHERE vegetableId=?");
            ps.setString(1, veg.getVegetableName());
            ps.setString(2, veg.getVegetableColor());
            ps.setString(3, veg.getVegetableTexture());
            ps.setString(4, veg.getVegetableWeight());
            return ps;
    }
        return null;
}

enum statementType {
    INSERT(1, "Insert"), UPDATE(2, "Update");
    private String statementType;
    private Integer key;

    statementType(Integer key, String statementType) {
        this.key = key;
        this.statementType = statementType;
    }

    public String getStatementType() {
        return statementType;
    }

    public Integer getKey() {
        return key;
    }

    }
}

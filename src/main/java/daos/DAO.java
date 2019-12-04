package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO implements DAOInterface {

    private List<Vegetables> veggiesList = new ArrayList<Vegetables>();
    Connection connection = ConnectionFactory.getConnection();


    @Override
    public Vegetables findById(Integer id) {
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
                return veggiesList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean update(Vegetables dto) {
        return null;
    }

    @Override
    public Boolean create(Vegetables dto) {
        return null;
    }

    @Override
    public Boolean delete(Integer id) {
        return null;
    }

}

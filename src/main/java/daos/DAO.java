package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAO implements DAOInterface {

    private List<Vegetables> veggiesList = new ArrayList<Vegetables>();

    @Override
    public Vegetables findById(Integer id) {
        try{
            Connection connection = ConnectionFactory.getConnection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Vegetables WHERE vegetableId=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            try{connection.close();} catch(SQLException se){}
//        }
        return null;
    }

    @Override
    public List<Vegetables> findAll() {
//        try{
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM Vegetables");
//            while(resultSet.next()){
//                veggiesList.add(new Vegetables(resultSet.getString("vegetableName")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
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

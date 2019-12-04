package daos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAOTest {
    DAO dao;

    @Before
    public void setUp(){
        dao = new DAO();
    }

    @Test
    public void connectionTest() throws SQLException {
        dao.connection.close();
        Assert.assertTrue(dao.connection.isClosed());
    }

    @Test
    public void findByIdTest() {
    String expected = "Carrot";
    String actual = dao.findById(1).getVegetableName();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findAllTest() {
        List<Vegetables> testList = dao.findAll();
        for(Vegetables veggies: testList){
            System.out.println(veggies.getVegetableName());
        }
    }

    @Test
    public void updateTest() {
    }

    @Test
    public void createTest() {
    }

    @Test
    public void deleteTest() {
    }
}
package daos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Array;
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
//Not a good test
    @Test
    public void findAllTest() {
        List<Vegetables> actualList = dao.findAll();
        //Testing first and last
        Assert.assertEquals(actualList.get(0).getVegetableName(),"Arugula");
        Assert.assertEquals(actualList.get(actualList.size()-1).getVegetableName(),"Corn");
    }
    //Not currently testing an update**
    @Test
    public void updateTest() {
        Vegetables current = dao.findById(2);
        String expected = "Different Color";
        current.setVegetableColor(expected);
        String actual = current.getVegetableColor();
        dao.update(current);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void createTest() {
    }

    @Test
    public void deleteTest() {
    }
}
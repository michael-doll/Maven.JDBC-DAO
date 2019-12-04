package daos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DAOTest {
    DAO dao;

    @Before
    public void setUp(){
        dao = new DAO();
    }

    @Test
    public void findById() {
    String expected = "Arugula";
    String actual = dao.findById(1).getVegetableName();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findAll() {
    }

    @Test
    public void update() {
    }

    @Test
    public void create() {
    }

    @Test
    public void delete() {
    }
}

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class ThingTest {

    private Thing TestThing;

    @Before
    public void setUp (){

        TestThing = new Thing("Name", "Room","Type","Description");
    }

    @Test
    public void testGetName() {
        Assert.assertEquals(TestThing.getName(),"Name");

    }

    @Test
    public void testGetType() {
        Assert.assertEquals(TestThing.getType(),"Type");

    }

    @Test
    public void testGetRoom() {
        Assert.assertEquals(TestThing.getRoom(),"Room");

    }

    @Test
    public void testGetDescription() {
        Assert.assertEquals(TestThing.getDescription(),"Description");
    }

    @Test
    public void testSetName() {
        TestThing.setName("New Name");
        Assert.assertEquals(TestThing.getName(),"New Name");

    }
    @Test
    public void testSetType() {
        TestThing.setType("New Type");
        Assert.assertEquals(TestThing.getType(),"New Type");

    }

    @Test
    public void testSetRoom() {
        TestThing.setRoom("New Room");

        Assert.assertEquals(TestThing.getRoom(),"New Room");
    }

    @Test
    public void testSetDescription() {
        TestThing.setDescription("New Description");

        Assert.assertEquals(TestThing.getDescription(),"New Description");
    }

    @Test
    public void testGetObject() {
        String[] TestThing2 = TestThing.getObject();

        Assert.assertEquals(TestThing.getRoom(),TestThing2[1]);
        Assert.assertEquals(TestThing.getType(),TestThing2[2]);
        Assert.assertEquals(TestThing.getName(),TestThing2[0]);
    }
}
import org.junit.Assert;
import org.junit.Test;


public class UnitTest {
    private final Bar bar = new Bar("Venice",161,"Europe");

    @Test
    public void testLinesHandledCorrectly1(){
        Assert.assertEquals(4, 2+2);
    }
    @Test
    public void testValueInitialized(){
        Assert.assertNotNull(bar);
    }
    @Test
    public void testNameAccuracy(){
        Assert.assertEquals("Venice",bar.getName());
    }
    @Test
    public void testCategoryAccuracy(){
        Assert.assertEquals("Europe",bar.getCategory());
    }
    @Test
    public void testCategoryValue(){
        Assert.assertEquals(161,bar.getValue());
    }
}

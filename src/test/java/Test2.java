import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by SK on 10.07.2017.
 */

public class Test2 {

    Main.Singleton x  = new Main.Singleton();

    @BeforeMethod()
    public void before() {
        x.populate();
    }

    @DataProvider
    public Object[][] ValidDataProvider() {
        return new Object[][]{
                { 25, "Pass" },{ 65, "Fail" },
                { 15, "Pass" },{ 55, "Fail" },
        };
    }

    @Test()
    public void testGet() {
        Assert.assertTrue(x.get().matches(".*ass.*"));
    }

    @Test()
    public void testGet2() {
        Assert.assertTrue(x.get().matches(".*ass.*"));
    }

    @Test(dataProvider = "ValidDataProvider")
    public void testChange(final int numberOfArray, final String booleanValue) {
        x.change(numberOfArray,booleanValue);
        Assert.assertEquals(booleanValue, x.get(numberOfArray));
    }

    @AfterMethod()
    public void after() {
        System.out.println("After");
    }

}

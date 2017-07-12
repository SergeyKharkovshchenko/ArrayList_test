import org.testng.Assert;
import org.testng.annotations.*;

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

    @Test(dataProvider = "ValidDataProvider")
    public void testChange(final int numberOfArray, final String trueOrFalse) {
        x.change(numberOfArray,trueOrFalse);
        Assert.assertEquals(trueOrFalse, x.get(numberOfArray));
    }

    @Test()
    @Parameters("trueOrFalse2")
    public void testChange2(@Optional("test") final String trueOrFalse2) {
//      public void testChange2(final String trueOrFalse2) {
        x.change(5, trueOrFalse2);
        Assert.assertEquals(trueOrFalse2, x.get(5));
    }

    @AfterMethod()
    public void after() {
        System.out.println("After");
    }

}

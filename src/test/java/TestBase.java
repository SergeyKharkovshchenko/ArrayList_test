import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by SK on 10.07.2017.
 */

public class TestBase {



    @BeforeMethod()
    public void before() { System.out.println("Before");   }

    @Test()
    public class Test_01 {
        public void testGet() {
            Main.Singleton x  = new Main.Singleton();
            x.populate();
            Assert.assertTrue(x.get().matches(".*a.*"));
        }
    }


    @Test(dataProvider = "ValidDataProvider")
    public class Test_02 {

        @DataProvider
        public Object[][] ValidDataProvider() {
            return new Object[][]{
                    { 25, "Pass" },{ 65, "Fail" },
                    { 15, "Pass" },{ 55, "Fail" },
            };
        }

         public void testChange2(final int numberOfArray, final String trueOrFalse) {
            Main.Singleton x  = new Main.Singleton();
            x.populate();
            x.change(numberOfArray,trueOrFalse);
            Assert.assertEquals(trueOrFalse, x.get(numberOfArray));
        }
    }


    @Test()
    public class Test_03 {
        @Parameters("trueOrFalse2")
        public void testChange2(@Optional("test") final String trueOrFalse2) {
//      public void testChange2(final String trueOrFalse2) {
            Main.Singleton x  = new Main.Singleton();
            x.populate();
            x.change(5, trueOrFalse2);
            Assert.assertEquals(trueOrFalse2, x.get(5));
        }
    }

    @AfterMethod()
    public void after() {
        System.out.println("After");
    }

}

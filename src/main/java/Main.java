import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by SK on 10.07.2017.
 */
public class Main {

    public static class Singleton {

        private static Singleton instance;

        Singleton() {}

        public static synchronized Singleton getInstance() {
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }

        public List<String> stringsList = new ArrayList<String>();

        public void populate() {
            for (int i = 0; i < 100; i++) {
                Random rand = new Random();
                String stringValue = null;
                if (rand.nextBoolean()==true)
                    {stringValue = "Pass";}
                else
                    {stringValue = "Fail";}
                stringsList.add(stringValue);
            }
//            System.out.println("arrayList: " + stringsList);
        }

        public void change(int posNumb, String newValue) {
              stringsList.set(posNumb,newValue);
            }

        public String get() {
            Random rand = new Random();
            return stringsList.get(rand.nextInt(100));
        }

        public String get(int y) {
            return stringsList.get(y);
        }
    }

    public static void main(String[] args) {
        Singleton x = new Singleton ();
//        x.getInstance();
        x.populate();
        System.out.println("arrayList #: " + x.get());
        x.change(25,"false");
    }
}

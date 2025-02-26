package royal;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ReadFiles {
    public static void main(String[] args) {
        try {
            String basePath = System.getProperty("user.dir");
            File file = new File(basePath + "/data/restaurant-1/orders/1.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
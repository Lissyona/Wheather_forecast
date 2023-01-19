import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Scanner;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONObject;

public class Main {

    private static Scanner scanner;
    private static PrintStream printStream;

    public Main(InputStream inputStream, PrintStream printStream) {
        scanner = new Scanner(inputStream);
        Main.printStream = printStream;
        nemain();
    }


    public static void main(String[] args) {
        Main inputLocation = new Main(System.in, System.out);
        System.out.println(inputLocation);


    }

    private void nemain() {

        String getUserCity = "moscow";
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" +
                getUserCity +
                "&units=metric&appid=e34e4c19711deb09f38f50619aa775c1";
        if(!getUserCity.equals("")) {
            String output = getUrlContent(url);

            if (!output.isEmpty()) {
                JSONObject obj = new JSONObject(output);
                System.out.println(obj.getJSONObject("main").getDouble("temp"));


            }
        }
    }
            private static String getUrlContent(String urlAdress) {
                StringBuffer content = new StringBuffer();

                try {
                    URL url = new URL(urlAdress);
                    URLConnection urlConn = url.openConnection();

                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                    String line;

                    while((line = bufferedReader.readLine()) != null) {
                        content.append(line + "\n");
                    }
                    bufferedReader.close();
                } catch(Exception e) {
                    System.out.println("Такой город был не найден!");
                }
                return content.toString();
            }



}
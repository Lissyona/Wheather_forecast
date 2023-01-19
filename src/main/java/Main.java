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
        printStream.println("Input city");
        String city  = scanner.nextLine();
        printStream.println("Convert to Fahrenheit(Fahr) or Celsius(C) or if you want contact creator this app(CrEaToR)?");
        String mode = scanner.nextLine();

        if (mode.equals("С")) {
            getCelsius(city);

        } else if (mode.equals("Fahr")) {
            getFahrenheit(city);
        } else if (mode.equals("CrEaToR")) {
            System.out.println("Соц. сеть с фотокарточками: _ti.mur.ovna_");
        } else
            System.out.println("incorrect input");


    }


    public static void main(String[] args) {

        Main inputLocation = new Main(System.in, System.out);



    }

    public void getCelsius(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" +
                city +
                "&units=metric&appid=e34e4c19711deb09f38f50619aa775c1";
        if(!city.equals("")) {
            String output = getUrlContent(url);

            if (!output.isEmpty()) {
                JSONObject obj = new JSONObject(output);
                System.out.println((int)obj.getJSONObject("main").getDouble("temp"));

            }
        }
    }

    public void getFahrenheit(String city) {
        String url = "https://api.openweathermap.org/data/2.5/weather?q=" +
                city +
                "&units=metric&appid=e34e4c19711deb09f38f50619aa775c1";
        if(!city.equals("")) {
            String output = getUrlContent(url);

            if (!output.isEmpty()) {
                JSONObject obj = new JSONObject(output);
                System.out.println((int)(1.8 * (int) obj.getJSONObject("main").getDouble("temp") + 32));

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
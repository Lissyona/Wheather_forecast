
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

class MainTest {

    @Test
    void getCelsius() {
        String inputData = "moscow \nC";
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        Main main = new Main(inputStream, printStream);
        try{
            Integer.parseInt(main.getCelsius("moscow"));

        }catch (NumberFormatException e){
            Assertions.fail();
        }
    }

    @Test
    void getFahrenheit() {
        String inputData = "moscow \nFahr";
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(out);
        Main main = new Main(inputStream, printStream);
        try{
            Integer.parseInt(main.getFahrenheit("moscow"));

        }catch (NumberFormatException e){
            Assertions.fail();
        }
    }
}
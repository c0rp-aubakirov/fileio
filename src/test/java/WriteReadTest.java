import java.io.IOException;

public class WriteReadTest {

    public static void main(String[] args) {
        try {
            final String filename = "/tmp/UIB_1";

            WriteRead.writeToFile(filename, "fhsdhdhgdfhgfd");

            final String content = WriteRead.readFromFile(filename);

            final String content2 = WriteRead.readFromFile8(filename);

            System.out.println(content2);

        } catch (IOException e) {
            System.out.println("IO EXCEPTION");
        }
    }

}

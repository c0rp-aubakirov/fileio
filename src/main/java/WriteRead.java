import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import org.apache.commons.io.output.FileWriterWithEncoding;

/**
 * @author Sanzhar Aubakirov (c0rp.aubakirov@gmail.com)
 */
public class WriteRead {

    public static void writeToFile(final String filename,
        final String content) throws IOException {
        final Writer writer = new FileWriterWithEncoding(filename, StandardCharsets.UTF_8);
        writer.write("Можно записать любую строчку");
        writer.write("Это новая строчка");
        writer.write("И еще одна");
        writer.flush();
        writer.close();
    }

    public static String readFromFile(String filename) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filename)));
        return content;
    }

    public static String readFromFile8(String filename) throws IOException {
        String content = Files.lines(Paths.get(filename), StandardCharsets.UTF_8).collect(Collectors.joining());
        return content;
    }

}

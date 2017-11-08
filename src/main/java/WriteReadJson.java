import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;
import org.apache.commons.io.output.FileWriterWithEncoding;

/**
 * @author Sanzhar Aubakirov (c0rp.aubakirov@gmail.com)
 */
public class WriteReadJson {

    private static final Logger logger = Logger.getLogger(WriteReadJson.class.getName());
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void saveUser(final User user, final String filename) throws IOException {
        final Writer writer = new FileWriterWithEncoding(filename, StandardCharsets.UTF_8);
        gson.toJson(user, writer);
        writer.flush();
        writer.close();
    }

    public static User loadUser(String filename) throws IOException {
        final File file = new File(filename);
        try (final Reader fileReader = new InputStreamReader(new FileInputStream(file), "UTF-8")) {
            final JsonReader reader = new JsonReader(fileReader);
            final User user = gson.fromJson(reader, User.class);
            return user;
        }
    }

    public static class User {
        private final String username;
        private final String password;

        public User(final String username, final String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return this.username;
        }

        public String getPassword() {
            return this.password;
        }
    }

}

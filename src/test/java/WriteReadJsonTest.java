import java.io.IOException;

public class WriteReadJsonTest {

    public static void main(String[] args) throws IOException {
        final WriteReadJson.User user = new WriteReadJson.User("u1", "p1");

        final String filename = "/tmp/2";

        WriteReadJson.saveUser(user, filename);

        final WriteReadJson.User user1 = WriteReadJson.loadUser(filename);

        System.out.println(user1.getPassword());
        System.out.println(user1.getUsername());
    }

}

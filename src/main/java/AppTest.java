import com.goit.javacore5dev.feature.storage.DatabaseInitService;
import com.goit.javacore5dev.feature.storage.Storage;

public class AppTest {
    public static void main(String[] args) {
        Storage storage = Storage.getInstance();

        new DatabaseInitService().initDb(storage);
    }
}

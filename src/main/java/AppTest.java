import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class AppTest {
    public static void main(String[] args) {
        String connectionUrl = "jdbc:h2:./testdb";
        try (Connection connection = DriverManager.getConnection(connectionUrl);) {
            Statement statement = connection.createStatement();
            //statement.executeUpdate("CREATE TABLE test_table (name VARCHAR(100))");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}

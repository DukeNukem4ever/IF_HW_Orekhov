package BaseTest;
import org.junit.jupiter.api.BeforeEach;
import utils.DriverManager;

public class BaseTest {
    @BeforeEach
    void setUp() {
        DriverManager.setup();
    }
}
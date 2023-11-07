import main.UserInterface;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class UserInterfaceTest {
    UserInterface ui;
    @BeforeEach
    void setUp() throws IOException {
        ui = new UserInterface();
    }

    @AfterEach
    void tearDown() {
        ui = null;
    }
}

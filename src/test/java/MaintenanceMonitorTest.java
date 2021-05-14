import at.monitor.MaintenanceMonitorController;
import org.junit.jupiter.api.*;

// taken from https://www.baeldung.com/junit-5-test-order
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MaintenanceMonitorTest {
    @Test
    @Order(1)
    void testResetMessage() {
        // arrange
        final var controller = new MaintenanceMonitorController();

        // act
        controller.resetMessage();
        final var message = controller.getMessage();

        // assert
        Assertions.assertEquals("-", message);
    }

    @Test
    @Order(2)
    void testGetMessage() {
        // arrange
        final var controller = new MaintenanceMonitorController();

        // act
        final var message = controller.getMessage();

        // assert
        Assertions.assertEquals("-", message);
    }

    @Test
    @Order(3)
    void testSetMessage() {
        // arrange
        final var controller = new MaintenanceMonitorController();

        // act
        controller.setMessage("test");
        final var message = controller.getMessage();

        // assert
        Assertions.assertEquals("test", message);
    }
}

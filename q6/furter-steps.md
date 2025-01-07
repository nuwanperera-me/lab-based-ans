This assumes you are using the TestFX library for testing JavaFX applications.

Step 1: Add TestFX Dependency If using Maven, add the following dependency to your pom.xml:

 
<dependency>
    <groupId>org.testfx</groupId>
    <artifactId>testfx-core</artifactId>
    <version>4.0.16-alpha</version>
</dependency>
<dependency>
    <groupId>org.testfx</groupId>
    <artifactId>testfx-junit5</artifactId>
    <version>4.0.16-alpha</version>
    <scope>test</scope>
</dependency>
 
Step 2: Test Case

 
import javafx.application.Platform;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationTest;
import ui.JavaFXInterface;
 
import static org.junit.jupiter.api.Assertions.assertEquals;
 
public class GUITest extends ApplicationTest {
 
    private ListView<String> ticketListView;
 
    @Override
    public void start(Stage stage) {
        JavaFXInterface app = new JavaFXInterface();
        app.start(stage);
        ticketListView = lookup("#ticketListView").queryAs(ListView.class); // ID must be set in JavaFXInterface
    }
 
    @BeforeEach
    public void setUp() {
        Platform.runLater(() -> ticketListView.getItems().clear());
    }
 
    @Test
    public void testRealTimeUpdates() {
        Platform.runLater(() -> {
            ticketListView.getItems().add("Ticket-1");
            ticketListView.getItems().add("Ticket-2");
        });
 
        // Wait for the JavaFX thread to complete
        FxRobot.waitForFxEvents();
 
        // Verify the updates in the ListView
        assertEquals(2, ticketListView.getItems().size());
        assertEquals("Ticket-1", ticketListView.getItems().get(0));
        assertEquals("Ticket-2", ticketListView.getItems().get(1));
 
        // Simulate a ticket removal
        Platform.runLater(() -> ticketListView.getItems().remove(0));
 
        FxRobot.waitForFxEvents();
 
        // Verify the ListView after removal
        assertEquals(1, ticketListView.getItems().size());
        assertEquals("Ticket-2", ticketListView.getItems().get(0));
    }
}
How It Works
Setup: The start method initializes the JavaFXInterface, and the ticketListView is retrieved by its ID (make sure to set the ID in the JavaFX code using setId).
Test Actions:
Tickets are added and removed using Platform.runLater(), ensuring updates happen on the JavaFX Application Thread.
The FxRobot.waitForFxEvents() method ensures all JavaFX events have been processed before assertions.
Assertions:
The ListView is checked for correct ticket additions and removals.
Setting the ID in JavaFXInterface
Update your JavaFXInterface to assign an ID to the ListView for testing:

ticketListView = new ListView<>();
ticketListView.setId("ticketListView"); // Add this line
 
Running the Test
Ensure the TestFX library is configured in your project.
Run the test using JUnit5 in your IDE or via Maven.
×
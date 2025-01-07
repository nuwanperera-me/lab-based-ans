package ui;

import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import core.TicketPool;

public class JavaFXInterface {
  private ListView<String> ticketListView;

  @Override
  public void start(Stage primaryStage) {
    // Initialize GUI components
    ticketListView = new ListView<>();
    // Add ListView to grid
    gridPane.add(new Label("Ticket Pool:"), 0, 8);
    gridPane.add(ticketListView, 0, 9, 2, 1);
    // Configure ListView size
    ticketListView.setPrefHeight(200);
    ticketListView.setPrefWidth(300);
    // Update ticket display method
    updateTicketList();
  }

  // Method to update ticket display
private void updateTicketList() {
Platform.runLater(() -> {
ticketListView.getItems().clear(); // Clear current items
ticketListView.getItems().addAll(ticketPool.getTickets()); // Add
updated tickets
});
}
}
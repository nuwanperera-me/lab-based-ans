private ListView<String> ticketListView;

@Override

public void start(Stage primaryStage) {

  // Initialize GUI components as before

  ticketListView = new ListView<>();

  gridPane.add(new Label("Ticket Pool:"), 0, 8);

  gridPane.add(ticketListView, 0, 9, 2, 1);

}

private void updateTicketList() {

  Platform.runLater(() -> {

    ticketListView.getItems().clear();

    ticketListView.getItems().addAll(ticketPool.getTickets());

  });

}
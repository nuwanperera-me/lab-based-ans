package threads;

import core.TicketRetrievalStrategy;
import logging.Logger;

public class Customer implements Runnable {
  private final TicketRetrievalStrategy retrievalStrategy;

  public Customer(TicketRetrievalStrategy retrievalStrategy) {
    this.retrievalStrategy = retrievalStrategy;
  }

  @Override
  public void run() {
    while (true) {
      String ticket = retrievalStrategy.retrieveTicket();
      if (ticket != null) {
        Logger.log(ticket, "retrieved");
      } else {
        Logger.log("No tickets available", "retrieve");
        break;
      }
    }
  }
}
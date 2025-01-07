package threads;

import core.TicketPool;
import logging.Logger;

public class StatisticsReporter implements Runnable {
  private final TicketPool ticketPool;

  public StatisticsReporter(TicketPool ticketPool) {
    this.ticketPool = ticketPool;
  }

  @Override
  public void run() {
    while (true) {
      try {
        Logger.log("Total Tickets Added: X", "stats");
        Logger.log("Total Tickets Removed: Y", "stats");
        Logger.log("Current Tickets in Pool: " + ticketPool.getTicketCount(), "stats");
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        Logger.log("Statistics reporting interrupted", "error");
        break;
      }
    }
  }
}
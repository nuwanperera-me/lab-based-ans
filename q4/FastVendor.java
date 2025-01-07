package threads;

import core.TicketPool;
import logging.Logger;

public class FastVendor extends Vendor {
  public FastVendor(TicketPool ticketPool, int ticketReleaseRate) {
    super(ticketPool, ticketReleaseRate * 2);
  }

  @Override
  public void run() {
    super.run();
    Logger.log("FastVendor completed", "info");
  }
}
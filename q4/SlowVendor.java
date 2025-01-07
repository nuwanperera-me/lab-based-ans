package threads;

import core.TicketPool;
import logging.Logger;

public class SlowVendor extends Vendor {
  public SlowVendor(TicketPool ticketPool, int ticketReleaseRate) {
    super(ticketPool, ticketReleaseRate / 2);
  }

  @Override
  public void run() {
    super.run();
    Logger.log("SlowVendor completed", "info");
  }
}
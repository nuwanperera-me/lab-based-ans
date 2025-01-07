import core.TicketPool;
import threads.FastVendor;
import threads.SlowVendor;

public class VendorBehaviorTest {
  public static void main(String[] args) {
    TicketPool ticketPool = new TicketPool();

    // FastVendor
    Thread fastVendor = new Thread(new FastVendor(ticketPool, 5));
    // SlowVendor
    Thread slowVendor = new Thread(new SlowVendor(ticketPool, 5));

    fastVendor.start();
    slowVendor.start();
  }
}
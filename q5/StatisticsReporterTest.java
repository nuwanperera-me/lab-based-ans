import core.TicketPool;
import threads.StatisticsReporter;

public class StatisticsReporterTest {
  public static void main(String[] args) {
    TicketPool ticketPool = new TicketPool();

    // Add tickets for testing
    ticketPool.addTickets("Ticket-1");
    ticketPool.addTickets("Ticket-2");

    // Start statistics reporting
    Thread statsReporter = new Thread(new StatisticsReporter(ticketPool));
    statsReporter.start();

    // Simulate adding and removing tickets
    ticketPool.removeTicket();
    ticketPool.addTickets("Ticket-3");

    try {
      Thread.sleep(10000); // Let stats run for a while
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    statsReporter.interrupt(); // Stop reporting
  }
}
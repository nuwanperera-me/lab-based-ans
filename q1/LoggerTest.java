package q1;

import core.TicketPool;

public class LoggerTest {
  public static void main(String[] args) {

    TicketPool ticketPool = new TicketPool();

    // Add tickets and verify logs
    ticketPool.addTickets("Ticket-1");
    ticketPool.addTickets("Ticket-2");

    // Remove tickets and verify logs
    ticketPool.removeTicket();
    ticketPool.removeTicket();
  }
}

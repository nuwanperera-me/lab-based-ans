package core;

public class IDRetrieval implements TicketRetrievalStrategy {
  private final TicketPool ticketPool;

  public IDRetrieval(TicketPool ticketPool) {
    this.ticketPool = ticketPool;
  }

  @Override
  public String retrieveTicket() {
    // Implement logic for ID-based retrieval (simplified here) - YOU NEED TO ADD
    // THE LOGIC
    return ticketPool.removeTicket(); // Placeholder
  }
}
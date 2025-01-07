import core.*;
import threads.Customer;

public class CustomerFunctionalityTest {
  public static void main(String[] args) {
    TicketPool ticketPool = new TicketPool();

    // Add tickets to pool
    ticketPool.addTickets("Priority-Ticket-1");
    ticketPool.addTickets("ID-Ticket-2");

    // Test Priority Retrieval
    TicketRetrievalStrategy priorityRetrieval = new PriorityRetrieval(ticketPool);
    Thread priorityCustomer = new Thread(new Customer(priorityRetrieval));

    // Test ID Retrieval
    TicketRetrievalStrategy idRetrieval = new IDRetrieval(ticketPool);
    Thread idCustomer = new Thread(new Customer(idRetrieval));

    priorityCustomer.start();
    idCustomer.start();
  }
}
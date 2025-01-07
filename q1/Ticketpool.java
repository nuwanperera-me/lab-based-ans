package core;

import logging.Logger;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TicketPool implements TicketOperation {

  private final List<String> tickets = Collections.synchronizedList(new LinkedList<>());

  @Override

  public synchronized void addTickets(String ticket) {
    tickets.add(ticket);
    Logger.log(ticket, "add");
  }

  @Override
  public synchronized String removeTicket() {
    String ticket = tickets.isEmpty() ? null : tickets.remove(0);
    Logger.log(ticket, "remove");
    return ticket;
  }

  public int getTicketCount() {
    return tickets.size();
  }
}

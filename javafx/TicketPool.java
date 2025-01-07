package core;

import logging.Logger;

// TicketPool class implementing wait-notify mechanism for producer-consumer
public class TicketPool {
  // Shared data between producer and consumer
  private int ticket; // The ticket data
  private boolean isAvailable; // Flag to check if ticket is available
  private int totalProduced; // Counter for total tickets produced
  private final int maxTickets; // Maximum number of tickets to produce

  public TicketPool(int maxTickets) {
    this.ticket = 0;
    this.isAvailable = false;
    this.totalProduced = 0;
    this.maxTickets = maxTickets;
  }

  // Method for consumer to get ticket
  public synchronized int getTicket() {
    // While no ticket is available, consumer waits
    while (!isAvailable) {
      try {
        wait();
      } catch (InterruptedException e) {
        Logger.log("Consumer interrupted while waiting", "error");
        Thread.currentThread().interrupt();
      }
    }
    // Once ticket is available, consume it
    isAvailable = false; // Mark as consumed
    notifyAll(); // Notify producers waiting to produce
    Logger.log("Ticket-" + ticket + " consumed", "consume");
    return ticket;
  }

  // Method for producer to add ticket
  public synchronized void addTicket(int ticketNumber) {
    // While ticket is available, producer waits
    while (isAvailable) {
      try {
        wait();
      } catch (InterruptedException e) {
        Logger.log("Producer interrupted while waiting", "error");
        Thread.currentThread().interrupt();
      }
    }
    // Check if we've reached maximum tickets
    if (totalProduced >= maxTickets) {
      return;
    }
    // Produce new ticket
    this.ticket = ticketNumber;
    isAvailable = true; // Mark as available
    totalProduced++;
    Logger.log("Ticket-" + ticketNumber + " produced", "produce");
    notifyAll(); // Notify consumers waiting to consume
  }

  // Check if all tickets have been produced
  public boolean isComplete() {
    return totalProduced >= maxTickets;
  }

  // Get total number of tickets produced
  public int getTotalProduced() {
    return totalProduced;
  }
}
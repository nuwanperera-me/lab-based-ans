package config;

import exceptions.InvalidConfigurationException;

public class Configuration {
  private int totalTickets;
  private int ticketReleaseRate;
  private int customerRetrievalRate;
  private int maxTicketCapacity;

  public Configuration(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity)
      throws InvalidConfigurationException {
    if (totalTickets <= 0 || ticketReleaseRate <= 0 || customerRetrievalRate <= 0 || maxTicketCapacity <= 0) {
      throw new InvalidConfigurationException("All configuration values must be positive.");
    }
    this.totalTickets = totalTickets;
    this.ticketReleaseRate = ticketReleaseRate;
    this.customerRetrievalRate = customerRetrievalRate;
    this.maxTicketCapacity = maxTicketCapacity;
  }
}
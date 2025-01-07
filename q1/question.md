1. Logging for Ticket Operations

Task: Modify the Logger class to log all ticket operations (addTickets and removeTicket) in a standardized format.

Solution:

Update the Logger class to include the ticket ID, operation type (add/remove), and timestamp for each log entry.
In the TicketPool class, use the updated Logger to log operations inside the addTickets and removeTicketmethods.
Test Case:
Add tickets using the addTickets method and ensure logs include ticket IDs and timestamps.
Remove tickets using the removeTicket method and verify logs for consistency.
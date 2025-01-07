2. Extending Customer Functionality with Interfaces
Task: Introduce TicketRetrievalStrategy for different retrieval methods.
Solution:
Define an interface TicketRetrievalStrategy with methods for priority-based and ID-based retrieval.
Implement PriorityRetrieval and IDRetrieval classes.
Update Customer class to use the TicketRetrievalStrategy interface.
Test Case: Use both retrieval methods in different scenarios and confirm expected behavior.
package logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class Logger {
  private static final String LOG_FILE = "resources/logs.txt";

  public static void log(String ticketId, String operation) {
    String timeStampedMessage = String.format("%s: Ticket ID: %s, Operation: %s", LocalDateTime.now(), ticketId, operation);
    System.out.println(timeStampedMessage);

    try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
      writer.write(timeStampedMessage);
      writer.newLine();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

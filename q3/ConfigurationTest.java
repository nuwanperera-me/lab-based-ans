import config.Configuration;
import exceptions.InvalidConfigurationException;

public class ConfigurationTest {
  public static void main(String[] args) {
    try {
      // Valid configuration
      Configuration validConfig = new Configuration(100, 10, 5, 50);
      System.out.println("Configuration created successfully!");

      // Invalid configuration
      Configuration invalidConfig = new Configuration(-100, 10, 5, 50);
    } catch (InvalidConfigurationException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
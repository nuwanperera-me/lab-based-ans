3. Exception Handling for Invalid Configurations
   Task: Create a custom InvalidConfigurationException to validate system parameters.
   Solution:
   Add validation checks in the Configuration class to ensure positive integers for all parameters.
   Throw InvalidConfigurationException with descriptive messages for invalid values.
   Test Case: Provide invalid inputs via CLI and verify exception handling prompts the user for corrections.

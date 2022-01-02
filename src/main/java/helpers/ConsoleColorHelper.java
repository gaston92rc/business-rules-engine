package helpers;

public class ConsoleColorHelper {
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String RED = "\033[0;31m";     // RED
    public static final String CYAN = "\033[0;36m";    // CYAN

    // Bold
    public static final String RED_BOLD = "\033[1;31m";    // RED

    // Underline
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN

    // High Intensity
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN

    // Bold High Intensity
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE

    public static void consoleColorized(String message, String color) {
        System.out.println(color + message + RESET);
    }
}
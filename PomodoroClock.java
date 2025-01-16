// Import necessary libraries
import java.util.Scanner;

public class PomodoroClock {

    public static void main(String[] args) {
        // Welcome message
        System.out.println("Welcome to the Pomodoro Clock!");

        // Scanner to collect user input
        Scanner scanner = new Scanner(System.in);

        // Get task name
        System.out.print("Enter the task name: ");
        String taskName = scanner.nextLine();

        // Get total time in minutes
        System.out.print("Enter the total time in minutes: ");
        int totalTime = getValidInput(scanner);

        // Get Pomodoro session duration
        System.out.print("Enter the duration of each Pomodoro session in minutes: ");
        int pomodoroDuration = getValidInput(scanner);

        // Get short break duration
        System.out.print("Enter the short break duration in minutes: ");
        int shortBreak = getValidInput(scanner);

        // Get long break duration
        System.out.print("Enter the long break duration in minutes: ");
        int longBreak = getValidInput(scanner);

        // Calculate the total number of Pomodoro sessions
        int totalPomodoros = totalTime / pomodoroDuration;
        int longBreakInterval = 4; // Long break after every 4 sessions

        // Run the Pomodoro sessions
        for (int session = 1; session <= totalPomodoros; session++) {
            // Start the Pomodoro session
            System.out.println("Pomodoro session " + session + " started for " + pomodoroDuration + " minutes.");
            startTimer(pomodoroDuration);

            // Determine the break type
            if (session % longBreakInterval == 0 && session != totalPomodoros) {
                System.out.println("Long break for " + longBreak + " minutes.");
                startTimer(longBreak);
            } else if (session != totalPomodoros) {
                System.out.println("Short break for " + shortBreak + " minutes.");
                startTimer(shortBreak);
            }
        }

        // End message
        System.out.println("Task complete! Total time spent on '" + taskName + "': " + totalTime + " minutes.");
        scanner.close();
    }

    /**
     * Helper method to ensure valid integer input from the user.
     * 
     * @param scanner Scanner object for user input
     * @return Valid integer entered by the user
     */
    private static int getValidInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the buffer
            }
        }
    }

    /**
     * Simulates a timer by pausing the program for the specified duration.
     * 
     * @param minutes Number of minutes for the timer
     */
    private static void startTimer(int minutes) {
        try {
            // Simulate a timer by pausing the program for the duration
            Thread.sleep(minutes * 60 * 1000); // Convert minutes to milliseconds
        } catch (InterruptedException e) {
            System.out.println("Timer interrupted.");
        }
    }
}

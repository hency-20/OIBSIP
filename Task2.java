import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            playGame(scanner);

            System.out.print("Do you want to play another round? (yes/no): ");
            String playAgain = scanner.nextLine().toLowerCase();

            if (!playAgain.equals("yes")) {
                System.out.println("Thanks for playing. Goodbye!");
                break;
            }
        }

        scanner.close();
    }

    private static void playGame(Scanner scanner) {
        // Generate a random number between 0 and 100
        int n = (int) (Math.random() * 100);
        int maxAttempts = 10;  
        int attempts = 0;
        int score = 100;

        while (attempts < maxAttempts) {
            score--;

            System.out.print("Enter a number: ");
            int guess;
            try {
                guess = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            if (guess < 0 || guess > 100) {
                System.out.println("Please enter a valid number between 0 and 100.");
                continue;
            }

            attempts++;

            // Check if the guess is correct
            if (guess == n) {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                break;
            } else if (guess > n) {
                System.out.println("The value is smaller than what you entered. Try again!");
            } else {
                System.out.println("The value is greater than what you entered. Try again!");
            }
        }

        // Display the final score
        System.out.println("Your final score is: " + score);
    }
}

import java.util.*;

public class RockPaperScissors {

    // Method to get computer choice randomly
    public static String getComputerChoice() {
        int choice = (int)(Math.random() * 3); // 0, 1, 2
        if (choice == 0) return "Rock";
        else if (choice == 1) return "Paper";
        else return "Scissors";
    }
    
    public static String getChoice(int choice) {
        if (choice == 0) return "Rock";
        else if (choice == 1) return "Paper";
        else return "Scissors";
    }

    // Method to find winner of a single game
    public static String findWinner(String user, String computer) {
        if (user.equals(computer)) return "Draw";
        if (user.equals("Rock") && computer.equals("Scissors")) return "User";
        if (user.equals("Scissors") && computer.equals("Paper")) return "User";
        if (user.equals("Paper") && computer.equals("Rock")) return "User";
        return "Computer";
    }

    // Method to calculate stats: wins and percentages
    public static String[][] calculateStats(int userWins, int computerWins, int draws, int totalGames) {
        String[][] stats = new String[3][2];
        stats[0][0] = "User Wins"; stats[0][1] = String.valueOf(userWins);
        stats[1][0] = "Computer Wins"; stats[1][1] = String.valueOf(computerWins);
        stats[2][0] = "Draws"; stats[2][1] = String.valueOf(draws);
        return stats;
    }

    // Method to display results of all games and stats
    public static void displayResults(String[] userChoices, String[] compChoices, String[] winners, String[][] stats, int totalGames) {
        // Print header
        System.out.println("User\t\tComputer\t\tWinner");

        // Print each game's results
        for (int i = 0; i < totalGames; i++) {
            // Convert user's numeric choice to text using getChoice method
            String userChoiceText = getChoice(Integer.parseInt(userChoices[i]));
            System.out.println(userChoiceText + "\t\t" + compChoices[i] + "\t\t" + winners[i]);
        }

        System.out.println("--------------------------");

        // Print summary stats
        for (int i = 0; i < stats.length; i++) {
            System.out.println(stats[i][0] + ": " + stats[i][1]);
        }

        // Calculate and print winning percentages
        double userPercent = (Integer.parseInt(stats[0][1]) * 100.0) / totalGames;
        double compPercent = (Integer.parseInt(stats[1][1]) * 100.0) / totalGames;

        System.out.println("User Winning Percentage: " + userPercent + "%");
        System.out.println("Computer Winning Percentage: " + compPercent + "%");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int userWins = 0, computerWins = 0, draws = 0;

        int n = sc.nextInt(); // number of games
        String[] userChoices = new String[n];
        String[] compChoices = new String[n];
        String[] winners = new String[n];

        for (int i = 0; i < n; i++) {
            userChoices[i] = sc.next(); // user input: 0, 1, or 2
            String userChoiceText = getChoice(Integer.parseInt(userChoices[i]));
            compChoices[i] = getComputerChoice();
            winners[i] = findWinner(userChoiceText, compChoices[i]);

            if (winners[i].equals("User")) userWins++;
            else if (winners[i].equals("Computer")) computerWins++;
            else draws++;
        }

        String[][] stats = calculateStats(userWins, computerWins, draws, n);
        displayResults(userChoices, compChoices, winners, stats, n);
    }
}
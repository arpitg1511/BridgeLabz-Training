
import java.util.*;

/*
 * Simple data class to store creator details
 */
class CreatorStats {
    public String creatorName;
    public double[] weeklyLikes;

    public CreatorStats() {
        this.creatorName = null;
        this.weeklyLikes = new double[4];
    }

    public CreatorStats(String creatorName, double[] weeklyLikes) {
        this.creatorName = creatorName;
        this.weeklyLikes = weeklyLikes;
    }
}

/*
 * Main program class
 */
public class StreamBuzz {

    // Shared list for storing all creators
    public static List<CreatorStats> engagementBoard = new ArrayList<>();

    // Register a creator
    public void registerCreator(CreatorStats record) {
        engagementBoard.add(record);
        System.out.println("Creator registered successfully\n");
    }

    // Count posts with likes above a given threshold
    public Map<String, Integer> getTopPostCounts(double likeThreshold) {
        Map<String, Integer> result = new LinkedHashMap<>();

        for (CreatorStats creator : engagementBoard) {
            int count = 0;
            for (double likes : creator.weeklyLikes) {
                if (likes >= likeThreshold) {
                    count++;
                }
            }
            if (count > 0) {
                result.put(creator.creatorName, count);
            }
        }
        return result;
    }

    // Calculate overall average likes
    public double calculateAverageLikes() {
        double totalLikes = 0;
        int totalEntries = 0;

        for (CreatorStats creator : engagementBoard) {
            for (double likes : creator.weeklyLikes) {
                totalLikes += likes;
                totalEntries++;
            }
        }

        return totalEntries == 0 ? 0 : totalLikes / totalEntries;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StreamBuzz program = new StreamBuzz();
        boolean exit = false;

        while (!exit) {

            System.out.println("1. Register Creator");
            System.out.println("2. Show Top Posts");
            System.out.println("3. Calculate Average Likes");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Creator Name: ");
                    String name = sc.nextLine();

                    double[] likes = new double[4];
                    System.out.println("Enter weekly likes (Week 1 to 4):");
                    for (int i = 0; i < 4; i++) {
                        likes[i] = sc.nextDouble();
                    }
                    sc.nextLine();

                    program.registerCreator(new CreatorStats(name, likes));
                    break;

                case 2:
                    System.out.print("Enter like threshold: ");
                    double threshold = sc.nextDouble();
                    sc.nextLine();

                    Map<String, Integer> topPosts = program.getTopPostCounts(threshold);
                    if (topPosts.isEmpty()) {
                        System.out.println("No top-performing posts this week");
                    } else {
                        for (Map.Entry<String, Integer> entry : topPosts.entrySet()) {
                            System.out.println(entry.getKey() + " - " + entry.getValue());
                        }
                    }
                    break;

                case 3:
                    double averageLikes = program.calculateAverageLikes();
                    System.out.println("Overall average weekly likes: " + (int) averageLikes);
                    break;

                case 4:
                    System.out.println("Logging off - Keep Creating with StreamBuzz!");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice. Try again!");
            }
        }
        sc.close();
    }
}

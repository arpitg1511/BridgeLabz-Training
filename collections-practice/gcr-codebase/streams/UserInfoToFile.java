import java.io.*;

public class UserInfoToFile {

    public static void main(String[] args) {
        BufferedReader br = null;
        FileWriter fw = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your name: ");
            String name = br.readLine();

            System.out.print("Enter your age: ");
            String age = br.readLine();

            System.out.print("Enter your favorite programming language: ");
            String language = br.readLine();

            // Open file in write mode
            fw = new FileWriter("user_info.txt");

            fw.write("Name: " + name + "\n");
            fw.write("Age: " + age + "\n");
            fw.write("Favorite Programming Language: " + language + "\n");

            System.out.println("Information saved to user_info.txt");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close resources safely
            try {
                if (br != null) br.close();
                if (fw != null) fw.close();
            } catch (IOException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}

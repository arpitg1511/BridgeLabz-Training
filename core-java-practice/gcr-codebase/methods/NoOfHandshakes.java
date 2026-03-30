import java.util.*;

public class NoOfHandshakes {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ans = handshakes(n);
        System.out.println(ans);

        sc.close();
    }

    // Method to calculate number of handshakes
    public static int handshakes(int n) {
        int q = n * (n - 1);
        return q / 2;
    }
}

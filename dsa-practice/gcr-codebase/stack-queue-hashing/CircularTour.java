import java.util.*;

public class CircularTour {

    public static int findStartingPoint(int[] petrol, int[] distance) {

        int n = petrol.length;
        Queue<Integer> q = new LinkedList<>();

        int balance = 0;
        int start = 0;
        int count = 0;
        int i = 0;

        while (count < n) {

            q.offer(i);
            balance += petrol[i] - distance[i];

            // if balance goes negative, discard current tour
            while (balance < 0 && !q.isEmpty()) {
                int removed = q.poll();
                balance -= (petrol[removed] - distance[removed]);
                start = removed + 1;
            }

            i = (i + 1) % n;
            count++;
        }

        // final check
        return (balance >= 0 && q.size() > 0) ? start : -1;
    }

    public static void main(String[] args) {

        int[] petrol = {6, 3, 7};
        int[] distance = {4, 6, 3};

        System.out.println(findStartingPoint(petrol, distance));
    }
}

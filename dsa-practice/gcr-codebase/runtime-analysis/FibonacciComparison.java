public class FibonacciComparison {

    public static void main(String[] args) {
        int[] fibNumbers = {10, 30, 50};

        for (int n : fibNumbers) {
            System.out.println("Fibonacci N = " + n);

            // Recursive
            long start = System.nanoTime();
            if (n <= 40) // limit recursion to avoid long execution
                fibonacciRecursive(n);
            long end = System.nanoTime();
            System.out.println("Recursive: " + (end - start) / 1_000_000.0 + " ms");

            // Iterative
            start = System.nanoTime();
            fibonacciIterative(n);
            end = System.nanoTime();
            System.out.println("Iterative: " + (end - start) / 1_000_000.0 + " ms");

            System.out.println("---------------------------------");
        }
    }

    // Recursive Fibonacci
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}

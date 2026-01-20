public class StringComparison {

    public static void main(String[] args) {

        int[] sizes = {1000, 10000, 1_000_000};

        for (int n : sizes) {
            System.out.println("Operations Count: " + n);

            // String
            long start = System.nanoTime();
            String s = "";
            for (int i = 0; i < n; i++) s += "x";
            long end = System.nanoTime();
            System.out.println("String: " + (end - start) / 1_000_000.0 + " ms");

            // StringBuilder
            start = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) sb.append("x");
            end = System.nanoTime();
            System.out.println("StringBuilder: " + (end - start) / 1_000_000.0 + " ms");

            // StringBuffer
            start = System.nanoTime();
            StringBuffer sbf = new StringBuffer();
            for (int i = 0; i < n; i++) sbf.append("x");
            end = System.nanoTime();
            System.out.println("StringBuffer: " + (end - start) / 1_000_000.0 + " ms");

            System.out.println("-------------------------------------");
        }
    }
}

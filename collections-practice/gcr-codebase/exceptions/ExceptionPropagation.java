public class ExceptionPropagation {

    static void method1() {
        int x = 10 / 0;   // ArithmeticException
    }

    static void method2() {
        method1();       // exception propagates from here
    }

    public static void main(String[] args) {

        try {
            method2();   // exception reaches main()

        } catch (ArithmeticException e) {
            System.out.println("Handled exception in main");
        }
    }
}

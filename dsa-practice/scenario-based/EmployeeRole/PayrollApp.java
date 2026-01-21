public class PayrollApp {
    public static void main(String[] args) {

        Employee manager = new Manager("Alice", 80000);
        System.out.printf("%.2f%n", manager.getBonus());

        Employee dev1 = new Developer("Bob", 60000);
        System.out.printf("%.2f%n", dev1.getBonus());

        Employee dev2 = new Developer("Charlie", 40000);
        System.out.printf("%.2f%n", dev2.getBonus());
    }
}

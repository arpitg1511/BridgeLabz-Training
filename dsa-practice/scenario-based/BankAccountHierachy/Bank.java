public class Bank {
    public static void main(String[] args) {

        BankAccount savings = new SavingsAccount("12345", 1000.0);
        System.out.printf("%.2f%n", savings.calculateFee());

        BankAccount s1 = new SavingsAccount("S001", 500.0);
        System.out.printf("%.2f%n", s1.calculateFee());

        BankAccount c1 = new CheckingAccount("C001", 1500.0);
        System.out.printf("%.2f%n", c1.calculateFee());

        BankAccount c2 = new CheckingAccount("C002", 500.0);
        System.out.printf("%.2f%n", c2.calculateFee());
    }
}

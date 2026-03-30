package InvoiceObjectCreation;

import java.util.*;

public class InvoiceGenerator {

    public static void main(String[] args) {

        List<Integer> transactionIds = Arrays.asList(
                1001, 1002, 1003, 1004
        );

        List<Invoice> invoices =
                transactionIds.stream()
                              .map(Invoice::new)   // constructor reference
                              .toList();

        invoices.forEach(System.out::println);
    }
}


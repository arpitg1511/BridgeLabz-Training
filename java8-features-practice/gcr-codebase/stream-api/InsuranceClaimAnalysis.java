import java.util.*;
import java.util.stream.*;

class InsuranceClaim {
    String claimType;
    double amount;

    InsuranceClaim(String claimType, double amount) {
        this.claimType = claimType;
        this.amount = amount;
    }
}

public class InsuranceClaimAnalysis {

    public static void main(String[] args) {

        List<InsuranceClaim> claims = Arrays.asList(
                new InsuranceClaim("Health", 50000),
                new InsuranceClaim("Vehicle", 30000),
                new InsuranceClaim("Health", 70000),
                new InsuranceClaim("Travel", 20000),
                new InsuranceClaim("Vehicle", 40000)
        );

        Map<String, Double> averageClaimAmount =
                claims.stream()
                      .collect(Collectors.groupingBy(
                              c -> c.claimType,
                              Collectors.averagingDouble(c -> c.amount)
                      ));

        averageClaimAmount.forEach((type, avg) ->
                System.out.println(type + " -> Average Amount: " + avg)
        );
    }
}

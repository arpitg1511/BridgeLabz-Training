import java.util.List;

public class TransformNames {
    public static void main(String[] args) {

        List<String> customers = List.of(
                "arpit",
                "rahul",
                "ananya",
                "vikram"
        );

        List<String> ll = customers.stream()
                 .map(m -> m.toUpperCase())
                 .sorted()
                 .toList();
        
        System.out.println(ll);
    }
}

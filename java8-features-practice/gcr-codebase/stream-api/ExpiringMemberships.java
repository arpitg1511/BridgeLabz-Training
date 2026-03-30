import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

class Member {
    String name;
    LocalDate expiryDate;

    Member(String name, LocalDate expiryDate) {
        this.name = name;
        this.expiryDate = expiryDate;
    }
    
    public String toString() {
    	return name + " expires on " + expiryDate;
    }
}

public class ExpiringMemberships {

    public static void main(String[] args) {

        List<Member> members = Arrays.asList(
                new Member("Arpit", LocalDate.now().plusDays(10)),
                new Member("Rahul", LocalDate.now().plusDays(45)),
                new Member("Sneha", LocalDate.now().plusDays(25)),
                new Member("Neha", LocalDate.now().plusDays(5))
        );

        LocalDate today = LocalDate.now();
        LocalDate next30Days = today.plusDays(30);

        List<Member> ll = members.stream()
               .filter(m -> 
                   !m.expiryDate.isBefore(today) &&
                    m.expiryDate.isBefore(next30Days)
               )
               .toList();
        
        System.out.println(ll);
    }
}

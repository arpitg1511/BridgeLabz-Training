import java.util.Arrays;
import java.util.List;

public class EmailNotifications {
	static void sendEmailNotifications(String email) {
		System.out.println("Email sent to " + email);
	}
	
	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("a@gmail.com", "b@gmail.com", "c@gmail.com", 
							"d@gmail.com");
		
		list.stream()
		.forEach(e -> sendEmailNotifications(e));
	}
}

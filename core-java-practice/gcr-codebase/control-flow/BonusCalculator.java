import java.util.*;
public class BonusCalculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int salary = sc.nextInt();
		int yearOfSalary = sc.nextInt();
		
		double bonus = 0;
		if(yearOfSalary > 5) {
			bonus = 0.05 * salary;
		}
		
		System.out.println(bonus);
	}
}

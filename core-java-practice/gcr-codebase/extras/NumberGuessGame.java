import java.util.*;
;
public class NumberGuessGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int min = 1;
		int max = 100;
		Random rand = new Random();

        while(min <= max) {
        	int randomNumber = rand.nextInt((max - min + 1)) + min;
        	System.out.println("Guess of computer is : " + randomNumber);
        	
        	System.out.println("Answer according to you guess if higher, lower or correct");
        	String str = sc.next();
        	
        	if(str.equalsIgnoreCase("correct")) {
        		System.out.println("The magic number is " + randomNumber);
        		break;
        	}
        	
        	if(str.equalsIgnoreCase("higher")) {
        		min = randomNumber + 1;
        	}
        	
        	else {
        		max = randomNumber - 1;
        	}
        	
        }
        
        sc.close();

	}
}

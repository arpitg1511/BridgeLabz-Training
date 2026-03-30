import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter number of vessels: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		if(n >= 1) {
			
			System.out.println("Enter vessel details");
		
		}
		
		VesselUtil util = new VesselUtil();
		util.setVesselList(new ArrayList<>());
		
		for (int i = 0; i < n; i++) {
		    String line = sc.nextLine();      // read full line
		    String[] data = line.split(":");

		    Vessel v = new Vessel(
		        data[0],
		        data[1],
		        Double.parseDouble(data[2]),
		        data[3]
		    );

		    util.addVesselPerformance(v);
		}

		
		System.out.println("Enter the Vessel Id to check speed");
		String id = sc.next();
		
		Vessel vID = util.getVesselById(id);
		
		if(vID != null)
		System.out.println(vID);
		
		else
			System.out.printf("Vessel Id %s not found.", id);
		
		System.out.println("High performance vessels are");
		List<Vessel> ll = util.getHighPerformanceVessels();
		
		for(Vessel v : ll) System.out.println(v);
		
		
	}
}

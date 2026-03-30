import java.util.*;
class LC_UC1 {
	// UC-1 Find the distance using Cartesian method
	public double calculateLength(double x1, double y1, double x2, double y2) {
		double diffX = x2 - x1;
		double diffY = y2 - y1;
		double distance = Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
		return distance;
	}
}

class LC_UC2 {
	
	// UC-2 Find the equality of the length of the two lines
	public boolean areEqual(Double length1, Double length2) {
		return length1.equals(length2);
	}
}

class LC_UC3 {
	// UC-3 Compare the lengths of the line to find which is equal, greater than or less than the other one	
	public String compareLength(Double Length1, Double Length2) {
		int comparision = Length1.compareTo(Length2);
		if(comparision > 0) {
			return "Length 1 is greater than Length 2";
		}
		if(comparision == 0) {
			return "Length 1 is equal to Length 2";
		}
		return "Length 1 is less than Length 2";
	}
}

public class LineProblem {
	// UC-1 Find the distance using Cartesian method
	public Double calculateLength(double x1, double y1, double x2, double y2) {
		double diffX = x2 - x1;
		double diffY = y2 - y1;
		double distance = Math.sqrt(Math.pow(diffX, 2) + Math.pow(diffY, 2));
		return distance;
	}
	
	// UC-2 Find the equality of the length of the two lines
	public boolean areEqual(Double length1, Double length2) {
		return length1.equals(length2);
	}
	
	// UC-3 Compare the lengths of the line to find which is equal, greater than or less than the other one	
	public String compareLength(Double Length1, Double Length2) {
		int comparision = Length1.compareTo(Length2);
		if(comparision > 0) {
			return "Length 1 is greater than Length 2";
		}
		if(comparision == 0) {
			return "Length 1 is equal to Length 2";
		}
		return "Length 1 is less than Length 2";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Line Comparision Computation Program");
		LineProblem obj = new LineProblem();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first set of co-ordinates");
		double x1 = sc.nextDouble();
		double y1 = sc.nextDouble();
		
		System.out.println("Enter second set of co-ordinates");
		double x2 = sc.nextDouble();
		double y2 = sc.nextDouble();
		
		System.out.println("Enter third set of co-ordinates");
		double x3 = sc.nextDouble();
		double y3 = sc.nextDouble();
		
		System.out.println("Enter fourth set of co-ordinates");
		double x4 = sc.nextDouble();
		double y4 = sc.nextDouble();
		
		Double length1 = obj.calculateLength(x1, y1, x2, y2);
		Double length2 = obj.calculateLength(x3, y3, x4, y4);
		
		System.out.println("Length 1 -> of (x1, y1) and (x2, y2) is : " + length1);
		System.out.println("Length 2 -> of (x3, y3) and (x4, y4) is : " + length2);
		
		if(obj.areEqual(length1, length2)) {
			System.out.println("Lengths are equal");
		}
		else {
			System.out.println(obj.compareLength(length1, length2));
		}
		
		sc.close();
	}

}
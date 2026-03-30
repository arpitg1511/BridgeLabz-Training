
public class DistributePen {
	public static void main(String[] args) {
		int pens = 14;
		int students = 3;
		int extraPen = pens % students;
		
		System.out.println("The Pen Per Student is " + 
		((pens - extraPen) / students) + " and the remaining pen not distributed is "+
		extraPen);
	}
}

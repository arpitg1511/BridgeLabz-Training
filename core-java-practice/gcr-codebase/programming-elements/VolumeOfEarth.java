
public class VolumeOfEarth {
	public static void main(String[] args) {
		double radius = 6378.0;
		double volumeKm = 4.3 * Math.PI * Math.pow(radius,  3);
		double volumeMiles = volumeKm * 0.239;
		
		System.out.println(
	            "The volume of Earth is " + volumeKm + " cubic kilometers and " +
	            volumeMiles + " cubic miles."
	        );

	}
}

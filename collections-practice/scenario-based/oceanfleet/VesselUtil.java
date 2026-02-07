import java.util.ArrayList;
import java.util.List;

public class VesselUtil {
	private List<Vessel> vesselList;

	public List<Vessel> getVesselList() {
		return vesselList;
	}

	public void setVesselList(List<Vessel> vesselList) {
		this.vesselList = vesselList;
	}
	
	
	public void addVesselPerformance(Vessel vessel) {
		vesselList.add(vessel);
	}
	
	public Vessel getVesselById(String vesselId) {
		
		for(Vessel v : vesselList) {
			if(v.getVesselId().equals(vesselId)) return v;
		}
		return null;
	}
	
	public List<Vessel> getHighPerformanceVessels() {
		List<Vessel> highPerformanceVessels = new ArrayList<>();
		
		double maxSpeed = Double.MIN_VALUE;
		
		for(Vessel v : vesselList) {
			maxSpeed = Math.max(maxSpeed, v.getAverageSpeed());
		}
		
		for(Vessel v : vesselList) {
			if(v.getAverageSpeed() == maxSpeed) {
				highPerformanceVessels.add(v);
			}
		}
		
		return highPerformanceVessels;
	}
}

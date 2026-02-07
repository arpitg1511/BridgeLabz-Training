public class Vessel {
	private String vesselId;
	private String vesselName;
	private double averageSpeed;
	private String vesselType;
	
	public Vessel() {
		// TODO Auto-generated constructor stub
	}
	
	public Vessel(String id, String name, double speed, String type) {
		vesselId = id;
		vesselName = name;
		averageSpeed = speed;
		vesselType = type;
	}
	
	

	public void setVesselId(String vesselId) {
		this.vesselId = vesselId;
	}

	public String getVesselName() {
		return vesselName;
	}

	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}

	public double getAverageSpeed() {
		return averageSpeed;
	}

	public void setAverageSpeed(double averageSpeed) {
		this.averageSpeed = averageSpeed;
	}

	public String getVesselType() {
		return vesselType;
	}

	public void setVesselType(String vesselType) {
		this.vesselType = vesselType;
	}

	public String getVesselId() {
		return vesselId;
	}
	
	@Override
	public String toString() {
		return vesselId + "|" + vesselName + "|" + vesselType + "|" + averageSpeed + " knots";
	}
}
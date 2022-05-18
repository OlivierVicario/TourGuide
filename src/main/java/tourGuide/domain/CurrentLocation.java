package tourGuide.domain;

public class CurrentLocation {
	double longitude;
	double latitude;

	public CurrentLocation(double longitude, double latitude) {
		super();

		this.longitude = longitude;
		this.latitude = latitude;
	}

	/*public double[] toSerialize() {
		return new double[] { longitude, latitude };
	}*/
}

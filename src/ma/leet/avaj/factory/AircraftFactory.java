package ma.leet.avaj.factory;

public class AircraftFactory {
	private static AircraftFactory instance = null;

	private AircraftFactory() {}

	public static AircraftFactory getInstance() {
		if (instance == null)
			instance = new AircraftFactory();
		return instance;
	}
}

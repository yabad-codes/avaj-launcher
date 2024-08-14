package ma.leet.avaj.factory;

import ma.leet.avaj.aircraft.Baloon;
import ma.leet.avaj.aircraft.Flyable;
import ma.leet.avaj.aircraft.Helicopter;
import ma.leet.avaj.aircraft.JetPlane;
import ma.leet.avaj.weather.Coordinates;

public class AircraftFactory {
	private static AircraftFactory instance = null;
	private static long nextId = 1;

	private AircraftFactory() {}

	public static AircraftFactory getInstance() {
		if (instance == null)
			instance = new AircraftFactory();
		return instance;
	}

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
		if (p_type == null || p_name == null || p_coordinates == null)
			throw new IllegalArgumentException("Type, name, and coordinates must not be null");

		switch (p_type.toLowerCase()) {
			case "helicopter":
				return new Helicopter(nextId++, p_name, p_coordinates);
			case "jetplane":
				return new JetPlane(nextId++, p_name, p_coordinates);
			case "baloon":
				return new Baloon(nextId++, p_name, p_coordinates);
			default:
				throw new IllegalArgumentException("Invalid aircraft type: " + p_type);
		}
	}
}

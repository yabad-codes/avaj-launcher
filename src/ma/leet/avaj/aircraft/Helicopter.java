package ma.leet.avaj.aircraft;

import ma.leet.avaj.weather.Coordinates;
import ma.leet.avaj.weather.WeatherProvider;

/**
 * The Helicopter class represents a helicopter aircraft.
 * It extends the Aircraft class and provides methods for updating conditions.
 */
public class Helicopter extends Aircraft {

	/**
	 * Constructs a Helicopter object with the specified id, name, and coordinates.
	 *
	 * @param p_id         the id of the helicopter
	 * @param p_name       the name of the helicopter
	 * @param p_coordinates the coordinates of the helicopter
	 */
	public Helicopter(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	/**
	 * Updates the conditions for the helicopter aircraft.
	 */
	@Override
	public void updateConditions() {
		String weather = WeatherProvider.getInstance().getCurrentWeather(coordinates);

		switch (weather) {
			case "SUN":
				this.coordinates = new Coordinates(
					coordinates.getLongitude() + 10, 
					coordinates.getLatitude(), 
					Math.min(coordinates.getHeight() + 2, 100)
				);
				System.out.println(this + ": This is hot.");
				break;
			case "RAIN":
				this.coordinates = new Coordinates(
					coordinates.getLongitude() + 5, 
					coordinates.getLatitude(), 
					coordinates.getHeight()
				);
				System.out.println(this + ": OMG! Winter is coming!");
				break;
			case "FOG":
				this.coordinates = new Coordinates(
					coordinates.getLongitude() + 1, 
					coordinates.getLatitude(), 
					coordinates.getHeight()
				);
				System.out.println(this + ": I can't see anything in this fog!");
				break;
			case "SNOW":
				this.coordinates = new Coordinates(
					coordinates.getLongitude(), 
					coordinates.getLatitude(), 
					Math.max(coordinates.getHeight() - 12, 0)
				);
				System.out.println(this + ": My rotor is going to freeze!");
				break;
			default:
				break;
		}

		// If the height of the helicopter is 0, then it is landing.
		if (this.coordinates.getHeight() == 0) {
			System.out.println(this + " landing.");
			this.weatherTower.unregister(this);
		}
	}
}

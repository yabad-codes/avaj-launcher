package ma.leet.avaj.aircraft;

import ma.leet.avaj.weather.Coordinates;
import ma.leet.avaj.weather.WeatherProvider;

/**
 * The JetPlane class represents a jet plane aircraft.
 * It extends the Aircraft class and provides methods for updating conditions.
 */
public class JetPlane extends Aircraft {
	
	/**
	 * Constructs a JetPlane object with the specified id, name, and coordinates.
	 *
	 * @param p_id         the id of the jet plane
	 * @param p_name       the name of the jet plane
	 * @param p_coordinates the coordinates of the jet plane
	 */
	public JetPlane(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	/**
	 * Updates the conditions for the jet plane aircraft.
	 */
	@Override
	public void updateConditions() {
		String weather = WeatherProvider.getInstance().getCurrentWeather(coordinates);

		switch (weather) {
			case "SUN":
				this.coordinates = new Coordinates(
					coordinates.getLongitude(), 
					coordinates.getLatitude() + 10, 
					Math.min(coordinates.getHeight() + 2, 100)
				);
				System.out.println(this + ": This is hot.");
				break;
			case "RAIN":
				this.coordinates = new Coordinates(
					coordinates.getLongitude(), 
					coordinates.getLatitude() + 5, 
					coordinates.getHeight()
				);
				System.out.println(this + ": It's raining. Better watch out for lightings.");
				break;
			case "FOG":
				this.coordinates = new Coordinates(
					coordinates.getLongitude(), 
					coordinates.getLatitude() + 1, 
					coordinates.getHeight()
				);
				System.out.println(this + ": OMG! Winter is coming!");
				break;
			case "SNOW":
				this.coordinates = new Coordinates(
					coordinates.getLongitude(), 
					coordinates.getLatitude(), 
					Math.max(coordinates.getHeight() - 7, 0)
				);
				System.out.println(this + ": My rotor is going to freeze!");
				break;
			default:
				break;
		}

		// If the height of the aircraft is 0, it has landed
		if (this.coordinates.getHeight() == 0) {
			System.out.println(this + " landing.");
			this.weatherTower.unregister(this);
		}
	}
}

package ma.leet.avaj.aircraft;

import ma.leet.avaj.weather.Coordinates;
import ma.leet.avaj.weather.WeatherProvider;

/**
 * The Baloon class represents a baloon aircraft.
 * It extends the Aircraft class and provides attributes and methods for a baloon aircraft.
 */
public class Baloon extends Aircraft {
	
	/**
	 * Constructs a Baloon object with the specified id, name, and coordinates.
	 *
	 * @param p_id         the id of the baloon
	 * @param p_name       the name of the baloon
	 * @param p_coordinates the coordinates of the baloon
	 */
	public Baloon(long p_id, String p_name, Coordinates p_coordinates) {
		super(p_id, p_name, p_coordinates);
	}

	/**
	 * Updates the conditions for the baloon aircraft.
	 */
	@Override
	public void updateConditions() {
		String weather = WeatherProvider.getInstance().getCurrentWeather(coordinates);

		switch (weather) {
			case "SUN":
				this.coordinates = new Coordinates(
					coordinates.getLongitude() + 2, 
					coordinates.getLatitude(), 
					Math.min(coordinates.getHeight() + 4, 100)
				);
				System.out.println(this.toString() + ": Let's enjoy the good weather and take some pics.");
				break;
			case "RAIN":
				this.coordinates = new Coordinates(
					coordinates.getLongitude(), 
					coordinates.getLatitude(), 
					Math.max(coordinates.getHeight() - 5, 0)
				);
				System.out.println(this.toString() + ": Damn you rain! You messed up my baloon.");
				break;
			case "FOG":
				this.coordinates = new Coordinates(
					coordinates.getLongitude(), 
					coordinates.getLatitude(), 
					Math.max(coordinates.getHeight() - 3, 0)
				);
				System.out.println(this.toString() + ": I can't see anything in this fog!");
				break;
			case "SNOW":
				this.coordinates = new Coordinates(
					coordinates.getLongitude(), 
					coordinates.getLatitude(), 
					Math.max(coordinates.getHeight() - 15, 0)
				);
				System.out.println(this.toString() + ": It's snowing. We're gonna crash.");
				break;
			default:
				break;
		}

		// If the height of the baloon is 0, it has landed
		if (this.coordinates.getHeight() == 0) {
			System.out.println(this + " landing.");
			this.weatherTower.unregister(this);
		}
	}
}

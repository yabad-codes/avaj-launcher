package ma.leet.avaj.weather;

/**
 * The WeatherProvider class represents a provider of weather information.
 * It provides the current weather based on the given coordinates.
 */
public class WeatherProvider {
	private static WeatherProvider instance = null;
	private final String[] weather;

	/**
	 * Constructs a WeatherProvider object.
	 * Initializes the weather array with possible weather conditions.
	 */
	private WeatherProvider() {
		this.weather = new String[]{"RAIN", "FOG", "SUN", "SNOW"};
	}

	/**
	 * Returns the instance of the WeatherProvider class.
	 * If the instance is null, creates a new instance and returns it.
	 *
	 * @return the instance of the WeatherProvider class
	 */
	public static WeatherProvider getInstance() {
		if (instance == null)
			instance = new WeatherProvider();
		return instance;
	}

	/**
	 * Returns the current weather based on the given coordinates.
	 *
	 * @param p_coordinates the coordinates to get the weather for
	 * @return the current weather
	 */
	public String getCurrentWeather(Coordinates p_coordinates) {
		int weatherIndex = (p_coordinates.getLongitude() + p_coordinates.getLatitude() + p_coordinates.getHeight()) % 4;
		return weather[weatherIndex];
	}
}

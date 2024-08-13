package ma.leet.avaj.weather;

public class WeatherProvider {
	private static WeatherProvider instance = null;

	private WeatherProvider() {}

	public static WeatherProvider getInstance() {
		if (instance == null)
			instance = new WeatherProvider();
		return instance;
	}
}

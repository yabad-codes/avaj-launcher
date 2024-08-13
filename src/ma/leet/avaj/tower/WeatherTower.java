package ma.leet.avaj.tower;

import ma.leet.avaj.weather.Coordinates;
import ma.leet.avaj.weather.WeatherProvider;

/**
 * The WeatherTower class represents a tower that provides weather information.
 * It extends the Tower class.
 */
public class WeatherTower extends Tower {
	/**
	 * Gets the current weather at the specified coordinates.
	 *
	 * @param coordinates the coordinates to get the weather for
	 * @return the current weather at the specified coordinates
	 */
	public String getWeather(Coordinates coordinates) {
		return WeatherProvider.getInstance().getCurrentWeather(coordinates);
	}

	/**
	 * Changes the weather condition.
	 */
	public void changeWeather() {
		conditionChanged();
	}
}

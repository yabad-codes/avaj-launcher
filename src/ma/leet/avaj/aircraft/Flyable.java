package ma.leet.avaj.aircraft;

import ma.leet.avaj.tower.WeatherTower;

/**
 * The Flyable class represents an abstract class for all flyable objects in the simulation.
 * It provides methods for updating conditions and registering with a weather tower.
 */
public abstract class Flyable {
	protected WeatherTower weatherTower;

	/**
	 * Updates the conditions for the flyable object.
	 */
	public abstract void updateConditions();

	/**
	 * Registers the flyable object with the specified weather tower.
	 * 
	 * @param p_tower the weather tower to register with
	 */
	public void registerTower(WeatherTower p_tower) {
		if (p_tower == null)
			throw new IllegalArgumentException("Weather tower cannot be null");
		
		this.weatherTower = p_tower;
		p_tower.register(this);
	}
}

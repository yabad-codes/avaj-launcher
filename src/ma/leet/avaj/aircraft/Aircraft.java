package ma.leet.avaj.aircraft;

import ma.leet.avaj.weather.Coordinates;

/**
 * The Aircraft class represents an abstract aircraft.
 * It extends the Flyable class and provides common attributes and methods for all aircraft types.
 */
public abstract class Aircraft extends Flyable {
	protected final long id;
	protected String name;
	protected Coordinates coordinates;

	/**
	 * Constructs an Aircraft object with the specified id, name, and coordinates.
	 *
	 * @param p_id         the id of the aircraft
	 * @param p_name       the name of the aircraft
	 * @param p_coordinates the coordinates of the aircraft
	 */
	protected Aircraft(long p_id, String p_name, Coordinates p_coordinates) {
		if (p_name == null || p_name.isEmpty())
			throw new IllegalArgumentException("Aircraft name cannot be empty");
		
		if (p_coordinates == null)
			throw new IllegalArgumentException("Coordinates cannot be null");
		
		this.id = p_id;
		this.name = p_name;
		this.coordinates = p_coordinates;
	}

	/**
	 * Returns a string representation of the Aircraft object.
	 * The string representation consists of the simple class name of the Aircraft,
	 * followed by the name and ID of the Aircraft enclosed in parentheses.
	 *
	 * @return a string representation of the Aircraft object
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")";
	}
}

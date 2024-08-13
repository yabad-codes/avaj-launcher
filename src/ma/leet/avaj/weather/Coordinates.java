package ma.leet.avaj.weather;

/**
 * The Coordinates class represents the geographical coordinates of a location.
 * It contains longitude, latitude, and height information.
 */
public class Coordinates {
	private int longitude;
	private int latitude;
	private int height;

	private static final int MAX_HEIGHT = 100;

	/**
	 * Constructs a new Coordinates object with the specified longitude, latitude, and height.
	 * 
	 * @param p_longitude the longitude value of the location
	 * @param p_latitude the latitude value of the location
	 * @param p_height the height value of the location
	 * @throws IllegalArgumentException if any of the coordinates are negative
	 */
	public Coordinates(int p_longitude, int p_latitude, int p_height) {
		if (p_longitude < 0 || p_latitude < 0 || p_height < 0)
			throw new IllegalArgumentException("Coordinates must be positive");

		if (p_height > MAX_HEIGHT)
			p_height = MAX_HEIGHT;

		this.longitude = p_longitude;
		this.latitude = p_latitude;
		this.height = p_height;
	}

	/**
	 * Returns the longitude value of the location.
	 * 
	 * @return the longitude value
	 */
	public int getLongitude() {
		return longitude;
	}

	/**
	 * Returns the latitude value of the location.
	 * 
	 * @return the latitude value
	 */
	public int getLatitude() {
		return latitude;
	}

	/**
	 * Returns the height value of the location.
	 * 
	 * @return the height value
	 */
	public int getHeight() {
		return height;
	}
}

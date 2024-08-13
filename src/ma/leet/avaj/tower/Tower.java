package ma.leet.avaj.tower;

import java.util.List;
import java.util.ArrayList;
import ma.leet.avaj.aircraft.Flyable;

/**
 * The Tower class represents a weather tower that observes and manages flyable objects.
 */
public class Tower {
	private List<Flyable> observers = new ArrayList<Flyable>();

	/**
	 * Registers a flyable object to the weather tower.
	 *
	 * @param p_flyable the flyable object to register
	 * @throws IllegalArgumentException if the flyable object is null
	 */
	public void register(Flyable p_flyable) {
		if (p_flyable == null)
			throw new IllegalArgumentException("Aircraft can't be null");

		if (!observers.contains(p_flyable)) {
			observers.add(p_flyable);
			System.out.println("Tower says: " + p_flyable.toString() + " registered to weather tower.");
		}
	}

	/**
	 * Unregisters a flyable object from the weather tower.
	 *
	 * @param p_flyable the flyable object to unregister
	 * @throws IllegalArgumentException if the flyable object is null
	 */
	public void unregister(Flyable p_flyable) {
		if (p_flyable == null)
			throw new IllegalArgumentException("Aircraft can't be null");

		if (observers.remove(p_flyable))
			System.out.println("Tower says: " + p_flyable.toString() + " unregistered from weather tower.");
	}

	/**
	 * Notifies all registered flyable objects that the weather condition has changed.
	 */
	protected void conditionChanged() {
		List<Flyable> observsersCopy = new ArrayList<>(observers);

		for (Flyable observer : observsersCopy) {
			observer.updateConditions();
		}
	}
}

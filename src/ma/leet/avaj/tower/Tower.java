package ma.leet.avaj.tower;

import java.util.List;
import java.util.ArrayList;
import ma.leet.avaj.aircraft.Flyable;

public class Tower {
	private List<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable p_flyable) {
		if (p_flyable == null)
			throw new IllegalArgumentException("Aircraft can't be null");
		
		if (!observers.contains(p_flyable)) {
			observers.add(p_flyable);
			// TODO: LOG A MESSAGE FROM THE TOWERRRRRR AFTER FLYABLE IMPLEMENTATION
		}
	}

	public void unregister(Flyable p_flyable) {
		if (p_flyable == null)
			throw new IllegalArgumentException("Aircraft can't be null");
		
		if (observers.remove(p_flyable)) {
			// TODO: LOG A MESSAGE FROM THE TOWERRRRRR AFTER FLYABLE IMPLEMENTATION
		}
	}

	protected void conditionChanged() {
		List<Flyable> observsersCopy = new ArrayList<>(observers);

		for (Flyable observer : observsersCopy) {
			observer.updateConditions(); // NOT IMPLEMENTED YET
		}
	}
}

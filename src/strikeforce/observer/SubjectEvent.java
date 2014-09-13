package strikeforce.observer;

public abstract class SubjectEvent {
	
	private EventType type;

	/**
	 * @return the type
	 */
	public EventType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(EventType type) {
		this.type = type;
	}
	
	
}

package strikeforce.observer.events;

public abstract class SubjectEvent {
  private EventType type;

  public EventType getType() {
    return type;
  }

  public void setType(EventType type) {
    this.type = type;
  }
}

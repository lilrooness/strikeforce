package strikeforce.observer.events;


import strikeforce.entity.Entity;

/**
 * Created by Joseph Frangoudes on 10/09/2014.
 *
 * @author Joseph Frangoudes
 */
public class PlayerMovedEvent extends SubjectEvent {


  public PlayerMovedEvent(float xForce, float yForce, Entity player) {
    this.type = EventType.PLAYER_MOVED;
  }
}

package strikeforce.observer.events;



/**
 * Created by Joseph Frangoudes on 10/09/2014.
 *
 * @author Joseph Frangoudes
 */
public class PlayerMovedEvent extends SubjectEvent {

	private float xForce, yForce;
	private int playerId;
	
	public PlayerMovedEvent(float xForce, float yForce, int playerId) {
		super();
		this.xForce = xForce;
		this.yForce = yForce;
		this.playerId = playerId;
		
		this.setType(EventType.PLAYER_MOVED);
	}

	/**
	 * @return the xForce
	 */
	public float getxForce() {
		return xForce;
	}

	/**
	 * @param xForce the xForce to set
	 */
	public void setxForce(float xForce) {
		this.xForce = xForce;
	}

	/**
	 * @return the yForce
	 */
	public float getyForce() {
		return yForce;
	}

	/**
	 * @param yForce the yForce to set
	 */
	public void setyForce(float yForce) {
		this.yForce = yForce;
	}

	/**
	 * @return the playerId
	 */
	public int getPlayerId() {
		return playerId;
	}

	/**
	 * @param playerId the playerId to set
	 */
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	
	
}

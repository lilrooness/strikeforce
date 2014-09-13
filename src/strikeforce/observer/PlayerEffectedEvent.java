package strikeforce.observer;

import strikeforce.entity.Entity;

public class PlayerEffectedEvent extends SubjectEvent {
	
	private float xForce;
	private float yForce;
	
	private Entity player;
	
	/**
	 * @param xForce
	 * @param yForce
	 * @param playerId
	 */
	public PlayerEffectedEvent(float xForce, float yForce, Entity player) {
		super();
		this.xForce = xForce;
		this.yForce = yForce;
		this.player = player;
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
	 * @return the player
	 */
	public Entity getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Entity player) {
		this.player = player;
	}
	
}

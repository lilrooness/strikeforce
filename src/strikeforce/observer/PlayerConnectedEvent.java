package strikeforce.observer;

public class PlayerConnectedEvent extends SubjectEvent{

	private float xPos;
	private float yPos;
	
	private float initialXForce;
	private float initialYForce;
	
	private int playerId;
	
	/**
	 * @param xPos
	 * @param yPos
	 * @param initialXForce
	 * @param initialYForce
	 */
	public PlayerConnectedEvent(float xPos, float yPos, float initialXForce,
			float initialYForce, int playerId) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.initialXForce = initialXForce;
		this.initialYForce = initialYForce;
		this.playerId = playerId;
	}
	/**
	 * @return the xPos
	 */
	public float getxPos() {
		return xPos;
	}
	/**
	 * @param xPos the xPos to set
	 */
	public void setxPos(float xPos) {
		this.xPos = xPos;
	}
	/**
	 * @return the yPos
	 */
	public float getyPos() {
		return yPos;
	}
	/**
	 * @param yPos the yPos to set
	 */
	public void setyPos(float yPos) {
		this.yPos = yPos;
	}
	/**
	 * @return the initialXForce
	 */
	public float getInitialXForce() {
		return initialXForce;
	}
	/**
	 * @param initialXForce the initialXForce to set
	 */
	public void setInitialXForce(float initialXForce) {
		this.initialXForce = initialXForce;
	}
	/**
	 * @return the initialYForce
	 */
	public float getInitialYForce() {
		return initialYForce;
	}
	/**
	 * @param initialYForce the initialYForce to set
	 */
	public void setInitialYForce(float initialYForce) {
		this.initialYForce = initialYForce;
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

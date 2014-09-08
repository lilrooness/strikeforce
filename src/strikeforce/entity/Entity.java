package strikeforce.entity;

public abstract class Entity {
	private float xPos, yPos;
	
	private float xVel, yVel;
	
	private float xAcc, yAcc;
	
	private float mass;

	/**
	 * @param xPos
	 * @param yPos
	 * @param mass
	 */
	public Entity(float xPos, float yPos, float mass) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.mass = mass;
	}
	
	public void applyForce(float x, float y) {
		xAcc += x;
		yAcc += y;
	}
	
	public void update() {
		xVel += xAcc / mass;
		yVel += yAcc / mass;
		yAcc = 0;
		xAcc = 0;
	}
}

package strikeforce.entity;

import strikeforce.observer.Subject;
import strikeforce.observer.events.PlayerMovedEvent;

public class Entity extends Subject{
	
	private float xPos, yPos;
	
	private float xVel, yVel;
	
	private float xAcc, yAcc;
	
	private float mass;
	
	private int id;

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
		if(xAcc != 0 || yAcc != 0) {
			this.notifyObservers(new PlayerMovedEvent(xAcc, yAcc, this.getId()));
		}
		xVel += xAcc / mass;
		yVel += yAcc / mass;
		yAcc = 0;
		xAcc = 0;
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
	 * @return the xVel
	 */
	public float getxVel() {
		return xVel;
	}

	/**
	 * @param xVel the xVel to set
	 */
	public void setxVel(float xVel) {
		this.xVel = xVel;
	}

	/**
	 * @return the yVel
	 */
	public float getyVel() {
		return yVel;
	}

	/**
	 * @param yVel the yVel to set
	 */
	public void setyVel(float yVel) {
		this.yVel = yVel;
	}

	/**
	 * @return the xAcc
	 */
	public float getxAcc() {
		return xAcc;
	}

	/**
	 * @param xAcc the xAcc to set
	 */
	public void setxAcc(float xAcc) {
		this.xAcc = xAcc;
	}

	/**
	 * @return the yAcc
	 */
	public float getyAcc() {
		return yAcc;
	}

	/**
	 * @param yAcc the yAcc to set
	 */
	public void setyAcc(float yAcc) {
		this.yAcc = yAcc;
	}

	/**
	 * @return the mass
	 */
	public float getMass() {
		return mass;
	}

	/**
	 * @param mass the mass to set
	 */
	public void setMass(float mass) {
		this.mass = mass;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
}

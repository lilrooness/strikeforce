package strikeforce.command;

import strikeforce.entity.Entity;

public class MoveCommand implements Command {
	
	private float xForce, yForce;
	private Entity player;
	
	/**
	 * @param xForce
	 * @param yForce
	 * @param player
	 */
	public MoveCommand(float xForce, float yForce, Entity player) {
		super();
		this.xForce = xForce;
		this.yForce = yForce;
		this.player = player;
	}

	@Override
	public void execute() {
		player.applyForce(xForce, yForce);
		System.out.println("player has moved");
	}
}

package strikeforce.client;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.LinkedList;
import java.util.Queue;

import strikeforce.client.network.StrikeForceClientMessenger;
import strikeforce.command.Command;
import strikeforce.entity.Entity;
import strikeforce.observer.Observer;
import strikeforce.observer.SubjectEvent;
import strikeforce.observer.events.PlayerMovedEvent;

public class Game implements Observer {
	
	private Queue<Command> commands;

	private StrikeForceClientMessenger strikeForceClientMessenger;
	private Entity player;

  public Game() {
	  commands = new LinkedList<Command>();
    try {
      strikeForceClientMessenger = new StrikeForceClientMessenger(InetAddress.getLocalHost(), 9001, 9000);
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
    
    player = new Entity(0, 0, 1);
    player.addObserver(this);
  }

	public void update() {
		while(!commands.isEmpty()) {
			commands.poll().execute();
		}
		
		player.update();
	}
	
	@Override
	public void notifyEvent(SubjectEvent event) {
		System.out.println("event is happening");
		switch (event.getType()) {
      case PLAYER_MOVED: {
    	  PlayerMovedEvent movedEvent = (PlayerMovedEvent) event;
        try {
			strikeForceClientMessenger.sendPlayerUpdate(movedEvent.getxForce(), movedEvent.getyForce(), movedEvent.getPlayerId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
    }
	}

	/**
	 * @return the commands
	 */
	public Queue<Command> getCommands() {
		return commands;
	}

	/**
	 * @param commands the commands to set
	 */
	public void setCommands(Queue<Command> commands) {
		this.commands = commands;
	}

	/**
	 * @return the strikeForceClientMessenger
	 */
	public StrikeForceClientMessenger getStrikeForceClientMessenger() {
		return strikeForceClientMessenger;
	}

	/**
	 * @param strikeForceClientMessenger the strikeForceClientMessenger to set
	 */
	public void setStrikeForceClientMessenger(
			StrikeForceClientMessenger strikeForceClientMessenger) {
		this.strikeForceClientMessenger = strikeForceClientMessenger;
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
  

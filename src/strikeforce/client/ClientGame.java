package strikeforce.client;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import strikeforce.Game;
import strikeforce.client.network.StrikeForceClientListener;
import strikeforce.client.network.StrikeForceClientMessenger;
import strikeforce.command.Command;
import strikeforce.entity.Player;
import strikeforce.observer.Observer;
import strikeforce.observer.PlayerConnectedEvent;
import strikeforce.observer.PlayerEffectedEvent;
import strikeforce.observer.SubjectEvent;

public class ClientGame extends Game implements Observer {
	
	private Queue<Command> commands;
	
	private Player player;
	
	private List<Player> otherPlayers;
	
	StrikeForceClientListener listener;
	StrikeForceClientMessenger messenger;
	
	public ClientGame() {
		try {
			listener = new StrikeForceClientListener(9000, InetAddress.getLocalHost());
			messenger = new StrikeForceClientMessenger(InetAddress.getLocalHost(), 9001, 9000);
			messenger.sendConnectionRequest();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		otherPlayers = new ArrayList<Player>();
		listener.addObserver(this);
		player = new Player(0, 0, 1, 3);
		player.addObserver(this);
		commands = new LinkedList<>();
	}
	
	public void update() {
		while(!commands.isEmpty()) {
			commands.poll().execute();
		}
		
		for(Player player : otherPlayers) {
			player.update();
		}
	}
	
	@Override
	public void notifyEvent(SubjectEvent event) {
		switch(event.getType()) {
		case PLAYER_UPDATE: {
			PlayerEffectedEvent effectedEvent = (PlayerEffectedEvent) event;
			try {
				messenger.sendPlayerUpdate(player);
			} catch (IOException e) {
				e.printStackTrace();
			}
//			(effectedEvent.getxForce(), effectedEvent.getyForce());
			
			break;
		}
		case PLAYER_CONNECTED: {
			PlayerConnectedEvent connectionEvent = (PlayerConnectedEvent) event;
			Player player = new Player(connectionEvent.getxPos(), connectionEvent.getyPos(), 1, connectionEvent.getPlayerId());
			otherPlayers.add(player);
			break;
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
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player the player to set
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * @return the otherPlayers
	 */
	public List<Player> getOtherPlayers() {
		return otherPlayers;
	}

	/**
	 * @param otherPlayers the otherPlayers to set
	 */
	public void setOtherPlayers(List<Player> otherPlayers) {
		this.otherPlayers = otherPlayers;
	}

	/**
	 * @return the listener
	 */
	public StrikeForceClientListener getListener() {
		return listener;
	}

	/**
	 * @param listener the listener to set
	 */
	public void setListener(StrikeForceClientListener listener) {
		this.listener = listener;
	}

	/**
	 * @return the messenger
	 */
	public StrikeForceClientMessenger getMessenger() {
		return messenger;
	}

	/**
	 * @param messenger the messenger to set
	 */
	public void setMessenger(StrikeForceClientMessenger messenger) {
		this.messenger = messenger;
	}
}
  
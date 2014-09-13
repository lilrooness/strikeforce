package strikeforce.server;

import java.net.InetAddress;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import strikeforce.Game;
import strikeforce.command.Command;
import strikeforce.command.MoveCommand;
import strikeforce.entity.Player;
import strikeforce.observer.Observer;
import strikeforce.observer.PlayerEffectedEvent;
import strikeforce.observer.SubjectEvent;

public class ServerGame extends Game implements Observer {
	
	private Map<InetAddress, Player> players;
	
	private Queue<Command> commands;
	
	public void update() {
		for(Player player : players.values()) {
			player.update();
		}
	}

	@Override
	public void notifyEvent(SubjectEvent event) {
		switch(event.getType()) {
		case PLAYER_CONNECTED: {
			break;
		}
		case PLAYER_UPDATE: {
//			PlayerEffectedEvent playerEffectedEvent = (PlayerEffectedEvent) event;
//			commands.add(
//					new MoveCommand(playerEffectedEvent.getxForce(), 
//							playerEffectedEvent.getyForce(), 
//							playerEffectedEvent.getPlayer(), 
//							(List<Player>) players.values())));
			break;
		}
		}
	}
}

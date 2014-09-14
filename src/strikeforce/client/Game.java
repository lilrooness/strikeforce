package strikeforce.client;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Queue;

import strikeforce.client.network.StrikeForceClientMessenger;
import strikeforce.command.Command;
import strikeforce.observer.Observer;
import strikeforce.observer.Subject;
import strikeforce.observer.events.PlayerMovedEvent;
import strikeforce.observer.events.SubjectEvent;

public class Game extends Subject implements Observer {
	
	private Queue<Command> commands;
	private StrikeForceClientMessenger strikeForceClientMessenger;

  public Game() {
    try {
      strikeForceClientMessenger = new StrikeForceClientMessenger(InetAddress.getLocalHost(), 9001, 9000);
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }

	public void update() {
		while(!commands.isEmpty()) {
			commands.poll().execute();
		}
	}
	
	@Override
	public void notifyEvent(SubjectEvent event) {
		switch (event.getType()) {
      case PLAYER_MOVED: {
        strikeForceClientMessenger.sendPlayerUpdate((PlayerMovedEvent)event);
      }
    }
	}
}

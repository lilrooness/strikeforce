package strikeforce.client;

import java.util.Queue;

import strikeforce.command.Command;
import strikeforce.observer.Observer;
import strikeforce.observer.SubjectEvent;

public class Game implements Observer {
	
	private Queue<Command> commands;
	
	public void update() {
		while(!commands.isEmpty()) {
			commands.poll().execute();
		}
	}
	
	@Override
	public void notifyEvent(SubjectEvent event) {
		
	}

}
  
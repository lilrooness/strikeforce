package strikeforce.command;

import strikeforce.client.Game;

public class KeyboardCommand implements Command {

	private char keyCode;
	private Game clientGame;
	
	public KeyboardCommand(char keyCode, Game game) {
		super();
		this.keyCode = keyCode;
		this.clientGame = game;
	}

	@Override
	public void execute() {
		switch(keyCode) {
		case 'w': {
			clientGame.getCommands().add(new MoveCommand(0.0f, -1.0f, clientGame.getPlayer()));
			break;
		}
		case 'a': {
			break;
		}
		case 's': {
			break;
		}
		case 'd': {
			break;
		}
		}
	}

}

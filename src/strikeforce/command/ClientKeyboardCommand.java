package strikeforce.command;

import strikeforce.client.ClientGame;

public class ClientKeyboardCommand implements Command {

	private char keyCode;
	private ClientGame clientGame;
	
	/**
	 * @param keyCode
	 * @param clientGame
	 */
	public ClientKeyboardCommand(char keyCode, ClientGame clientGame) {
		super();
		this.keyCode = keyCode;
		this.clientGame = clientGame;
	}
	
	@Override
	public void execute() {
		switch(keyCode) {
		case 'w': {
			clientGame.getCommands().add(new MoveCommand(0, -1, clientGame.getPlayer()));
			break;
		}
		case 'a': {
			clientGame.getCommands().add(new MoveCommand(-1, 0, clientGame.getPlayer()));
			break;
		}
		case 's': {
			clientGame.getCommands().add(new MoveCommand(0, 1, clientGame.getPlayer()));
			break;
		}
		case 'd': {
			clientGame.getCommands().add(new MoveCommand(1, 0, clientGame.getPlayer()));
			break;
		}
		}
	}
}

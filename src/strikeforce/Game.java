package strikeforce;

import java.util.List;

import strikeforce.entity.Player;

public class Game {

	public Player getPlayerById(int id, List<Player> players) {
		for(Player player : players) {
			if(player.getId() == id) {
				return player;
			}
		}
		return null;
	}
}

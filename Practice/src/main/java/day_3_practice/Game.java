package day_3_practice;

import java.util.Arrays;

public class Game {
	private String name;

	private Player[] players;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Player[] getPlayers() {
		return players;
	}

	public void setPlayers(Player[] players) {
		this.players = players;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Game [name = ");
		builder.append(name);
		builder.append(", players=");
		builder.append(Arrays.toString(players));
		builder.append("]");
		return builder.toString();
	}

	
	
}

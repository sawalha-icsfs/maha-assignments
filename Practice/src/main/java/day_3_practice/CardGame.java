package day_3_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CardGame {

	static Game game = new Game();
	private static Scanner inputScanner = new Scanner(System.in);
	static List<Card> crdLst = new ArrayList<Card>();
	static Player playersObj = new Player();
	static Player[] playersArray = new Player[4];

	private static List<Card> shuffleCards() {
		for (CardType types : CardType.values()) {
			for (int i = 0; i < 13; i++) {
				Card card = new Card();
				card.setNumber(i + 1);
				card.setType(types);
				crdLst.add(card);
			}
		}
		Collections.shuffle(crdLst);
		return crdLst;
	}

	private static void distribute() {
		for (int i = 0; i < 4; i++) {
			List<Card> cardsOfEachPlayer = new ArrayList<Card>();
			// Player players = new Player();
			for (int j = 0; j < 13; j++) {
				cardsOfEachPlayer.add(crdLst.get(0));
				crdLst.remove(0);
				playersObj.setName(playersArray[i].getName());
				playersArray[i].setCards(cardsOfEachPlayer);

			}
			playersObj.setCards(cardsOfEachPlayer);
		}
	}

	public static void main(String[] args) {

		System.out.println("Please enter game name :");
		game.setName(inputScanner.nextLine());

		for (int i = 0; i < playersArray.length; i++) {
			System.out.println("Please Enter Player " + i + " Name: ");
			playersArray[i] = new Player(inputScanner.nextLine());
			playersObj.setName(playersArray[i].getName());
		}

		List<Card> shufleCards = shuffleCards();
		distribute();
		game.setPlayers(playersArray);
		printInfo();
	}

	static void printInfo() {
		System.out.println("Game name : " + game.getName());
		for (Player players : game.getPlayers()) {
			System.out.println("Player " + players.getName() + " has  " + players.getCards());
		}
	}

}

package day_3_practice;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private String name;

	private int score ;

	private	List<Card> cards=  new ArrayList<Card>(); ;
	
	
	public Player() {
        this.name = name;
        this.score= score;
        this.cards = cards;
    }
	
	public Player(String name) {
        this.name = name;
    }
	
	
	public String printPlayerCards() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(name + " has the following cards:\n");

        for (Card card : cards) {
            stringBuilder.append(card + "\n");
        }

        return stringBuilder.toString();
    }
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player [name=");
		builder.append(name);
		builder.append(", score=");
		builder.append(score);
		builder.append(", cards=");
		builder.append(cards);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}

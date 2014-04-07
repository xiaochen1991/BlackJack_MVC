package model;

import java.util.ArrayList;

/**
 * An implement of a blackjack player
 * 
 * @author xioachen
 * 
 */
public abstract class Player {

	/**
	 * player's name.
	 */
	private String name;

	/**
	 * the cards in the player's hand.
	 */

	private ArrayList<Card> hand = new ArrayList<Card>();

	public Player(String aName) {
		this.name = aName;

	}

	/**
	 * add a card to the player's hand and check if it burst
	 * 
	 */
	public boolean Hit(Card aCard) {

		// add new card in next slot
		hand.add(aCard);

		return (this.getHandSum() <= 21);
	}

	/**
	 * check if the player will hit will be override in subclass based on
	 * different types of players
	 */
	public abstract boolean isHitting();

	/**
	 * get the sum of the cards in the player's hand
	 */
	public int getHandSum() {

		int handSum = 0;
		int cardNum;
		int numAces = 0;

		// sum of cards in hand
		for (int i = 0; i < hand.size(); i++) {

			cardNum = hand.get(i).getNumber();

			if (cardNum == 1) {
				// Ace
				numAces++;
				handSum += 11;
			} else if (cardNum > 10) {
				// face card
				handSum += 10;
			} else {
				handSum += cardNum;
			}
		}

		// if we have aces and our sum is > 21, set some/all of them to value 1
		while (handSum > 21 && numAces > 0) {
			handSum -= 10;
			numAces--;
		}
		return handSum;
	}

	/**
	 * print the cards in the players hand.
	 * 
	 * @param showFirstCard
	 */
	public void printHand(boolean showFirstCard) {

		System.out.printf("%s's cards\n", this.name);
		for (int i = 0; i < hand.size(); i++) {
			if (i == 0 && !showFirstCard) {
				System.out.println(" [hidden]");
			} else {
				System.out.printf(" %s\n ", hand.get(i).toString());
			}
		}
	}

}

package model;

/**
 * An implementation of a card type.
 * 
 * @author xiaochen
 * 
 */

public class Card {
	/**
	 * Should be one of four possible suits
	 */
	private Suit mySuit;

	/**
	 * number of this card, where Ace: 1, Jack-King:11-13;
	 */
	private static enum Value {
		Ace, Two, Three, Four, Five, Six, Sven, Eight, Nine, Ten, Jack, Queen, King,
	}

	private int myNumber;

	public Card(Suit aSuit, int aNumber) {

		this.mySuit = aSuit;

		if (aNumber >= 1 && aNumber <= 13) {
			this.myNumber = aNumber;
		} else {
			System.err.println(aNumber + " is not a valid Card number");
			System.exit(1);
		}
	}

	/**
	 * return the number of the card.
	 */

	public int getNumber() {
		return this.myNumber;
	}

	public String getValue() {

		return Value.values()[myNumber - 1].toString();

	}

	public String toString() {
		return getValue() + " of " + mySuit;
	}

}

package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.*;

/**
 * Servlet implementation class GameRunner
 */
@WebServlet("/GameRunner")
public class GameRunner extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GameRunner() {

		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Deck theDeck = new Deck(Integer.parseInt(request
				.getParameter("DeckNumber")));

		// init the player objects
		ConcretPlayer me = new ConcretPlayer(
				request.getParameter("Player_Name"));
		Dealer dealer = new Dealer("Dealer");

		// two cards are dealt at the beginning
		me.Hit(theDeck.dealNextCard());
		dealer.Hit(theDeck.dealNextCard());
		me.Hit(theDeck.dealNextCard());
		dealer.Hit(theDeck.dealNextCard());

		// print intial hands
		System.out.println("Cards are dealt\n");
		me.printHand(true);
		dealer.printHand(false);
		System.out.println("\n");

		// flags for when each player is finished hitting
		boolean meDone = false;
		boolean dealerDone = false;

		while (!meDone || !dealerDone) {

			// player's turn
			while (!meDone) {

				// if the player hits
				if (me.isHitting()) {

					// add next card in the deck and store whether player is
					// bursted
					meDone = !me.Hit(theDeck.dealNextCard());
					me.printHand(true);
				} else {
					meDone = true;
				}
			}

			// dealer's turn
			while (!dealerDone) {
				if (dealer.isHitting()) {
					dealerDone = !dealer.Hit(theDeck.dealNextCard());
					dealer.printHand(false);
				} else {
					dealerDone = true;
				}
			}

			System.out.println();
		}

		// print final hands
		me.printHand(true);
		dealer.printHand(true);

		int mySum = me.getHandSum();
		int dealerSum = dealer.getHandSum();

		if ((mySum > dealerSum && mySum <= 21) || dealerSum > 21) {
			System.out.println("Your win!");
			me.WinChip(Integer.parseInt(request.getParameter("wager")));
		} else {
			System.out.println("Dealer wins!");
			me.LoseChip(Integer.parseInt(request.getParameter("wager")));
		}
		
		theDeck.shuffle();

	}

}

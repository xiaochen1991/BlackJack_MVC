package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ConcretPlayer;
import model.Dealer;
import model.Deck;

/**
 * Servlet implementation class Setup
 */
@WebServlet("/Setup")
public class Setup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String PlayerName;
		int DeckNumber;
		
		PlayerName = request.getParameter("playerName");
		DeckNumber = Integer.parseInt(request.getParameter("deckNumber"));
		
		//init Deck and Concretplayer
		
		ConcretPlayer me = new ConcretPlayer(PlayerName);
		Deck theDeck = new Deck(DeckNumber);
		Dealer dealer = new Dealer("Dealer");
		
		request.getSession().setAttribute("me",me);
		request.getSession().setAttribute("theDeck",theDeck);
		request.getSession().setAttribute("dealer",dealer);
		
		response.sendRedirect("Runner.jsp");
		return;
	}

}

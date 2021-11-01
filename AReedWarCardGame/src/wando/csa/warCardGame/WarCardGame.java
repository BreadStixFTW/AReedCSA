package wando.csa.warCardGame;

import java.util.*;

/*
 * Programmer: Alex Reed
 * Date: 10/28/2021
 * Purpose: To have a working War card game that the user can play in a console.
 */

public class WarCardGame {
	public HashMap<String, Integer> deck;
	public ArrayList<String> playerDeck;
	public ArrayList<String> opponentDeck;
	public final String[] suits = {"Spades", "Clubs", "Hearts", "Diamonds"};
	public final String[] cards = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
	
	public WarCardGame() {
		deck = newDeck();
		playerDeck = splitDeck();
		opponentDeck = splitDeck();
	}
	
	// method that searches the suits of a specific card to see which ones haven't been instantiated
	// as new cards
	public AbstractMap.SimpleEntry<String, Integer> searchSuits(HashMap<String, Integer> newDeck, String card, int cardNum) {
		// iterates through the card suits to see if there is a card of the passed in type of card
		// that does not have a version of one of the suits
		for (int i = 0; i < suits.length; i++) {
			// checks to see if newDeck is null
			// if it is, then it is empty and has no cards
			if (newDeck == null) {
				return new AbstractMap.SimpleEntry<String, Integer>(card + " of " + suits[i], cardNum);
			}
			// checks to see if the current suit isn't included yet
			else if (!newDeck.containsKey(card + " of " + suits[i])) {
				return new AbstractMap.SimpleEntry<String, Integer>(card + " of " + suits[i], cardNum);
			}
		}
		// if all of the suits already have cards of the passed in card type,
		// return an already instantiated card
		return new AbstractMap.SimpleEntry<String, Integer>(card + " of " + suits[0], cardNum);
	}
	
	// method that returns a new randomized deck
	public HashMap<String, Integer> newDeck() {
		// card is the random number generator, cardNum is the card value that will be added,
		// newCard is a map entry that will store a new card, and cards is a String array
		// with all of the card names not including suits
		
		// hash map of deck that will be returned
		HashMap<String, Integer> newDeck = new HashMap<String, Integer>();
		// Random object initialized for retrieving random cards
		Random card = new Random();
		// integer for storing a card value 2-14 (14 is the ace, in war ace is higher than all other cards)
		int cardNum;
		// used to store the cards returned from searchSuits()
		Map.Entry<String, Integer> newCard;
		// while loop for adding the cards to the deck
		// keeps looping until all 52 cards are in the deck
		while (newDeck.size() < 52) {
			// gets a number from 2 - 14, which are the numerical values of the cards
			// from the two card to the ace
			cardNum = card.nextInt(13) + 2;
			
			// adds a new card to the deck
			newCard = searchSuits(newDeck, cards[cardNum - 2], cardNum);
			newDeck.put(newCard.getKey(), newCard.getValue());
		}
		return newDeck;
	}
	
	// method that splits the card deck into two decks, one for each player
	// the first deck is the player's deck, and the second deck is the opponent's deck
	public ArrayList<String> splitDeck() {
		ArrayList<String> splitDeck = new ArrayList<String>();
		
		int count = 1;
		
		for (Map.Entry<String, Integer> m : deck.entrySet()) {
			if (count <= 26 && playerDeck == null) {
				splitDeck.add(m.getKey());
			}
			else if (count >= 27 && playerDeck != null) {
				splitDeck.add(m.getKey());
			}
			count++;
		}
		Collections.shuffle(splitDeck);
		return splitDeck;
	}
	
	// method that determines the winner of the current card battle
	public void battle() {
		// put print statements here that tell which current card each player has
		System.out.println("Your current card is the " + playerDeck.get(playerDeck.size() - 1));
		
		System.out.println("Your opponent's card is the " + opponentDeck.get(opponentDeck.size() - 1));
		// checks if the value of the current cards in both player's decks equal each other
		// by getting the value from the current card's name
		// via using the current card's name as a key for the deck hash map
		if (deck.get(playerDeck.get(playerDeck.size() - 1)) == deck.get(opponentDeck.get(opponentDeck.size() - 1))) {
			// passes in the 4th card from the top into the war method
			System.out.println("A war has been started!");
			war(playerDeck.size() - 5, opponentDeck.size() - 5);
		}
		// if the current card of the first deck's value is greater than the other card's value,
		// then the card you won with first gets moved to the bottom of the first deck,
		// then the other card gets added to the bottom of the first deck
		// and the other card also gets removed from the top of the second deck
		else if (deck.get(playerDeck.get(playerDeck.size() - 1)) > deck.get(opponentDeck.get(opponentDeck.size() - 1))) {
			// adds winning card to bottom of winning player's deck
			playerDeck.add(0, playerDeck.get(playerDeck.size() - 1));
			playerDeck.remove(playerDeck.size() - 1);
			
			// adds opponent's card to the bottom of the winning player's deck
			playerDeck.add(0, opponentDeck.get(opponentDeck.size() - 1));
			opponentDeck.remove(opponentDeck.size() - 1);
			
			System.out.println("You won the " + playerDeck.get(0) + " from your opponent! \n");
		}
		// if the current card of the first deck's value is less than the other card's value,
		// then the card your opponent won with first gets moved to the bottom of the second deck,
		// then your card gets added to the bottom of the second deck
		// and your card also gets removed from the top of the first deck
		else {
			// adds winning card to bottom of winning player's deck
			opponentDeck.add(0, opponentDeck.get(opponentDeck.size() - 1));
			opponentDeck.remove(opponentDeck.size() - 1);
						
			// adds opponent's card to the bottom of the winning player's deck
			opponentDeck.add(0, playerDeck.get(playerDeck.size() - 1));
			playerDeck.remove(playerDeck.size() - 1);
			
			System.out.println("You lost your " + opponentDeck.get(0) + " to the opponent! \n");
		}
	}
	
	// method that has the control flow for the positions of the cards in the event of a war
	// determines the outcome of the war
	public void war(int playerIndex, int opponentIndex) {
		// playerIndex and opponentIndex are the positions of their respectful decks' cards that will
		// determine the victor of the war
		
		if (playerIndex >= 0) {
			System.out.println("Your current deciding card for the war is the " + playerDeck.get(playerIndex));
		}
		else {
			System.out.println("Your current deciding card for the war is the " + playerDeck.get(0));
		}
		
		if (opponentIndex >= 0) {
			System.out.println("Your opponent's current deciding card for the war is the " + opponentDeck.get(opponentIndex));
		}
		else {
			System.out.println("Your opponent's current deciding card for the war is the " + opponentDeck.get(opponentIndex));
		}
		
		// checks whether the cards from both decks to that will determine the victor of the war are less than or equal to 0
		// in position, and if they are, then it runs this code, which matters because it has to be checked under
		// these conditions whether or not the war will continue, as if it tries it cannot because
		// there will be no more cards to check the victor of the war
		if (playerIndex <= 0 && opponentIndex <= 0) {
			// if the same card is at the end of the deck for the war and those two cards are reached,
			// then the war is a stale mate and the cards on the top of the players' decks
			// are put on the bottom of their decks to make sure that the war doesn't repeat again
			if (deck.get(playerDeck.get(0)) == deck.get(opponentDeck.get(0))) {
				playerDeck.add(0, playerDeck.get(playerDeck.size() -1));
				playerDeck.remove(playerDeck.size() - 1);
				
				opponentDeck.add(0, opponentDeck.get(opponentDeck.size() -1));
				opponentDeck.remove(opponentDeck.size() - 1);
				
				System.out.println("War ended in a stalemate. \n");
			}
			else if (deck.get(playerDeck.get(0)) > deck.get(opponentDeck.get(0))) {
				System.out.println("You won the war! \n");
				
				warOutcome(true, playerIndex, opponentIndex);
			}
			else {
				System.out.println("You lost the war! \n");
				
				warOutcome(false, playerIndex, opponentIndex);
			}
		}
		// checks whether the card from playerDeck that will determine the victor of the war is less than or equal to 0
		// in position, and if it is, then it runs this code, which matters because it has to be checked under
		// these conditions whether or not the war will continue, as if it tries it cannot because
		// there will be no more cards to check the victor of the war
		else if (playerIndex <= 0 && !(opponentIndex <= 0)) {
			// if the same card is at the end of the deck for the war and those two cards are reached,
			// then the war is a stale mate and the cards on the top of the players' decks
			// are put on the bottom of their decks to make sure that the war doesn't repeat again
			if (deck.get(playerDeck.get(0)) == deck.get(opponentDeck.get(opponentIndex))) {
				playerDeck.add(0, playerDeck.get(playerDeck.size() -1));
				playerDeck.remove(playerDeck.size() - 1);
				
				opponentDeck.add(0, opponentDeck.get(opponentDeck.size() -1));
				opponentDeck.remove(opponentDeck.size() - 1);
				
				System.out.println("War ended in a stalemate. \n");
			}
			else if (deck.get(playerDeck.get(0)) > deck.get(opponentDeck.get(opponentIndex))) {
				System.out.println("You won the war! \n");
				
				warOutcome(true, playerIndex, opponentIndex);
			}
			else {
				System.out.println("You lost the war! \n");
				
				warOutcome(false, playerIndex, opponentIndex);
			}
		}
		// checks whether the card from opponentDeck that will determine the victor of the war is less than or equal to 0
		// in position, and if it is, then it runs this code, which matters because it has to be checked under
		// these conditions whether or not the war will continue, as if it tries it cannot because
		// there will be no more cards to check the victor of the war
		else if (opponentIndex <= 0 && !(playerIndex <= 0)) {
			// if the same card is at the end of the deck for the war and those two cards are reached,
			// then the war is a stale mate and the cards on the top of the players' decks
			// are put on the bottom of their decks to make sure that the war doesn't repeat again
			if (deck.get(opponentDeck.get(0)) == deck.get(playerDeck.get(playerIndex))) {
				playerDeck.add(0, playerDeck.get(playerDeck.size() -1));
				playerDeck.remove(playerDeck.size() - 1);
				
				opponentDeck.add(0, opponentDeck.get(opponentDeck.size() -1));
				opponentDeck.remove(opponentDeck.size() - 1);
				
				System.out.println("War ended in a stalemate. \n");
			}
			else if (deck.get(opponentDeck.get(0)) > deck.get(playerDeck.get(playerIndex))) {
				System.out.println("You lost the war! \n");
				
				warOutcome(false, playerIndex, opponentIndex);
			}
			else {
				System.out.println("You won the war! \n");
				
				warOutcome(true, playerIndex, opponentIndex);
			}
		}
		else {
			// if the cards that will determine the outcome of the war are the same,
			// then another war will be added on top of the current war, which results in 
			// the position of the next deciding cards being 4 cards ahead.
			if (deck.get(playerDeck.get(playerIndex)) == deck.get(opponentDeck.get(opponentIndex))) {
				System.out.println("Another war has been started!");
				
				war(playerIndex - 4, opponentIndex - 4);
			}
			else if (deck.get(playerDeck.get(playerIndex)) > deck.get(opponentDeck.get(opponentIndex))) {
				System.out.println("You won the war! \n");
				
				warOutcome(true, playerIndex, opponentIndex);
			}
			else {
				System.out.println("You lost the war! \n");
				
				warOutcome(false, playerIndex, opponentIndex);
			}
		}
	}
	
	// method that changes the positions of the cards based off of the war outcome from war()
	public void warOutcome(boolean isPlayerDeck, int playerIndex, int opponentIndex) {
		// if playerDeck won
		if (isPlayerDeck) {
			if (playerIndex < 0) {
				// adds all winning cards of playerDeck to the bottom of playerDeck
				// if playerIndex < 0, then that means that there were not enough cards for
				// a full war, so the for loop will just loop to the end of the deck
				for (int i = playerDeck.size() - 1; i >= 0; i--) {
					playerDeck.add(0, playerDeck.get(playerDeck.size() - 1));
					playerDeck.remove(playerDeck.size() - 1);
				}
			}
			else {
				// adds all winning cards of playerDeck to the bottom of playerDeck
				for (int i = playerDeck.size() - 1; i >= playerIndex; i--) {
					playerDeck.add(0, playerDeck.get(playerDeck.size() - 1));
					playerDeck.remove(playerDeck.size() - 1);
				}
			}
			
			// if opponentIndex was less then 0, then when counting down from the top card
			// go to the end of the deck at index 0
			// as there were not enough cards at the end of opponentDeck
			// so opponentIndex got set past opponentDeck
			if (opponentIndex < 0) {
				// adds won cards to playerDeck
				for (int i = opponentDeck.size() - 1; i >= 0; i--) {
					playerDeck.add(0, opponentDeck.get(i));
					opponentDeck.remove(i);
				}
			}
			else {
				// adds won cards to playerDeck
				for (int i = opponentDeck.size() - 1; i >= opponentIndex; i--) {
					playerDeck.add(0, opponentDeck.get(i));
					opponentDeck.remove(i);
				}
			}
		}
		// if opponentDeck won
		else {
			if (opponentIndex < 0) {
				// adds all winning cards of opponentDeck to the bottom of opponentDeck
				// if playerIndex < 0, then that means that there were not enough cards for
				// a full war, so the for loop will just loop to the end of the deck
				for (int i = opponentDeck.size() - 1; i >= 0; i--) {
					opponentDeck.add(0, opponentDeck.get(opponentDeck.size() - 1));
					opponentDeck.remove(opponentDeck.size() - 1);
				}
			}
			else {
				// adds all winning cards of opponentDeck to the bottom of opponentDeck
				for (int i = opponentDeck.size() - 1; i >= opponentIndex; i--) {
					opponentDeck.add(0, opponentDeck.get(opponentDeck.size() - 1));
					opponentDeck.remove(opponentDeck.size() - 1);
				}
			}
			
			// if playerIndex was less then 0, then when counting down from the top card
			// go to the end of the deck at index 0
			// as there were not enough cards at the end of playerDeck
			// so playerIndex got set past playerDeck
			if (playerIndex < 0) {
				// adds won cards to opponentDeck
				for (int i = playerDeck.size() - 1; i >= 0; i--) {
					opponentDeck.add(0, playerDeck.get(i));
					playerDeck.remove(i);
				}
			}
			else {
				// adds won cards to opponentDeck
				for (int i = playerDeck.size() - 1; i >= playerIndex; i--) {
					opponentDeck.add(0, playerDeck.get(i));
					playerDeck.remove(i);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// instantiate a new WarCardGame object
		WarCardGame war = new WarCardGame();
		
		// Scanner object for input that will stop when a user wants to flip a card
		// and when a user wants to see the opponent's card flipped
		Scanner input = new Scanner(System.in);
	
		boolean decMade = false;
		
		while (war.playerDeck.size() > 0 && war.opponentDeck.size() > 0) {
			System.out.println("You have " + war.playerDeck.size() + " cards.");
			
			System.out.println("Your current cards from top to bottom of the deck are: ");
			
			for (int i = war.playerDeck.size() - 1; i >= 0; i--) {
				System.out.print(war.playerDeck.get(i));
				if (i > 0) {
					System.out.print(", ");
				}
				else {
					System.out.println("");
				}
			}
			
			System.out.println("Type \"flip\" to flip your card.");
			String response = input.next();
			do {
				switch(response) {
				case "flip":
					war.battle();
					decMade = true;
					break;
				default:
					System.out.println("Please enter \"flip\"");
				}
			} while(!decMade);
		}
		
		if (war.opponentDeck.size() == 0) {
			System.out.println("You won the war against your opponent! Yay!");
		}
		else {
			System.out.println("You lost the war to your opponent! Try again next time.");
		}
	}
}

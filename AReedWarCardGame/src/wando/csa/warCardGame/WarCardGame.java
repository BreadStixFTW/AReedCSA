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
			
			System.out.println(cardNum);
			
			// adds a new card to the deck
			newCard = searchSuits(newDeck, cards[cardNum - 2], cardNum);
			newDeck.put(newCard.getKey(), newCard.getValue());
		}
		System.out.println(newDeck);
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
			// call war method
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
			
			System.out.println("You won the " + playerDeck.get(0) + " from your opponent!");
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
			
			System.out.println("You lost your " + opponentDeck.get(0) + " to the opponent!");
		}
	}
	
	public static void main(String[] args) {
		// instantiate a new WarCardGame object
		WarCardGame war = new WarCardGame();
		
		// Scanner object for input that will stop when a user wants to flip a card
		// and when a user wants to see the opponent's card flipped
		Scanner input = new Scanner(System.in);
		
		// test print to see the player decks' cards
//		for (int i = 0; i < war.playerDecks.get(0).size(); i++) {
//			System.out.println(war.playerDecks.get(0).get(i));
//		}
//		
//		for (int i = 0; i < war.playerDecks.get(1).size(); i++) {
//			System.out.println(war.playerDecks.get(1).get(i));
//		}
		boolean decMade = false;
		
		while (war.playerDeck.size() > 0 && war.opponentDeck.size() > 0) {
			System.out.println("You have " + war.playerDeck.size() + " cards.");
			
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
	}
}

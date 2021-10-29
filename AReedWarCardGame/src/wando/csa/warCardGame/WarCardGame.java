package wando.csa.warCardGame;

import java.util.*;

/*
 * Programmer: Alex Reed
 * Date: 10/28/2021
 * Purpose: To have a working War card game that the user can play in a console.
 */

public class WarCardGame {
	public HashMap<String, Integer> deck;
	public ArrayList<ArrayList<String>> playerDecks;
	public final String[] suits = {"Spades", "Clubs", "Hearts", "Diamonds"};
	public final String[] cards = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
	
	public WarCardGame() {
		deck = newDeck();
		playerDecks = playerDecks();
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
			cardNum = card.nextInt(13) + 2;
			
			// switch statement with cases for values ranging from 2 - 14
			// these are the card values that will be used in the game
			switch (cardNum) {
			case 2:
				newCard = searchSuits(newDeck, cards[0], cardNum);
				newDeck.put(newCard.getKey(), newCard.getValue());
				break;
			case 3:
				newCard = searchSuits(newDeck, cards[1], cardNum);
				newDeck.put(newCard.getKey(), newCard.getValue());
				break;
			case 4:
				newCard = searchSuits(newDeck, cards[2], cardNum);
				newDeck.put(newCard.getKey(), newCard.getValue());
				break;
			case 5:
				newCard = searchSuits(newDeck, cards[3], cardNum);
				newDeck.put(newCard.getKey(), newCard.getValue());
				break;
			case 6:
				newCard = searchSuits(newDeck, cards[4], cardNum);
				newDeck.put(newCard.getKey(), newCard.getValue());
				break;
			case 7:
				newCard = searchSuits(newDeck, cards[5], cardNum);
				newDeck.put(newCard.getKey(), newCard.getValue());
				break;
			case 8:
				newCard = searchSuits(newDeck, cards[6], cardNum);
				newDeck.put(newCard.getKey(), newCard.getValue());
				break;
			case 9:
				newCard = searchSuits(newDeck, cards[7], cardNum);
				newDeck.put(newCard.getKey(), newCard.getValue());
				break;
			case 10:
				newCard = searchSuits(newDeck, cards[8], cardNum);
				newDeck.put(newCard.getKey(), newCard.getValue());
				break;
			case 11:
				newCard = searchSuits(newDeck, cards[9], cardNum);
				newDeck.put(newCard.getKey(), newCard.getValue());
				break;
			case 12:
				newCard = searchSuits(newDeck, cards[10], cardNum);
				newDeck.put(newCard.getKey(), newCard.getValue());
				break;
			case 13:
				newCard = searchSuits(newDeck, cards[11], cardNum);
				newDeck.put(newCard.getKey(), newCard.getValue());
				break;
			case 14:
				newCard = searchSuits(newDeck, cards[12], cardNum);
				newDeck.put(newCard.getKey(), newCard.getValue());
				break;
			default:
				// two is default card
				newDeck.put("Two of Spades", 2);
				break;
			}
		}
		return newDeck;
	}
	
	// method that splits the card deck into two decks, one for each player
	public ArrayList<ArrayList<String>> playerDecks() {
		ArrayList<ArrayList<String>> playerDecks = new ArrayList();
		playerDecks.add(new ArrayList());
		playerDecks.add(new ArrayList());
		int count = 1;
		
		for (Map.Entry<String, Integer> m : deck.entrySet()) {
			if (count <= 26) {
				playerDecks.get(0).add(m.getKey());
			}
			else {
				playerDecks.get(1).add(m.getKey());
			}
			count++;
		}
		return playerDecks;
	}
	
	// method that determines the winner of the current card battle
	public void battle() {
		// put print statements here that tell which current card each player has
		
		// checks if the value of the current cards in both player's decks equal each other
		// by getting the value from the current card's name
		// via using the current card's name as a key for the deck hash map
		if (deck.get(playerDecks.get(0).get(playerDecks.get(0).size() - 1)) == deck.get(playerDecks.get(1).get(playerDecks.get(1).size() - 1))) {
			// call war method
		}
		// if the current card of the first deck's value is greater than the other card's value,
		// then the other card gets added to the bottom of the first deck
		// and the other card also gets removed from the top of the second deck
		else if (deck.get(playerDecks.get(0).get(playerDecks.get(0).size() - 1)) > deck.get(playerDecks.get(1).get(playerDecks.get(1).size() - 1))) {
			playerDecks.get(0).add(playerDecks.get(1).get(playerDecks.get(1).size() - 1));
			playerDecks.get(1).remove(playerDecks.get(1).size() - 1);
			
			System.out.println("You won the " + playerDecks.get(0).get(playerDecks.get(0).size() - 1) + "!");
		}
		else {
			playerDecks.get(1).add(playerDecks.get(0).get(playerDecks.get(0).size() - 1));
			playerDecks.get(0).remove(playerDecks.get(0).size() - 1);
			
			System.out.println("You lost your " + playerDecks.get(1).get(playerDecks.get(1).size() - 1) + "!");
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
		while (war.playerDecks.get(0).size() > 0 && war.playerDecks.get(1).size() > 0) {
			System.out.println("You have " + war.playerDecks.get(0).size() + " cards.");
			
			System.out.println("Type \"flip\" to flip your card.");
			String response = input.next();
			do {
				switch(response) {
				case "input":
					war.battle();
					decMade = true;
					break;
				default:
					
				}
			} while(!decMade);
		}
	}
}

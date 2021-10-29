package wando.csa.warCardGame;

import java.util.*;

/*
 * Programmer: Alex Reed
 * Date: 10/28/2021
 * Purpose: To have a working War card game that the user can play in a console.
 */

public class WarCardGame {
	public HashMap<String, Integer> deck;
	public final String[] suits = {"Spades", "Clubs", "Hearts", "Diamonds"};
	public final String[] cards = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
	
	public WarCardGame() {
		deck = newDeck();
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
	public static void main(String[] args) {
		// instantiate a new WarCardGame object
		WarCardGame war = new WarCardGame();
		
		// test print to see if there are 52 different cards
		for (Map.Entry<String, Integer> m : war.deck.entrySet()) {
			System.out.println("Card: " + m.getKey() + " " + "Card Value: " + m.getValue());
		}
		System.out.println(war.deck.size());
	}
}

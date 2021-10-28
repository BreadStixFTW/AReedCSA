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
		// if all of the other suits of the cards that was passed in were filled, then loop through the cards in front
		// this is to avoid returning something like a null map entry
		// and also to catch any missing cards at the end of newDeck()
		for (int i = 0; i < cards.length; i++) {
			if (card == cards[i] && i + 1 <= cards.length - 1) {
					return searchSuits(newDeck, cards[i + 1], cardNum + 1);
			}
		}
		// if all of the cards in front had their suits filled, then return a filled suit
		return new AbstractMap.SimpleEntry<String, Integer>(card + " of " + suits[0], cardNum);
	}
	
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
		// for loop for adding the cards to the deck
		for (int i = 0; i < 52; i++) {
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
		// catches any missing cards that did not get added to the deck
		while (newDeck.size() < 52) {
			// uses recursion to keep going until it finds a card
			// if it finds a card, it adds the card to the deck
			// will keep using recursion to find all of the cards
			// until newDeck has 52 cards inside of it
			newCard = searchSuits(newDeck, cards[0], 2);
			newDeck.put(newCard.getKey(), newCard.getValue());
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

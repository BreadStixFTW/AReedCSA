package wando.csa.warCardGame;

import java.util.*;

/*
 * Programmer: Alex Reed
 * Date: 10/28/2021
 * Purpose: To have a working War card game that the user can play in a console.
 */

public class WarCardGame {
	public static HashMap<String, Integer> newDeck() {
		// hash map initialized at 52 because the size of a deck is 52 cards
		HashMap<String, Integer> deck = new HashMap<String, Integer>(52);
		// Random object initialized for retrieving random cards
		Random card = new Random();
		// integer for storing a card value 2-14 (14 is the ace, in war ace is higher than all other cards)
		int cardNum;
		// for loop for adding the cards to the deck
		for (int i = 0; i < deck.size(); i++) {
			cardNum = card.nextInt(13) + 2;
			
			switch (cardNum) {
			case 2:
				deck.put("Two", 2);
				break;
			case 3:
				deck.put("Three", 3);
				break;
			case 4:
				deck.put("Four", 4);
				break;
			case 5:
				deck.put("Five", 5);
				break;
			case 6:
				deck.put("Six", 6);
				break;
			case 7:
				deck.put("Seven", 7);
				break;
			case 8:
				deck.put("Eight", 8);
				break;
			case 9:
				deck.put("Nine", 9);
				break;
			case 10:
				deck.put("Ten", 10);
				break;
			case 11:
				deck.put("Jack", 11);
				break;
			case 12:
				deck.put("Queen", 12);
				break;
			case 13:
				deck.put("King", 13);
				break;
			case 14:
				deck.put("Ace", 14);
				break;
			default:
				// two is default card
				deck.put("Two", 2);
				break;
			}
		}
		return deck;
	}
	public static void main(String[] args) {
		HashMap<String, Integer> cardDeck = newDeck();
		
		for (Map.Entry m : cardDeck.entrySet()) {
			System.out.println("Card: " + m.getKey() + " " + "Card Value: " + m.getValue());
		}
	}
}

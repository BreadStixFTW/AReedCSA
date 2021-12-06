package wando.csa.pokeProj;

import java.lang.Math.*;

/*
 * Programmer: Alex Reed
 * Date: 12/6/2021
 * Purpose: To create a project that uses classes to model a Pokemon game
 */

class Pokemon {
	private boolean isFishing;
	private boolean isFighting;
	private int hitPoints;
	
	public Pokemon(boolean isFishing, boolean isFighting, int hitPoints) {
		this.isFishing = isFishing;
		this.isFighting = isFighting;
		
		if (hitPoints > 255) {
			hitPoints = 255;
		}
		
		this.hitPoints = hitPoints;
	}
	
	public void damage(int amountOfDamage) {
		this.hitPoints -= amountOfDamage;
	}
	
	public int getHP() {
		return this.hitPoints;
	}
	
	public String toString() {
		return this.hitPoints + " hitpoints.";
	}
}

class Trainer {
	private String firstName;
	private String lastName;
	private char midInitial;
	private boolean playedGame;
}

public class PokeProj {
	public static void main(String[] args) {
		// create new Pokemon objects
		// neither pokemon is fishing or fighting, so false for both those fields
		// charmander's hp is 39, while raichu's hp is 60, hence those values for each Pokemon's respective hp field
		Pokemon charmander = new Pokemon(false, false, 39);
		Pokemon raichu = new Pokemon(false, false, 60);
		
		raichu.damage(10);
		
		System.out.println("Charmander has " + charmander);
		System.out.println("Raichu has " + raichu);
		
		System.out.println("Difference of hp is " + Math.abs(charmander.getHP() - raichu.getHP()));
	}
}

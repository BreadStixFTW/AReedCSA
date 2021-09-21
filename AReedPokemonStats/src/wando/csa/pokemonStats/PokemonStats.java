package wando.csa.pokemonStats;

/*
 * Programmer: Alex Reed
 * Date: 9/21/2021
 * Purpose: To return a Pokemon's stats for Attack and HP at level 100.
 */

public class PokemonStats {
	public static int attackStat(int baseAttack) {
		return baseAttack * 2 + 5;
	}
	
	public static int hpStat(int baseHP) {
		return 110 + baseHP * 2;
	}
	
	public static void main(String[] args) {
		// will be using Raichu's stats for this example
		int attack = 90;
		int hp = 60;
		
		int level100Attack = attackStat(attack);
		int level100HP = hpStat(hp);
		
		System.out.println("Raichu's Level 100 Attack: " + level100Attack);
		System.out.println("Raichu's Level 100 HP: " + level100HP);
	}
}

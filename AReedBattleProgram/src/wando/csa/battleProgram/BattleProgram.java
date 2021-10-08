package wando.csa.battleProgram;

import java.util.*;
import java.lang.Math.*;

/*
 * Programmer: Alex Reed
 * Date: 10/6/2021
 * Purpose: To simulate a Pokemon battle and Pokemon stats by asking for user input and giving output based on that input.
 */

public class BattleProgram {
	public static String battleStart() {
		Scanner input = new Scanner(System.in);
		String pokemonName;
		
		System.out.println("----------Battle----------");
		System.out.println("Another trainer is issuing a challenge!");
		System.out.println("Zebstrika appeared.");
		System.out.println("Which Pokemon do you choose?");
		
		pokemonName = input.nextLine();
		
		System.out.println("You chose " + pokemonName + "!");
		System.out.println("It's a Pokemon battle between " + pokemonName + " and Zebstrika! Go!\n");
		
		return pokemonName;
	}
	
	public static double[] damage(String pokemonName) {
		Scanner input = new Scanner(System.in);
		double modifier;
		double damage;
		double level, attack, defense, base, stab, hp;
		double[] stats = new double[7];
		
		System.out.println("----------Damage----------");
		System.out.println("Zebstrika used Thunderbolt!");
		System.out.println("Trainer, what are your " + pokemonName + "'s stats? Input each stat in order.");
		
		System.out.println("Level:");
		level = input.nextDouble();
		
		System.out.println("Attack:");
		attack = input.nextDouble();
		
		System.out.println("Defense:");
		defense = input.nextDouble();
		
		System.out.println("Base:");
		base = input.nextDouble();
		
		System.out.println("STAB:");
		stab = input.nextDouble();
		
		System.out.println("HP:");
		hp = input.nextDouble();
		
		modifier = stab * ((Math.random() * 0.15) + 0.85);
		damage = Math.floor(((((2 * level + 10) / 250) + (attack / defense)) * base + 2) * modifier);
		
		hp = Math.floor(hp - damage);
		
		System.out.println(pokemonName + " sustained " + damage + " points damage.");
		System.out.println("HP, after damage, are now " + hp + ".\n");
		
		// these stats will be accessed in this order for the statsTable() method
		stats[0] = level;
		stats[1] = attack;
		stats[2] = defense;
		stats[3] = hp;
		
		return stats;
	}
	
	public static void statsTable(String pokemonName, double[] pokemonStats, String[] pokemonMoves) {
		System.out.println("----------Stats----------");
		System.out.println("Name:     " + pokemonName);
		System.out.println("Level:     " + pokemonStats[0]);
		System.out.println("------------------------------");
		System.out.println("HP:     " + pokemonStats[3]);
		System.out.println("ATTACK:     " + pokemonStats[1]);
		System.out.println("DEFENSE:     " + pokemonStats[2]);
		System.out.println("SP. ATK:     " + pokemonStats[4]);
		System.out.println("SP. DEF:     " + pokemonStats[5]);
		System.out.println("SPEED:     " + pokemonStats[6]);
		System.out.println("------------------------------");
		System.out.println("Moves Learned: " + pokemonMoves[0] + ", " + pokemonMoves[1] + ", " + pokemonMoves[2] + ", " + pokemonMoves[3]);
	}
	
	public static void main(String[] args) {
		String pokemonName = battleStart();
		double[] pokemonStats = damage(pokemonName);
		
		// extra stats for statsTable()
		pokemonStats[4] = 121; // Alakazam's special attack
		pokemonStats[5] = 81; // Alakazam's special defense
		pokemonStats[6] = 107; // Alakazam's speed
		
		// resetting Alakazam's health
		pokemonStats[3] = 96;
		
		// for Alakazam:
		String[] pokemonMoves = {"Thunder Wave", "Hidden Power", "Psycho Cut", "Recover"};
		
		statsTable(pokemonName, pokemonStats, pokemonMoves);
	}
}

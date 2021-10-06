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
		double[] stats = new double[6];
		
		System.out.println("----------Damage----------");
		System.out.println("Zebstrika used Thunderbolt!");
		System.out.println("Trainer, what are your Arcanine's stats? Input each stat in order.");
		System.out.println("Level:");
		System.out.println("Attack:");
		System.out.println("Defense:");
		System.out.println("Base:");
		System.out.println("STAB:");
		System.out.println("HP:");
		
		level = input.nextDouble();
		attack = input.nextDouble();
		defense = input.nextDouble();
		base = input.nextDouble();
		stab = input.nextDouble();
		hp = input.nextDouble();
		
		modifier = stab * ((Math.random() * 1.15) + 0.85);
		damage = ((((2 * level + 10) / 250) + (attack / defense)) * base + 2) * modifier;
		
		hp = hp - damage;
		
		System.out.println(pokemonName + " sustained " + damage + " points damage.");
		System.out.println("HP, after damage, are now " + hp + ".");
		
		stats[0] = level;
		stats[1] = attack;
		stats[2] = defense;
		stats[3] = base;
		stats[4] = stab;
		stats[5] = hp;
		
		return stats;
	}
	
	public static void main(String[] args) {
		String pokemonName = battleStart();
		double[] stats = damage(pokemonName);
	}
}

package wando.csa.mlpProject;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

/*
 * Programmer: Alex Reed
 * Date: 9/22/2021
 * Purpose: To calculate various distances from a road trip in Equestria.
 */

public class MLPProject {
	public static double roadTrip(double diameter) {
		return Math.PI * diameter;
	}
	
	public static double distance(int x1, int x2, int y1, int y2) {
		return sqrt(pow((x2 - x1), 2) + pow((y2 - y1), 2));
	}
	
	public static void threeStopTour(double distance1, double distance2, double distance3) {
		System.out.println("Distance 1: " + distance1);
		System.out.println("Distance 2: " + distance2);
		System.out.println("Distance 3: " + distance3);
	}
	
	public static double totalTrip(int[][] coordinates) {
		double ret = 0;
		
		for (int i = 0; i < coordinates.length; i++) {
			if (i == coordinates.length - 1) {
				ret += distance(coordinates[i][0], coordinates[i][1], coordinates[0][0], coordinates[0][1]);
			}
			else {
				ret += distance(coordinates[i][0], coordinates[i][1], coordinates[i + 1][0], coordinates[i + 1][1]);
			}
		}
		return ret;
	}
	
	public static void main(String[] args) {
		// Exercise 1
		System.out.println("Circular Path Distance: " + roadTrip(10));
		
		// Exercise 2
		System.out.println("Distance from Baltimare (29, 16) to Manehattan (34, 8): " + distance(29, 16, 34, 8));
		System.out.println("Distance from Los Pegasus (6, 19) to Neighagra Falls (22, 7): " + distance(6, 19, 22, 7));
		System.out.println("Distance from the Badlands (25, 24) to Ponyville (16, 14): " + distance(25, 24, 16, 14));
		
		// Exercise 3
		// same distances as exercise 2
		double stop1 = distance(29, 16, 34, 8);
		double stop2 = distance(6, 19, 22, 7);
		double stop3 = distance(25, 24, 16, 14);
		
		threeStopTour(stop1, stop2, stop3);
		
		// Exercise 4
		// same coordinates as exercise 2, except only Baltimare, Los Pegasus, and the Badlands
		int[][] coordinates = {{29, 16}, {6, 19}, {25, 24}}; 
		
		System.out.println("Total Trip Distance Between Baltimare, Los Pegasus, and the Badlands: " + totalTrip(coordinates));
	}
}

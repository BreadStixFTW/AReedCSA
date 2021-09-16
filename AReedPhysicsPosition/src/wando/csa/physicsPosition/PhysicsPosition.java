package wando.csa.physicsPosition;

/*
 * Programmer: Alex Reed
 * Date: 9/15/2021
 * Purpose: To calculate and print out the position of a body based off of the values given.
 */

public class PhysicsPosition {
	public static void main(String[] args) {
		double time = 5; // in seconds
		double initialPosition = 10; // in meters
		double initialVelocity = 15; // in meters per second
		double rateOfAccel = 20; // in m/s^2
		
		double position = (initialPosition + initialVelocity) + (((1/2) * rateOfAccel) * (time * time));
		
		System.out.println("Position: " + position + " meters");
	}
}

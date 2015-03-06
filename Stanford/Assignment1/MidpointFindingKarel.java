/*
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends SuperKarel {
	public void run(){
	markWalls();
	findMiddle();
	turnAround();
	move();
	//Now you're in the middle
	collectBeepersToEast();
	//You're back in the middle again
	collectBeepersToWest();
	goToMiddle();
	}

private void markWalls(){
	//We need to put a beeper on the farthest east and west corners
	while(frontIsClear()){
		move();
	}
	putBeeper();
	turnAround();
	while(frontIsClear()){
		move();
	}
	putBeeper();
	turnAround();
	move();
}


private void findMiddle(){
	//Bounces back and forth between the widest beepers, laying one down at the next clear inward corner
	//Ends up in the middle, facing east, standing on a beeper
	while (frontIsClear() && noBeepersPresent()){
		move();
	}
	turnAround();
	move();
	putBeeper();
	move();
	while (noBeepersPresent()){
		move();
		findMiddle();
	}
}

private void collectBeepersToEast(){
	//Moves from the middle beeper to the east wall
	//Collecting all beepers along the way
	//Then moves back to the middle beeper, and stands on it facing west
	while (frontIsClear()){
		move();
		pickBeeper();
	}
	turnAround();
	while (noBeepersPresent()){
		move();
	}
}

private void collectBeepersToWest(){
	//Starts standing on the middle beeper facing west
	//Gathers all of the beepers, then turns around
	while(frontIsClear()){
		move();
		pickBeeper();
	}
	turnAround();
}

private void goToMiddle(){
	//Goes back to the beeper in the middle
	while(noBeepersPresent()){
		move();
	}
}
}